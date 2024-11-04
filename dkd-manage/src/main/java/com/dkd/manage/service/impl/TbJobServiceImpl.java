package com.dkd.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbJobMapper;
import com.dkd.manage.domain.TbJob;
import com.dkd.manage.service.ITbJobService;

/**
 * 自动补货任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
@Service
public class TbJobServiceImpl implements ITbJobService 
{
    @Autowired
    private TbJobMapper tbJobMapper;

    /**
     * 查询自动补货任务
     * 
     * @param id 自动补货任务主键
     * @return 自动补货任务
     */
    @Override
    public TbJob selectTbJobById(Long id)
    {
        return tbJobMapper.selectTbJobById(id);
    }

    /**
     * 查询自动补货任务列表
     * 
     * @param tbJob 自动补货任务
     * @return 自动补货任务
     */
    @Override
    public List<TbJob> selectTbJobList(TbJob tbJob)
    {
        return tbJobMapper.selectTbJobList(tbJob);
    }

    /**
     * 新增自动补货任务
     * 
     * @param tbJob 自动补货任务
     * @return 结果
     */
    @Override
    public int insertTbJob(TbJob tbJob)
    {
        return tbJobMapper.insertTbJob(tbJob);
    }

    /**
     * 修改自动补货任务
     * 
     * @param tbJob 自动补货任务
     * @return 结果
     */
    @Override
    public int updateTbJob(TbJob tbJob)
    {
        return tbJobMapper.updateTbJob(tbJob);
    }

    /**
     * 批量删除自动补货任务
     * 
     * @param ids 需要删除的自动补货任务主键
     * @return 结果
     */
    @Override
    public int deleteTbJobByIds(Long[] ids)
    {
        return tbJobMapper.deleteTbJobByIds(ids);
    }

    /**
     * 删除自动补货任务信息
     * 
     * @param id 自动补货任务主键
     * @return 结果
     */
    @Override
    public int deleteTbJobById(Long id)
    {
        return tbJobMapper.deleteTbJobById(id);
    }
}
