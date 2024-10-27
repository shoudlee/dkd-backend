package com.dkd.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dkd.common.annotation.Log;
import com.dkd.common.core.controller.BaseController;
import com.dkd.common.core.domain.AjaxResult;
import com.dkd.common.enums.BusinessType;
import com.dkd.manage.domain.TbRole;
import com.dkd.manage.service.ITbRoleService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 工单角色Controller
 * 
 * @author ruoyi
 * @date 2024-10-27
 */
@RestController
@RequestMapping("/manage/role")
public class TbRoleController extends BaseController
{
    @Autowired
    private ITbRoleService tbRoleService;

    /**
     * 查询工单角色列表
     */
    @PreAuthorize("@ss.hasPermi('manage:role:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbRole tbRole)
    {
        startPage();
        List<TbRole> list = tbRoleService.selectTbRoleList(tbRole);
        return getDataTable(list);
    }

    /**
     * 导出工单角色列表
     */
    @PreAuthorize("@ss.hasPermi('manage:role:export')")
    @Log(title = "工单角色", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbRole tbRole)
    {
        List<TbRole> list = tbRoleService.selectTbRoleList(tbRole);
        ExcelUtil<TbRole> util = new ExcelUtil<TbRole>(TbRole.class);
        util.exportExcel(response, list, "工单角色数据");
    }

    /**
     * 获取工单角色详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:role:query')")
    @GetMapping(value = "/{roleId}")
    public AjaxResult getInfo(@PathVariable("roleId") Long roleId)
    {
        return success(tbRoleService.selectTbRoleByRoleId(roleId));
    }

    /**
     * 新增工单角色
     */
    @PreAuthorize("@ss.hasPermi('manage:role:add')")
    @Log(title = "工单角色", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbRole tbRole)
    {
        return toAjax(tbRoleService.insertTbRole(tbRole));
    }

    /**
     * 修改工单角色
     */
    @PreAuthorize("@ss.hasPermi('manage:role:edit')")
    @Log(title = "工单角色", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbRole tbRole)
    {
        return toAjax(tbRoleService.updateTbRole(tbRole));
    }

    /**
     * 删除工单角色
     */
    @PreAuthorize("@ss.hasPermi('manage:role:remove')")
    @Log(title = "工单角色", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roleIds}")
    public AjaxResult remove(@PathVariable Long[] roleIds)
    {
        return toAjax(tbRoleService.deleteTbRoleByRoleIds(roleIds));
    }
}
