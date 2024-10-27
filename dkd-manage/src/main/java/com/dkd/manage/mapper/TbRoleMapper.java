package com.dkd.manage.mapper;

import java.util.List;
import com.dkd.manage.domain.TbRole;

/**
 * 工单角色Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-27
 */
public interface TbRoleMapper 
{
    /**
     * 查询工单角色
     * 
     * @param roleId 工单角色主键
     * @return 工单角色
     */
    public TbRole selectTbRoleByRoleId(Long roleId);

    /**
     * 查询工单角色列表
     * 
     * @param tbRole 工单角色
     * @return 工单角色集合
     */
    public List<TbRole> selectTbRoleList(TbRole tbRole);

    /**
     * 新增工单角色
     * 
     * @param tbRole 工单角色
     * @return 结果
     */
    public int insertTbRole(TbRole tbRole);

    /**
     * 修改工单角色
     * 
     * @param tbRole 工单角色
     * @return 结果
     */
    public int updateTbRole(TbRole tbRole);

    /**
     * 删除工单角色
     * 
     * @param roleId 工单角色主键
     * @return 结果
     */
    public int deleteTbRoleByRoleId(Long roleId);

    /**
     * 批量删除工单角色
     * 
     * @param roleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbRoleByRoleIds(Long[] roleIds);
}
