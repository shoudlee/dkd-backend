package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.TbTaskType;

/**
 * 工单类型Service接口
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
public interface ITbTaskTypeService 
{
    /**
     * 查询工单类型
     * 
     * @param typeId 工单类型主键
     * @return 工单类型
     */
    public TbTaskType selectTbTaskTypeByTypeId(Long typeId);

    /**
     * 查询工单类型列表
     * 
     * @param tbTaskType 工单类型
     * @return 工单类型集合
     */
    public List<TbTaskType> selectTbTaskTypeList(TbTaskType tbTaskType);

    /**
     * 新增工单类型
     * 
     * @param tbTaskType 工单类型
     * @return 结果
     */
    public int insertTbTaskType(TbTaskType tbTaskType);

    /**
     * 修改工单类型
     * 
     * @param tbTaskType 工单类型
     * @return 结果
     */
    public int updateTbTaskType(TbTaskType tbTaskType);

    /**
     * 批量删除工单类型
     * 
     * @param typeIds 需要删除的工单类型主键集合
     * @return 结果
     */
    public int deleteTbTaskTypeByTypeIds(Long[] typeIds);

    /**
     * 删除工单类型信息
     * 
     * @param typeId 工单类型主键
     * @return 结果
     */
    public int deleteTbTaskTypeByTypeId(Long typeId);
}
