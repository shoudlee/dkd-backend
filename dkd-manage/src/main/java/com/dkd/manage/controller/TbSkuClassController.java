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
import com.dkd.manage.domain.TbSkuClass;
import com.dkd.manage.service.ITbSkuClassService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 商品类型Controller
 * 
 * @author ruoyi
 * @date 2024-10-31
 */
@RestController
@RequestMapping("/manage/skuClass")
public class TbSkuClassController extends BaseController
{
    @Autowired
    private ITbSkuClassService tbSkuClassService;

    /**
     * 查询商品类型列表
     */
    @PreAuthorize("@ss.hasPermi('manage:skuClass:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbSkuClass tbSkuClass)
    {
        startPage();
        List<TbSkuClass> list = tbSkuClassService.selectTbSkuClassList(tbSkuClass);
        return getDataTable(list);
    }

    /**
     * 导出商品类型列表
     */
    @PreAuthorize("@ss.hasPermi('manage:skuClass:export')")
    @Log(title = "商品类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbSkuClass tbSkuClass)
    {
        List<TbSkuClass> list = tbSkuClassService.selectTbSkuClassList(tbSkuClass);
        ExcelUtil<TbSkuClass> util = new ExcelUtil<TbSkuClass>(TbSkuClass.class);
        util.exportExcel(response, list, "商品类型数据");
    }

    /**
     * 获取商品类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:skuClass:query')")
    @GetMapping(value = "/{classId}")
    public AjaxResult getInfo(@PathVariable("classId") Long classId)
    {
        return success(tbSkuClassService.selectTbSkuClassByClassId(classId));
    }

    /**
     * 新增商品类型
     */
    @PreAuthorize("@ss.hasPermi('manage:skuClass:add')")
    @Log(title = "商品类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbSkuClass tbSkuClass)
    {
        return toAjax(tbSkuClassService.insertTbSkuClass(tbSkuClass));
    }

    /**
     * 修改商品类型
     */
    @PreAuthorize("@ss.hasPermi('manage:skuClass:edit')")
    @Log(title = "商品类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbSkuClass tbSkuClass)
    {
        return toAjax(tbSkuClassService.updateTbSkuClass(tbSkuClass));
    }

    /**
     * 删除商品类型
     */
    @PreAuthorize("@ss.hasPermi('manage:skuClass:remove')")
    @Log(title = "商品类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{classIds}")
    public AjaxResult remove(@PathVariable Long[] classIds)
    {
        return toAjax(tbSkuClassService.deleteTbSkuClassByClassIds(classIds));
    }
}
