package com.dkd.manage.service.impl;

import java.util.List;
import com.dkd.common.utils.DateUtils;
import com.dkd.manage.domain.TbRole;
import com.dkd.manage.mapper.RegionMapper;
import com.dkd.manage.mapper.TbRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbEmpMapper;
import com.dkd.manage.domain.TbEmp;
import com.dkd.manage.service.ITbEmpService;

/**
 * 工单员工Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-27
 */
@Service
public class TbEmpServiceImpl implements ITbEmpService 
{
    @Autowired
    private TbEmpMapper tbEmpMapper;

    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private TbRoleMapper roleMapper;
    /**
     * 查询工单员工
     * 
     * @param id 工单员工主键
     * @return 工单员工
     */
    @Override
    public TbEmp selectTbEmpById(Long id)
    {
        return tbEmpMapper.selectTbEmpById(id);
    }

    /**
     * 查询工单员工列表
     * 
     * @param tbEmp 工单员工
     * @return 工单员工
     */
    @Override
    public List<TbEmp> selectTbEmpList(TbEmp tbEmp)
    {
        return tbEmpMapper.selectTbEmpList(tbEmp);
    }

    /**
     * 新增工单员工
     * 
     * @param tbEmp 工单员工
     * @return 结果
     */
    @Override
    public int insertTbEmp(TbEmp emp)
    {
        // 补充区域名称
        emp.setRegionName(regionMapper.selectRegionById(emp.getRegionId()).getRegionName());
        // 补充角色信息
        TbRole role = roleMapper.selectTbRoleByRoleId(emp.getRoleId());
        emp.setRoleName(role.getRoleName());
        emp.setRoleCode(role.getRoleCode());
        emp.setCreateTime(DateUtils.getNowDate());
        return tbEmpMapper.insertTbEmp(emp);
    }

    /**
     * 修改工单员工
     * 
     * @param tbEmp 工单员工
     * @return 结果
     */
    @Override
    public int updateTbEmp(TbEmp emp)
    {
        // 补充区域名称
        emp.setRegionName(regionMapper.selectRegionById(emp.getRegionId()).getRegionName());
        // 补充角色信息
        TbRole role = roleMapper.selectTbRoleByRoleId(emp.getRoleId());
        emp.setRoleName(role.getRoleName());
        emp.setRoleCode(role.getRoleCode());
        emp.setUpdateTime(DateUtils.getNowDate());
        return tbEmpMapper.updateTbEmp(emp);
    }

    /**
     * 批量删除工单员工
     * 
     * @param ids 需要删除的工单员工主键
     * @return 结果
     */
    @Override
    public int deleteTbEmpByIds(Long[] ids)
    {
        return tbEmpMapper.deleteTbEmpByIds(ids);
    }

    /**
     * 删除工单员工信息
     * 
     * @param id 工单员工主键
     * @return 结果
     */
    @Override
    public int deleteTbEmpById(Long id)
    {
        return tbEmpMapper.deleteTbEmpById(id);
    }
}
