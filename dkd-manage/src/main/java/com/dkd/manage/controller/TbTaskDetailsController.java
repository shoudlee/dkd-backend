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
import com.dkd.manage.domain.TbTaskDetails;
import com.dkd.manage.service.ITbTaskDetailsService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 工单详情，只有补货工单才有Controller
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
@RestController
@RequestMapping("/manage/taskDetails")
public class TbTaskDetailsController extends BaseController
{
    @Autowired
    private ITbTaskDetailsService tbTaskDetailsService;

    /**
     * 查询工单详情，只有补货工单才有列表
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDetails:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbTaskDetails tbTaskDetails)
    {
        startPage();
        List<TbTaskDetails> list = tbTaskDetailsService.selectTbTaskDetailsList(tbTaskDetails);
        return getDataTable(list);
    }

    /**
     * 导出工单详情，只有补货工单才有列表
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDetails:export')")
    @Log(title = "工单详情，只有补货工单才有", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbTaskDetails tbTaskDetails)
    {
        List<TbTaskDetails> list = tbTaskDetailsService.selectTbTaskDetailsList(tbTaskDetails);
        ExcelUtil<TbTaskDetails> util = new ExcelUtil<TbTaskDetails>(TbTaskDetails.class);
        util.exportExcel(response, list, "工单详情，只有补货工单才有数据");
    }

    /**
     * 获取工单详情，只有补货工单才有详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDetails:query')")
    @GetMapping(value = "/{detailsId}")
    public AjaxResult getInfo(@PathVariable("detailsId") Long detailsId)
    {
        return success(tbTaskDetailsService.selectTbTaskDetailsByDetailsId(detailsId));
    }

    /**
     * 新增工单详情，只有补货工单才有
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDetails:add')")
    @Log(title = "工单详情，只有补货工单才有", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbTaskDetails tbTaskDetails)
    {
        return toAjax(tbTaskDetailsService.insertTbTaskDetails(tbTaskDetails));
    }

    /**
     * 修改工单详情，只有补货工单才有
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDetails:edit')")
    @Log(title = "工单详情，只有补货工单才有", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbTaskDetails tbTaskDetails)
    {
        return toAjax(tbTaskDetailsService.updateTbTaskDetails(tbTaskDetails));
    }

    /**
     * 删除工单详情，只有补货工单才有
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDetails:remove')")
    @Log(title = "工单详情，只有补货工单才有", businessType = BusinessType.DELETE)
	@DeleteMapping("/{detailsIds}")
    public AjaxResult remove(@PathVariable Long[] detailsIds)
    {
        return toAjax(tbTaskDetailsService.deleteTbTaskDetailsByDetailsIds(detailsIds));
    }

    /**
     * 查看工单补货详情
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDetails:list')")
    @GetMapping(value = "/byTaskId/{taskId}")
    public AjaxResult byTaskId(@PathVariable("taskId") Long taskId) {
        TbTaskDetails taskDetailsParam = new TbTaskDetails();
        taskDetailsParam.setTaskId(taskId);
        return success(tbTaskDetailsService.selectTbTaskDetailsList(taskDetailsParam));
    }
}
