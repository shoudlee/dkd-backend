package com.dkd.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbTaskDetailsMapper;
import com.dkd.manage.domain.TbTaskDetails;
import com.dkd.manage.service.ITbTaskDetailsService;

/**
 * 工单详情，只有补货工单才有Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
@Service
public class TbTaskDetailsServiceImpl implements ITbTaskDetailsService 
{
    @Autowired
    private TbTaskDetailsMapper tbTaskDetailsMapper;

    /**
     * 查询工单详情，只有补货工单才有
     * 
     * @param detailsId 工单详情，只有补货工单才有主键
     * @return 工单详情，只有补货工单才有
     */
    @Override
    public TbTaskDetails selectTbTaskDetailsByDetailsId(Long detailsId)
    {
        return tbTaskDetailsMapper.selectTbTaskDetailsByDetailsId(detailsId);
    }

    /**
     * 查询工单详情，只有补货工单才有列表
     * 
     * @param tbTaskDetails 工单详情，只有补货工单才有
     * @return 工单详情，只有补货工单才有
     */
    @Override
    public List<TbTaskDetails> selectTbTaskDetailsList(TbTaskDetails tbTaskDetails)
    {
        return tbTaskDetailsMapper.selectTbTaskDetailsList(tbTaskDetails);
    }

    /**
     * 新增工单详情，只有补货工单才有
     * 
     * @param tbTaskDetails 工单详情，只有补货工单才有
     * @return 结果
     */
    @Override
    public int insertTbTaskDetails(TbTaskDetails tbTaskDetails)
    {
        return tbTaskDetailsMapper.insertTbTaskDetails(tbTaskDetails);
    }

    /**
     * 修改工单详情，只有补货工单才有
     * 
     * @param tbTaskDetails 工单详情，只有补货工单才有
     * @return 结果
     */
    @Override
    public int updateTbTaskDetails(TbTaskDetails tbTaskDetails)
    {
        return tbTaskDetailsMapper.updateTbTaskDetails(tbTaskDetails);
    }

    /**
     * 批量删除工单详情，只有补货工单才有
     * 
     * @param detailsIds 需要删除的工单详情，只有补货工单才有主键
     * @return 结果
     */
    @Override
    public int deleteTbTaskDetailsByDetailsIds(Long[] detailsIds)
    {
        return tbTaskDetailsMapper.deleteTbTaskDetailsByDetailsIds(detailsIds);
    }

    /**
     * 删除工单详情，只有补货工单才有信息
     * 
     * @param detailsId 工单详情，只有补货工单才有主键
     * @return 结果
     */
    @Override
    public int deleteTbTaskDetailsByDetailsId(Long detailsId)
    {
        return tbTaskDetailsMapper.deleteTbTaskDetailsByDetailsId(detailsId);
    }
}
