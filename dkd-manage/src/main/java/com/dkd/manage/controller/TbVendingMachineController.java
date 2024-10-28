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
import com.dkd.manage.domain.TbVendingMachine;
import com.dkd.manage.service.ITbVendingMachineService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 设备Controller
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
@RestController
@RequestMapping("/manage/vm")
public class TbVendingMachineController extends BaseController
{
    @Autowired
    private ITbVendingMachineService tbVendingMachineService;

    /**
     * 查询设备列表
     */
    @PreAuthorize("@ss.hasPermi('manage:vm:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbVendingMachine tbVendingMachine)
    {
        startPage();
        List<TbVendingMachine> list = tbVendingMachineService.selectTbVendingMachineList(tbVendingMachine);
        return getDataTable(list);
    }

    /**
     * 导出设备列表
     */
    @PreAuthorize("@ss.hasPermi('manage:vm:export')")
    @Log(title = "设备", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbVendingMachine tbVendingMachine)
    {
        List<TbVendingMachine> list = tbVendingMachineService.selectTbVendingMachineList(tbVendingMachine);
        ExcelUtil<TbVendingMachine> util = new ExcelUtil<TbVendingMachine>(TbVendingMachine.class);
        util.exportExcel(response, list, "设备数据");
    }

    /**
     * 获取设备详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:vm:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbVendingMachineService.selectTbVendingMachineById(id));
    }

    /**
     * 新增设备
     */
    @PreAuthorize("@ss.hasPermi('manage:vm:add')")
    @Log(title = "设备", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbVendingMachine tbVendingMachine)
    {
        return toAjax(tbVendingMachineService.insertTbVendingMachine(tbVendingMachine));
    }

    /**
     * 修改设备
     */
    @PreAuthorize("@ss.hasPermi('manage:vm:edit')")
    @Log(title = "设备", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbVendingMachine tbVendingMachine)
    {
        return toAjax(tbVendingMachineService.updateTbVendingMachine(tbVendingMachine));
    }

    /**
     * 删除设备
     */
    @PreAuthorize("@ss.hasPermi('manage:vm:remove')")
    @Log(title = "设备", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbVendingMachineService.deleteTbVendingMachineByIds(ids));
    }
}
