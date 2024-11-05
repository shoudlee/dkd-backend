package com.dkd.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.dkd.common.constant.DkdConstants;
import com.dkd.common.constant.DkdContants;
import com.dkd.manage.domain.TbVendingMachine;
import com.dkd.manage.service.ITbVendingMachineService;
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
import com.dkd.manage.domain.TbEmp;
import com.dkd.manage.service.ITbEmpService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 工单员工Controller
 * 
 * @author ruoyi
 * @date 2024-10-27
 */
@RestController
@RequestMapping("/manage/emp")
public class TbEmpController extends BaseController
{
    @Autowired
    private ITbEmpService tbEmpService;

    @Autowired
    private ITbVendingMachineService tbVendingMachineService;

    /**
     * 查询工单员工列表
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbEmp tbEmp)
    {
        startPage();
        List<TbEmp> list = tbEmpService.selectTbEmpList(tbEmp);
        return getDataTable(list);
    }

    /**
     * 导出工单员工列表
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:export')")
    @Log(title = "工单员工", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbEmp tbEmp)
    {
        List<TbEmp> list = tbEmpService.selectTbEmpList(tbEmp);
        ExcelUtil<TbEmp> util = new ExcelUtil<TbEmp>(TbEmp.class);
        util.exportExcel(response, list, "工单员工数据");
    }

    /**
     * 获取工单员工详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbEmpService.selectTbEmpById(id));
    }

    /**
     * 新增工单员工
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:add')")
    @Log(title = "工单员工", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbEmp tbEmp)
    {
        return toAjax(tbEmpService.insertTbEmp(tbEmp));
    }

    /**
     * 修改工单员工
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:edit')")
    @Log(title = "工单员工", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbEmp tbEmp)
    {
        return toAjax(tbEmpService.updateTbEmp(tbEmp));
    }

    /**
     * 删除工单员工
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:remove')")
    @Log(title = "工单员工", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbEmpService.deleteTbEmpByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('manage:emp:list')")
    @Log(title="工单员工")
    @GetMapping("/businessList/{innerCode}")
    public AjaxResult BusinessList(@PathVariable("innerCode") String innerCode){
        return AjaxResult.success(tbEmpService.selectTbEmpByInnerCode(innerCode));
    }

    /**
     * 根据售货机获取运维人员列表
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:list')")
    @GetMapping("/operationList/{innerCode}")
    public AjaxResult getOperationList(@PathVariable("innerCode") String innerCode) {
        // 1.查询售货机信息
        TbVendingMachine vm = tbVendingMachineService.getTbVendingMachineByInnerCode(innerCode);
        if (vm == null) {
            return error("售货机不存在");
        }
        // 2.根据区域id、角色编号、状态查询运维人员列表
        TbEmp empParam = new TbEmp();
        empParam.setRegionId(vm.getRegionId());// 设备所属区域
        empParam.setStatus(DkdConstants.EMP_STATUS_NORMAL);// 员工启用
        empParam.setRoleCode(DkdConstants.ROLE_CODE_OPERATOR);// 角色编码：维修员
        return success(tbEmpService.selectTbEmpList(empParam));
    }
}
