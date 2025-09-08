package com.zzyl.nursing.controller;

import com.zzyl.common.annotation.Log;
import com.zzyl.common.core.controller.BaseController;
import com.zzyl.common.core.domain.AjaxResult;
import com.zzyl.common.core.page.TableDataInfo;
import com.zzyl.common.enums.BusinessType;
import com.zzyl.common.utils.poi.ExcelUtil;
import com.zzyl.nursing.domain.NursingPlan;
import com.zzyl.nursing.domain.dto.NursingPlanDto;
import com.zzyl.nursing.service.INursingPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 护理计划Controller
 * 
 * @author ruoyi
 * @date 2025-07-21
 */
@Tag(name = "护理计划控制器")
@RestController
@RequestMapping("/nursing/NursingPlan")
public class NursingPlanController extends BaseController
{
    @Autowired
    private INursingPlanService nursingPlanService;
    /**
     * 新增护理计划
     */
    @PreAuthorize("@ss.hasPermi('nursing:nursingPlan:add')")
    @Log(title = "护理计划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NursingPlanDto dto)
    {
        return toAjax(nursingPlanService.insertNursingPlan(dto));
    }
    /**
     * 查询护理计划列表
     */
    @Operation(summary = "查询护理计划列表")
    @PreAuthorize("@ss.hasPermi('serve:NursingPlan:list')")
    @GetMapping("/list")
    public TableDataInfo list(NursingPlan nursingPlan)
    {
        startPage();
        List<NursingPlan> list = nursingPlanService.selectNursingPlanList(nursingPlan);
        return getDataTable(list);
    }

    /**
     * 导出护理计划列表
     */
    @Operation(summary = "导出护理计划列表")
    @PreAuthorize("@ss.hasPermi('serve:NursingPlan:export')")
    @Log(title = "护理计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NursingPlan nursingPlan)
    {
        List<NursingPlan> list = nursingPlanService.selectNursingPlanList(nursingPlan);
        ExcelUtil<NursingPlan> util = new ExcelUtil<NursingPlan>(NursingPlan.class);
        util.exportExcel(response, list, "护理计划数据");
    }

    /**
     * 获取护理计划详细信息
     */
    @Operation(summary = "获取护理计划详细信息")
    @PreAuthorize("@ss.hasPermi('serve:NursingPlan:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(nursingPlanService.selectNursingPlanById(id));
    }

    /**
     * 修改护理计划
     */
    @Operation(summary = "修改护理计划")
    @PreAuthorize("@ss.hasPermi('serve:NursingPlan:edit')")
    @Log(title = "护理计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NursingPlanDto dto)
    {
        return toAjax(nursingPlanService.updateNursingPlan(dto));
    }

    /**
     * 删除护理计划
     */
//    @Operation(summary = "删除护理计划")
//    @PreAuthorize("@ss.hasPermi('serve:NursingPlan:remove')")
//    @Log(title = "护理计划", businessType = BusinessType.DELETE)
//	@DeleteMapping("/{ids}")
//    public AjaxResult remove(@PathVariable Integer[] ids)
//    {
//        return toAjax(nursingPlanService.deleteNursingPlanByIds(ids));
//    }
    @Operation(summary = "删除护理计划")
    @PreAuthorize("@ss.hasPermi('serve:NursingPlan:remove')")
    @Log(title = "护理计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Integer id)
    {
        return toAjax(nursingPlanService.deleteNursingPlanByIds(id));
    }
}
