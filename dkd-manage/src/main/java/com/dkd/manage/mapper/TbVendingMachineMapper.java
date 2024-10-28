package com.dkd.manage.mapper;

import java.util.List;
import com.dkd.manage.domain.TbVendingMachine;

/**
 * 设备Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
public interface TbVendingMachineMapper 
{
    /**
     * 查询设备
     * 
     * @param id 设备主键
     * @return 设备
     */
    public TbVendingMachine selectTbVendingMachineById(Long id);

    /**
     * 查询设备列表
     * 
     * @param tbVendingMachine 设备
     * @return 设备集合
     */
    public List<TbVendingMachine> selectTbVendingMachineList(TbVendingMachine tbVendingMachine);

    /**
     * 新增设备
     * 
     * @param tbVendingMachine 设备
     * @return 结果
     */
    public int insertTbVendingMachine(TbVendingMachine tbVendingMachine);

    /**
     * 修改设备
     * 
     * @param tbVendingMachine 设备
     * @return 结果
     */
    public int updateTbVendingMachine(TbVendingMachine tbVendingMachine);

    /**
     * 删除设备
     * 
     * @param id 设备主键
     * @return 结果
     */
    public int deleteTbVendingMachineById(Long id);

    /**
     * 批量删除设备
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbVendingMachineByIds(Long[] ids);
}
