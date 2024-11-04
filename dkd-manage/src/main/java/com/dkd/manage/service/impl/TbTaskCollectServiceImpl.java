package com.dkd.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbTaskCollectMapper;
import com.dkd.manage.domain.TbTaskCollect;
import com.dkd.manage.service.ITbTaskCollectService;

/**
 * 工单按日统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
@Service
public class TbTaskCollectServiceImpl implements ITbTaskCollectService 
{
    @Autowired
    private TbTaskCollectMapper tbTaskCollectMapper;

    /**
     * 查询工单按日统计
     * 
     * @param id 工单按日统计主键
     * @return 工单按日统计
     */
    @Override
    public TbTaskCollect selectTbTaskCollectById(Long id)
    {
        return tbTaskCollectMapper.selectTbTaskCollectById(id);
    }

    /**
     * 查询工单按日统计列表
     * 
     * @param tbTaskCollect 工单按日统计
     * @return 工单按日统计
     */
    @Override
    public List<TbTaskCollect> selectTbTaskCollectList(TbTaskCollect tbTaskCollect)
    {
        return tbTaskCollectMapper.selectTbTaskCollectList(tbTaskCollect);
    }

    /**
     * 新增工单按日统计
     * 
     * @param tbTaskCollect 工单按日统计
     * @return 结果
     */
    @Override
    public int insertTbTaskCollect(TbTaskCollect tbTaskCollect)
    {
        return tbTaskCollectMapper.insertTbTaskCollect(tbTaskCollect);
    }

    /**
     * 修改工单按日统计
     * 
     * @param tbTaskCollect 工单按日统计
     * @return 结果
     */
    @Override
    public int updateTbTaskCollect(TbTaskCollect tbTaskCollect)
    {
        return tbTaskCollectMapper.updateTbTaskCollect(tbTaskCollect);
    }

    /**
     * 批量删除工单按日统计
     * 
     * @param ids 需要删除的工单按日统计主键
     * @return 结果
     */
    @Override
    public int deleteTbTaskCollectByIds(Long[] ids)
    {
        return tbTaskCollectMapper.deleteTbTaskCollectByIds(ids);
    }

    /**
     * 删除工单按日统计信息
     * 
     * @param id 工单按日统计主键
     * @return 结果
     */
    @Override
    public int deleteTbTaskCollectById(Long id)
    {
        return tbTaskCollectMapper.deleteTbTaskCollectById(id);
    }
}
