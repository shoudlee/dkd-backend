package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.TbJob;

/**
 * 自动补货任务Service接口
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
public interface ITbJobService 
{
    /**
     * 查询自动补货任务
     * 
     * @param id 自动补货任务主键
     * @return 自动补货任务
     */
    public TbJob selectTbJobById(Long id);

    /**
     * 查询自动补货任务列表
     * 
     * @param tbJob 自动补货任务
     * @return 自动补货任务集合
     */
    public List<TbJob> selectTbJobList(TbJob tbJob);

    /**
     * 新增自动补货任务
     * 
     * @param tbJob 自动补货任务
     * @return 结果
     */
    public int insertTbJob(TbJob tbJob);

    /**
     * 修改自动补货任务
     * 
     * @param tbJob 自动补货任务
     * @return 结果
     */
    public int updateTbJob(TbJob tbJob);

    /**
     * 批量删除自动补货任务
     * 
     * @param ids 需要删除的自动补货任务主键集合
     * @return 结果
     */
    public int deleteTbJobByIds(Long[] ids);

    /**
     * 删除自动补货任务信息
     * 
     * @param id 自动补货任务主键
     * @return 结果
     */
    public int deleteTbJobById(Long id);
}
