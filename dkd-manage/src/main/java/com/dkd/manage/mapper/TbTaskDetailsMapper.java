package com.dkd.manage.mapper;

import java.util.List;
import com.dkd.manage.domain.TbTaskDetails;

/**
 * 工单详情，只有补货工单才有Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
public interface TbTaskDetailsMapper 
{
    /**
     * 查询工单详情，只有补货工单才有
     * 
     * @param detailsId 工单详情，只有补货工单才有主键
     * @return 工单详情，只有补货工单才有
     */
    public TbTaskDetails selectTbTaskDetailsByDetailsId(Long detailsId);

    /**
     * 查询工单详情，只有补货工单才有列表
     * 
     * @param tbTaskDetails 工单详情，只有补货工单才有
     * @return 工单详情，只有补货工单才有集合
     */
    public List<TbTaskDetails> selectTbTaskDetailsList(TbTaskDetails tbTaskDetails);

    /**
     * 新增工单详情，只有补货工单才有
     * 
     * @param tbTaskDetails 工单详情，只有补货工单才有
     * @return 结果
     */
    public int insertTbTaskDetails(TbTaskDetails tbTaskDetails);

    /**
     * 修改工单详情，只有补货工单才有
     * 
     * @param tbTaskDetails 工单详情，只有补货工单才有
     * @return 结果
     */
    public int updateTbTaskDetails(TbTaskDetails tbTaskDetails);

    /**
     * 删除工单详情，只有补货工单才有
     * 
     * @param detailsId 工单详情，只有补货工单才有主键
     * @return 结果
     */
    public int deleteTbTaskDetailsByDetailsId(Long detailsId);

    /**
     * 批量删除工单详情，只有补货工单才有
     * 
     * @param detailsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbTaskDetailsByDetailsIds(Long[] detailsIds);
}
