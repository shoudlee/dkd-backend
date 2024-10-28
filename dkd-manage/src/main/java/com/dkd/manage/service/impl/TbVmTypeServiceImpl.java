package com.dkd.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbVmTypeMapper;
import com.dkd.manage.domain.TbVmType;
import com.dkd.manage.service.ITbVmTypeService;

/**
 * 设备类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
@Service
public class TbVmTypeServiceImpl implements ITbVmTypeService 
{
    @Autowired
    private TbVmTypeMapper tbVmTypeMapper;

    /**
     * 查询设备类型
     * 
     * @param id 设备类型主键
     * @return 设备类型
     */
    @Override
    public TbVmType selectTbVmTypeById(Long id)
    {
        return tbVmTypeMapper.selectTbVmTypeById(id);
    }

    /**
     * 查询设备类型列表
     * 
     * @param tbVmType 设备类型
     * @return 设备类型
     */
    @Override
    public List<TbVmType> selectTbVmTypeList(TbVmType tbVmType)
    {
        return tbVmTypeMapper.selectTbVmTypeList(tbVmType);
    }

    /**
     * 新增设备类型
     * 
     * @param tbVmType 设备类型
     * @return 结果
     */
    @Override
    public int insertTbVmType(TbVmType tbVmType)
    {
        return tbVmTypeMapper.insertTbVmType(tbVmType);
    }

    /**
     * 修改设备类型
     * 
     * @param tbVmType 设备类型
     * @return 结果
     */
    @Override
    public int updateTbVmType(TbVmType tbVmType)
    {
        return tbVmTypeMapper.updateTbVmType(tbVmType);
    }

    /**
     * 批量删除设备类型
     * 
     * @param ids 需要删除的设备类型主键
     * @return 结果
     */
    @Override
    public int deleteTbVmTypeByIds(Long[] ids)
    {
        return tbVmTypeMapper.deleteTbVmTypeByIds(ids);
    }

    /**
     * 删除设备类型信息
     * 
     * @param id 设备类型主键
     * @return 结果
     */
    @Override
    public int deleteTbVmTypeById(Long id)
    {
        return tbVmTypeMapper.deleteTbVmTypeById(id);
    }
}
