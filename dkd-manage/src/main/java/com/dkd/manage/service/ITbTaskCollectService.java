package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.TbTaskCollect;

/**
 * 工单按日统计Service接口
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
public interface ITbTaskCollectService 
{
    /**
     * 查询工单按日统计
     * 
     * @param id 工单按日统计主键
     * @return 工单按日统计
     */
    public TbTaskCollect selectTbTaskCollectById(Long id);

    /**
     * 查询工单按日统计列表
     * 
     * @param tbTaskCollect 工单按日统计
     * @return 工单按日统计集合
     */
    public List<TbTaskCollect> selectTbTaskCollectList(TbTaskCollect tbTaskCollect);

    /**
     * 新增工单按日统计
     * 
     * @param tbTaskCollect 工单按日统计
     * @return 结果
     */
    public int insertTbTaskCollect(TbTaskCollect tbTaskCollect);

    /**
     * 修改工单按日统计
     * 
     * @param tbTaskCollect 工单按日统计
     * @return 结果
     */
    public int updateTbTaskCollect(TbTaskCollect tbTaskCollect);

    /**
     * 批量删除工单按日统计
     * 
     * @param ids 需要删除的工单按日统计主键集合
     * @return 结果
     */
    public int deleteTbTaskCollectByIds(Long[] ids);

    /**
     * 删除工单按日统计信息
     * 
     * @param id 工单按日统计主键
     * @return 结果
     */
    public int deleteTbTaskCollectById(Long id);
}
