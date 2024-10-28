package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.TbVmType;

/**
 * 设备类型Service接口
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
public interface ITbVmTypeService 
{
    /**
     * 查询设备类型
     * 
     * @param id 设备类型主键
     * @return 设备类型
     */
    public TbVmType selectTbVmTypeById(Long id);

    /**
     * 查询设备类型列表
     * 
     * @param tbVmType 设备类型
     * @return 设备类型集合
     */
    public List<TbVmType> selectTbVmTypeList(TbVmType tbVmType);

    /**
     * 新增设备类型
     * 
     * @param tbVmType 设备类型
     * @return 结果
     */
    public int insertTbVmType(TbVmType tbVmType);

    /**
     * 修改设备类型
     * 
     * @param tbVmType 设备类型
     * @return 结果
     */
    public int updateTbVmType(TbVmType tbVmType);

    /**
     * 批量删除设备类型
     * 
     * @param ids 需要删除的设备类型主键集合
     * @return 结果
     */
    public int deleteTbVmTypeByIds(Long[] ids);

    /**
     * 删除设备类型信息
     * 
     * @param id 设备类型主键
     * @return 结果
     */
    public int deleteTbVmTypeById(Long id);
}