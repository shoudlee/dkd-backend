package com.dkd.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.dkd.manage.domain.vo.TaskVo;
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
import com.dkd.manage.domain.TbTask;
import com.dkd.manage.service.ITbTaskService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 工单表Controller
 * 
 * @author ruoyi
 * @date 2024-11-04
 */
@RestController
@RequestMapping("/manage/task")
public class TbTaskController extends BaseController
{
    @Autowired
    private ITbTaskService tbTaskService;

//    /**
//     * 查询工单表列表
//     */
//    @PreAuthorize("@ss.hasPermi('manage:task:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(TbTask tbTask)
//    {
//        startPage();
//        List<TbTask> list = tbTaskService.selectTbTaskList(tbTask);
//        return getDataTable(list);
//    }

    /**
     * 导出工单表列表
     */
    @PreAuthorize("@ss.hasPermi('manage:task:export')")
    @Log(title = "工单表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbTask tbTask)
    {
        List<TbTask> list = tbTaskService.selectTbTaskList(tbTask);
        ExcelUtil<TbTask> util = new ExcelUtil<TbTask>(TbTask.class);
        util.exportExcel(response, list, "工单表数据");
    }

    /**
     * 获取工单表详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return success(tbTaskService.selectTbTaskByTaskId(taskId));
    }

    /**
     * 新增工单表
     */
    @PreAuthorize("@ss.hasPermi('manage:task:add')")
    @Log(title = "工单表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbTask tbTask)
    {
        return toAjax(tbTaskService.insertTbTask(tbTask));
    }

    /**
     * 修改工单表
     */
    @PreAuthorize("@ss.hasPermi('manage:task:edit')")
    @Log(title = "工单表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbTask tbTask)
    {
        return toAjax(tbTaskService.updateTbTask(tbTask));
    }

    /**
     * 删除工单表
     */
    @PreAuthorize("@ss.hasPermi('manage:task:remove')")
    @Log(title = "工单表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(tbTaskService.deleteTbTaskByTaskIds(taskIds));
    }

    @PreAuthorize("@ss.hasPermi('manage:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbTask tbTask){
        startPage();
        List<TaskVo> list = tbTaskService.selectTaskVoList(tbTask);
        return getDataTable(list);
    }
}
