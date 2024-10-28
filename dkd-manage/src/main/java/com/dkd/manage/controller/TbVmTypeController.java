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
import com.dkd.manage.domain.TbVmType;
import com.dkd.manage.service.ITbVmTypeService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 设备类型Controller
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
@RestController
@RequestMapping("/manage/vmType")
public class TbVmTypeController extends BaseController
{
    @Autowired
    private ITbVmTypeService tbVmTypeService;

    /**
     * 查询设备类型列表
     */
    @PreAuthorize("@ss.hasPermi('manage:vmType:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbVmType tbVmType)
    {
        startPage();
        List<TbVmType> list = tbVmTypeService.selectTbVmTypeList(tbVmType);
        return getDataTable(list);
    }

    /**
     * 导出设备类型列表
     */
    @PreAuthorize("@ss.hasPermi('manage:vmType:export')")
    @Log(title = "设备类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbVmType tbVmType)
    {
        List<TbVmType> list = tbVmTypeService.selectTbVmTypeList(tbVmType);
        ExcelUtil<TbVmType> util = new ExcelUtil<TbVmType>(TbVmType.class);
        util.exportExcel(response, list, "设备类型数据");
    }

    /**
     * 获取设备类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:vmType:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbVmTypeService.selectTbVmTypeById(id));
    }

    /**
     * 新增设备类型
     */
    @PreAuthorize("@ss.hasPermi('manage:vmType:add')")
    @Log(title = "设备类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbVmType tbVmType)
    {
        return toAjax(tbVmTypeService.insertTbVmType(tbVmType));
    }

    /**
     * 修改设备类型
     */
    @PreAuthorize("@ss.hasPermi('manage:vmType:edit')")
    @Log(title = "设备类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbVmType tbVmType)
    {
        return toAjax(tbVmTypeService.updateTbVmType(tbVmType));
    }

    /**
     * 删除设备类型
     */
    @PreAuthorize("@ss.hasPermi('manage:vmType:remove')")
    @Log(title = "设备类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbVmTypeService.deleteTbVmTypeByIds(ids));
    }
}