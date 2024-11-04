package com.dkd.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbTaskTypeMapper;
import com.dkd.manage.domain.TbTaskType;
import com.dkd.manage.service.ITbTaskTypeService;

/**
 * 工单类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
@Service
public class TbTaskTypeServiceImpl implements ITbTaskTypeService 
{
    @Autowired
    private TbTaskTypeMapper tbTaskTypeMapper;

    /**
     * 查询工单类型
     * 
     * @param typeId 工单类型主键
     * @return 工单类型
     */
    @Override
    public TbTaskType selectTbTaskTypeByTypeId(Long typeId)
    {
        return tbTaskTypeMapper.selectTbTaskTypeByTypeId(typeId);
    }

    /**
     * 查询工单类型列表
     * 
     * @param tbTaskType 工单类型
     * @return 工单类型
     */
    @Override
    public List<TbTaskType> selectTbTaskTypeList(TbTaskType tbTaskType)
    {
        return tbTaskTypeMapper.selectTbTaskTypeList(tbTaskType);
    }

    /**
     * 新增工单类型
     * 
     * @param tbTaskType 工单类型
     * @return 结果
     */
    @Override
    public int insertTbTaskType(TbTaskType tbTaskType)
    {
        return tbTaskTypeMapper.insertTbTaskType(tbTaskType);
    }

    /**
     * 修改工单类型
     * 
     * @param tbTaskType 工单类型
     * @return 结果
     */
    @Override
    public int updateTbTaskType(TbTaskType tbTaskType)
    {
        return tbTaskTypeMapper.updateTbTaskType(tbTaskType);
    }

    /**
     * 批量删除工单类型
     * 
     * @param typeIds 需要删除的工单类型主键
     * @return 结果
     */
    @Override
    public int deleteTbTaskTypeByTypeIds(Long[] typeIds)
    {
        return tbTaskTypeMapper.deleteTbTaskTypeByTypeIds(typeIds);
    }

    /**
     * 删除工单类型信息
     * 
     * @param typeId 工单类型主键
     * @return 结果
     */
    @Override
    public int deleteTbTaskTypeByTypeId(Long typeId)
    {
        return tbTaskTypeMapper.deleteTbTaskTypeByTypeId(typeId);
    }
}
