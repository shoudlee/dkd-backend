package com.dkd.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.dkd.manage.domain.TbTask;
import com.dkd.manage.domain.dto.TaskDto;
import com.dkd.manage.service.ITbTaskService;
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
import com.dkd.manage.domain.TbTaskCollect;
import com.dkd.manage.service.ITbTaskCollectService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 工单按日统计Controller
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
@RestController
@RequestMapping("/manage/taskCollect")
public class TbTaskCollectController extends BaseController
{
    @Autowired
    private ITbTaskCollectService tbTaskCollectService;

    @Autowired
    private ITbTaskService tbTaskService;

    /**
     * 查询工单按日统计列表
     */
    @PreAuthorize("@ss.hasPermi('manage:taskCollect:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbTaskCollect tbTaskCollect)
    {
        startPage();
        List<TbTaskCollect> list = tbTaskCollectService.selectTbTaskCollectList(tbTaskCollect);
        return getDataTable(list);
    }

    /**
     * 导出工单按日统计列表
     */
    @PreAuthorize("@ss.hasPermi('manage:taskCollect:export')")
    @Log(title = "工单按日统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbTaskCollect tbTaskCollect)
    {
        List<TbTaskCollect> list = tbTaskCollectService.selectTbTaskCollectList(tbTaskCollect);
        ExcelUtil<TbTaskCollect> util = new ExcelUtil<TbTaskCollect>(TbTaskCollect.class);
        util.exportExcel(response, list, "工单按日统计数据");
    }

    /**
     * 获取工单按日统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:taskCollect:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbTaskCollectService.selectTbTaskCollectById(id));
    }

    /**
     * 新增工单按日统计
     */
    @PreAuthorize("@ss.hasPermi('manage:taskCollect:add')")
    @Log(title = "工单按日统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbTaskCollect tbTaskCollect)
    {
        return toAjax(tbTaskCollectService.insertTbTaskCollect(tbTaskCollect));
    }

    /**
     * 修改工单按日统计
     */
    @PreAuthorize("@ss.hasPermi('manage:taskCollect:edit')")
    @Log(title = "工单按日统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbTaskCollect tbTaskCollect)
    {
        return toAjax(tbTaskCollectService.updateTbTaskCollect(tbTaskCollect));
    }

    /**
     * 删除工单按日统计
     */
    @PreAuthorize("@ss.hasPermi('manage:taskCollect:remove')")
    @Log(title = "工单按日统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbTaskCollectService.deleteTbTaskCollectByIds(ids));
    }

    /**
     * 新增工单
     */
    @PreAuthorize("@ss.hasPermi('manage:task:add')")
    @Log(title = "工单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskDto taskDto)
    {
        // 设置指派人（登录用户）id
        taskDto.setAssignorId(getUserId());
        return toAjax(tbTaskService.insertTaskDto(taskDto));
    }

    /**
     * 取消工单
     */
    @PreAuthorize("@ss.hasPermi('manage:task:edit')")
    @Log(title = "工单", businessType = BusinessType.UPDATE)
    @PutMapping("/cancel")
    public AjaxResult cancelTask(@RequestBody TbTask task) {
        return toAjax(tbTaskService.cancelTask(task));
    }
}
