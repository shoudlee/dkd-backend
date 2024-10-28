package com.dkd.manage.mapper;

import java.util.List;
import com.dkd.manage.domain.TbVmType;

/**
 * 设备类型Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
public interface TbVmTypeMapper 
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
     * 删除设备类型
     * 
     * @param id 设备类型主键
     * @return 结果
     */
    public int deleteTbVmTypeById(Long id);

    /**
     * 批量删除设备类型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbVmTypeByIds(Long[] ids);
}
