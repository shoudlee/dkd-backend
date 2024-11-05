package com.dkd.manage.service.impl;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.dkd.common.constant.DkdConstants;
import com.dkd.common.constant.DkdContants;
import com.dkd.common.exception.ServiceException;
import com.dkd.common.utils.DateUtils;
import com.dkd.manage.domain.TbEmp;
import com.dkd.manage.domain.TbTaskDetails;
import com.dkd.manage.domain.TbVendingMachine;
import com.dkd.manage.domain.dto.TaskDetailsDto;
import com.dkd.manage.domain.dto.TaskDto;
import com.dkd.manage.domain.vo.TaskVo;
import com.dkd.manage.service.ITbEmpService;
import com.dkd.manage.service.ITbTaskDetailsService;
import com.dkd.manage.service.ITbVendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbTaskMapper;
import com.dkd.manage.domain.TbTask;
import com.dkd.manage.service.ITbTaskService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 工单表Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
@Service
public class TbTaskServiceImpl implements ITbTaskService 
{
    @Autowired
    private TbTaskMapper tbTaskMapper;

    /**
     * 查询工单表
     * 
     * @param taskId 工单表主键
     * @return 工单表
     */
    @Override
    public TbTask selectTbTaskByTaskId(Long taskId)
    {
        return tbTaskMapper.selectTbTaskByTaskId(taskId);
    }

    /**
     * 查询工单表列表
     * 
     * @param tbTask 工单表
     * @return 工单表
     */
    @Override
    public List<TbTask> selectTbTaskList(TbTask tbTask)
    {
        return tbTaskMapper.selectTbTaskList(tbTask);
    }

    /**
     * 新增工单表
     * 
     * @param tbTask 工单表
     * @return 结果
     */
    @Override
    public int insertTbTask(TbTask tbTask)
    {
        tbTask.setCreateTime(DateUtils.getNowDate());
        return tbTaskMapper.insertTbTask(tbTask);
    }

    /**
     * 修改工单表
     * 
     * @param tbTask 工单表
     * @return 结果
     */
    @Override
    public int updateTbTask(TbTask tbTask)
    {
        tbTask.setUpdateTime(DateUtils.getNowDate());
        return tbTaskMapper.updateTbTask(tbTask);
    }

    /**
     * 批量删除工单表
     * 
     * @param taskIds 需要删除的工单表主键
     * @return 结果
     */
    @Override
    public int deleteTbTaskByTaskIds(Long[] taskIds)
    {
        return tbTaskMapper.deleteTbTaskByTaskIds(taskIds);
    }

    /**
     * 删除工单表信息
     * 
     * @param taskId 工单表主键
     * @return 结果
     */
    @Override
    public int deleteTbTaskByTaskId(Long taskId)
    {
        return tbTaskMapper.deleteTbTaskByTaskId(taskId);
    }


    @Override
    public List<TaskVo> selectTaskVoList(TbTask task) {
        return tbTaskMapper.selectTaskVoList(task);
    }

    @Autowired
    private ITbVendingMachineService vendingMachineService;

    @Autowired
    private ITbEmpService empService;

    @Autowired
    private ITbTaskDetailsService taskDetailsService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 新增运营、运维工单
     *
     * @param taskDto
     * @return 结果
     */
    @Transactional
    @Override
    public int insertTaskDto(TaskDto taskDto) {
        //1. 查询售货机是否存在
        TbVendingMachine vm = vendingMachineService.getTbVendingMachineByInnerCode(taskDto.getInnerCode());
        if (vm == null) {
            throw new ServiceException("设备不存在");
        }
        //2. 校验售货机状态与工单类型是否相符
        checkCreateTask(vm.getVmStatus(), taskDto.getProductTypeId());
        //3. 检查设备是否有未完成的同类型工单
        hasTask(taskDto.getInnerCode(), taskDto.getProductTypeId());
        //4. 查询并校验员工是否存在
        TbEmp emp = empService.selectTbEmpById(taskDto.getUserId());
        if (emp == null) {
            throw new ServiceException("员工不存在");
        }
        //5. 校验员工区域是否匹配
        if (!emp.getRegionId().equals(vm.getRegionId())) {
            throw new ServiceException("员工区域与设备区域不一致，无法处理此工单");
        }
        //6. 将dto转为po并补充属性，保存工单
        TbTask task = BeanUtil.copyProperties(taskDto, TbTask.class);// 属性复制
        task.setTaskStatus(DkdConstants.TASK_STATUS_CREATE);// 创建工单
        task.setUserName(emp.getUserName());// 执行人名称
        task.setRegionId(vm.getRegionId());// 所属区域id
        task.setAddr(vm.getAddr());// 地址
        task.setCreateTime(DateUtils.getNowDate());// 创建时间
        task.setTaskCode(generateTaskCode());// 工单编号
        int taskResult = tbTaskMapper.insertTbTask(task);
        //7. 判断是否为补货工单
        if (taskDto.getProductTypeId().equals(DkdConstants.TASK_TYPE_SUPPLY)) {
            // 8.保存工单详情
            List<TaskDetailsDto> details = taskDto.getDetails();
            if (CollUtil.isEmpty(details)) {
                throw new ServiceException("补货工单详情不能为空");
            }
            // 将dto转为po补充属性
            List<TbTaskDetails> taskDetailsList = details.stream().map(dto -> {
                TbTaskDetails taskDetails = BeanUtil.copyProperties(dto, TbTaskDetails.class);
                taskDetails.setTaskId(task.getTaskId());
                return taskDetails;
            }).collect(Collectors.toList());
            // 批量新增
            taskDetailsService.batchInsertTaskDetails(taskDetailsList);
        }

        return taskResult;
    }

