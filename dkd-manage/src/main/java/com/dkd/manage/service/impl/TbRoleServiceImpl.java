package com.dkd.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TbRoleMapper;
import com.dkd.manage.domain.TbRole;
import com.dkd.manage.service.ITbRoleService;

/**
 * 工单角色Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-27
 */
@Service
public class TbRoleServiceImpl implements ITbRoleService 
{
    @Autowired
    private TbRoleMapper tbRoleMapper;

    /**
     * 查询工单角色
     * 
     * @param roleId 工单角色主键
     * @return 工单角色
     */
    @Override
    public TbRole selectTbRoleByRoleId(Long roleId)
    {
        return tbRoleMapper.selectTbRoleByRoleId(roleId);
    }

    /**
     * 查询工单角色列表
     * 
     * @param tbRole 工单角色
     * @return 工单角色
     */
    @Override
    public List<TbRole> selectTbRoleList(TbRole tbRole)
    {
        return tbRoleMapper.selectTbRoleList(tbRole);
    }

    /**
     * 新增工单角色
     * 
     * @param tbRole 工单角色
     * @return 结果
     */
    @Override
    public int insertTbRole(TbRole tbRole)
    {
        return tbRoleMapper.insertTbRole(tbRole);
    }

    /**
     * 修改工单角色
     * 
     * @param tbRole 工单角色
     * @return 结果
     */
    @Override
    public int updateTbRole(TbRole tbRole)
    {
        return tbRoleMapper.updateTbRole(tbRole);
    }

    /**
     * 批量删除工单角色
     * 
     * @param roleIds 需要删除的工单角色主键
     * @return 结果
     */
    @Override
    public int deleteTbRoleByRoleIds(Long[] roleIds)
    {
        return tbRoleMapper.deleteTbRoleByRoleIds(roleIds);
    }

    /**
     * 删除工单角色信息
     * 
     * @param roleId 工单角色主键
     * @return 结果
     */
    @Override
    public int deleteTbRoleByRoleId(Long roleId)
    {
        return tbRoleMapper.deleteTbRoleByRoleId(roleId);
    }
}
