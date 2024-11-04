package com.dkd.manage.service.impl;

import java.util.List;
import com.dkd.common.utils.DateUtils;
import com.dkd.manage.domain.vo.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbTaskMapper;
import com.dkd.manage.domain.TbTask;
import com.dkd.manage.service.ITbTaskService;

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
}