    @Override
    public int cancelTask(TbTask task) {
        //1. 判断工单状态是否可以取消
        // 先根据工单id查询数据库
        TbTask taskDb = tbTaskMapper.selectTbTaskByTaskId(task.getTaskId());
        // 判断工单状态是否为已取消，如果是，则抛出异常
        if (taskDb.getTaskStatus().equals(DkdConstants.TASK_STATUS_CANCEL)) {
            throw new ServiceException("该工单已取消了，不能再次取消");
        }
        // 判断工单状态是否为已完成，如果是，则抛出异常
        if (taskDb.getTaskStatus().equals(DkdConstants.TASK_STATUS_FINISH)) {
            throw new ServiceException("该工单已完成了，不能取消");
        }
        //2. 设置更新字段
        task.setTaskStatus(DkdConstants.TASK_STATUS_CANCEL);// 工单状态：取消
        task.setUpdateTime(DateUtils.getNowDate());// 更新时间
        //3. 更新工单
        return tbTaskMapper.updateTbTask(task);// 注意别传错了，这里是前端task参数
    }

    /**
     * 生成并获取当天任务代码的唯一标识。
     * 该方法首先尝试从Redis中获取当天的任务代码计数，如果不存在，则初始化为1并返回"日期0001"格式的字符串。
     * 如果存在，则对计数加1并返回更新后的任务代码。
     *
     * @return 返回当天任务代码的唯一标识，格式为"日期XXXX"，其中XXXX是四位数字的计数。
     */
    public String generateTaskCode() {
        // 获取当前日期并格式化为"yyyyMMdd"
        String dateStr = DateUtils.getDate().replaceAll("-", "");
        // 根据日期生成redis的键
        String key = "dkd.task.code." + dateStr;
        // 判断key是否存在
        if (!redisTemplate.hasKey(key)) {
            // 如果key不存在，设置初始值为1，并指定过期时间为1天
            redisTemplate.opsForValue().set(key, 1, Duration.ofDays(1));
            // 返回工单编号（日期+0001）
            return dateStr + "0001";
        }
        // 如果key存在，计数器+1（0002），确保字符串长度为4位
        return dateStr+ StrUtil.padPre(redisTemplate.opsForValue().increment(key).toString(),4,'0');
    }

    /**
     * 检查设备是否已有未完成的同类型工单。
     * 本方法用于在创建新工单前，验证指定设备是否已经有处于进行中的同类型工单。
     * 如果存在未完成的同类型工单，则抛出服务异常，阻止新工单的创建。
     *
     * @param innerCode     设备的内部编码，用于唯一标识设备。
     * @param productTypeId 任务的类型，决定任务的性质（投放、维修、补货、撤机）。
     */
    private void hasTask(String innerCode, Long productTypeId) {
        // 创建Task对象，并设置设备编号和工单类型ID，以及任务状态为进行中
        TbTask taskParam = new TbTask();
        taskParam.setInnerCode(innerCode);
        taskParam.setProductTypeId(productTypeId);
        taskParam.setTaskStatus(DkdConstants.TASK_STATUS_PROGRESS);

        // 查询数据库中符合指定条件的工单列表
        List<TbTask> taskList = tbTaskMapper.selectTbTaskList(taskParam);

        // 如果存在未完成的同类型工单，则抛出服务异常
        if (CollUtil.isNotEmpty(taskList)) {
            throw new ServiceException("该设备有未完成的同类型工单，不能重复创建");
        }
    }

    /**
     * 根据设备的状态和任务类型，验证是否可以创建相应的任务。
     * 如果条件不满足，抛出服务异常。
     *
     * @param vmStatus      设备的状态，表示设备是否在运行。
     * @param productTypeId 任务的类型，决定任务的性质（投放、维修、补货、撤机）。
     */
    private void checkCreateTask(Long vmStatus, Long productTypeId) {
        // 如果是投放工单，且设备状态为运行中，则抛出异常，因为设备已在运营中无法进行投放
        if (productTypeId == DkdConstants.TASK_TYPE_DEPLOY && vmStatus == DkdConstants.VM_STATUS_RUNNING) {
            throw new ServiceException("该设备状态为运行中，无法进行投放");
        }

        // 如果是维修工单，且设备状态不是运行中，则抛出异常，因为设备不在运营中无法进行维修
        if (productTypeId == DkdConstants.TASK_TYPE_REPAIR && vmStatus != DkdConstants.VM_STATUS_RUNNING) {
            throw new ServiceException("该设备状态不是运行中，无法进行维修");
        }

        // 如果是补货工单，且设备状态不是运行中，则抛出异常，因为设备不在运营状态无法进行补货
        if (productTypeId == DkdConstants.TASK_TYPE_SUPPLY && vmStatus != DkdConstants.VM_STATUS_RUNNING) {
            throw new ServiceException("该设备状态不是运行中，无法进行补货");
        }

        // 如果是撤机工单，且设备状态不是运行中，则抛出异常，因为设备不在运营状态无法进行撤机
        if (productTypeId == DkdConstants.TASK_TYPE_REVOKE && vmStatus != DkdConstants.VM_STATUS_RUNNING) {
            throw new ServiceException("该设备状态不是运行中，无法进行撤机");
        }
    }



}
