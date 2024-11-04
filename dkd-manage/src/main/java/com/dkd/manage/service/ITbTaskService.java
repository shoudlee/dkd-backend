package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.TbTask;
import com.dkd.manage.domain.vo.TaskVo;

/**
 * 工单表Service接口
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
public interface ITbTaskService 
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
     * 批量删除工单表
     * 
     * @param taskIds 需要删除的工单表主键集合
     * @return 结果
     */
    public int deleteTbTaskByTaskIds(Long[] taskIds);

    /**
     * 删除工单表信息
     * 
     * @param taskId 工单表主键
     * @return 结果
     */
    public int deleteTbTaskByTaskId(Long taskId);

    /*
    * 返回TaskVo
    * */
    public List<TaskVo> selectTaskVoList(TbTask task);
}
