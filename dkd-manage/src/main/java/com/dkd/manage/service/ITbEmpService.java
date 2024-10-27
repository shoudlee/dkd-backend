package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.TbEmp;

/**
 * 工单员工Service接口
 * 
 * @author ruoyi
 * @date 2024-10-27
 */
public interface ITbEmpService 
{
    /**
     * 查询工单员工
     * 
     * @param id 工单员工主键
     * @return 工单员工
     */
    public TbEmp selectTbEmpById(Long id);

    /**
     * 查询工单员工列表
     * 
     * @param tbEmp 工单员工
     * @return 工单员工集合
     */
    public List<TbEmp> selectTbEmpList(TbEmp tbEmp);

    /**
     * 新增工单员工
     * 
     * @param tbEmp 工单员工
     * @return 结果
     */
    public int insertTbEmp(TbEmp tbEmp);

    /**
     * 修改工单员工
     * 
     * @param tbEmp 工单员工
     * @return 结果
     */
    public int updateTbEmp(TbEmp tbEmp);

    /**
     * 批量删除工单员工
     * 
     * @param ids 需要删除的工单员工主键集合
     * @return 结果
     */
    public int deleteTbEmpByIds(Long[] ids);

    /**
     * 删除工单员工信息
     * 
     * @param id 工单员工主键
     * @return 结果
     */
    public int deleteTbEmpById(Long id);
}
