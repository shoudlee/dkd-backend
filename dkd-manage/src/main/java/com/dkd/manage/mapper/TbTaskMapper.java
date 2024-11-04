package com.dkd.manage.mapper;

import java.util.List;
import com.dkd.manage.domain.TbTask;
import com.dkd.manage.domain.vo.TaskVo;

/**
 * 工单表Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
public interface TbTaskMapper 
{
    /**
     * 查询工单表
     * 
     * @param taskId 工单表主键
     * @return 工单表
     */
    public TbTask selectTbTaskByTaskId(Long taskId);

    /**
     * 查询工单表列表
     * 
     * @param tbTask 工单表
     * @return 工单表集合
     */
    public List<TbTask> selectTbTaskList(TbTask tbTask);

    /**
     * 新增工单表
     * 
     * @param tbTask 工单表
     * @return 结果
     */
    public int insertTbTask(TbTask tbTask);

    /**
     * 修改工单表
     * 
     * @param tbTask 工单表
     * @return 结果
     */
    public int updateTbTask(TbTask tbTask);

    /**
     * 删除工单表
     * 
     * @param taskId 工单表主键
     * @return 结果
     */
    public int deleteTbTaskByTaskId(Long taskId);

    /**
     * 批量删除工单表
     * 
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbTaskByTaskIds(Long[] taskIds);

    /**
     * 查询运维工单列表
     *
     * @param task 运维工单
     * @return TaskVo集合
     */
    List<TaskVo> selectTaskVoList(TbTask task);
}
