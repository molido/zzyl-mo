package com.zzyl.nursing.controller;

import com.zzyl.common.annotation.Log;
import com.zzyl.common.core.controller.BaseController;
import com.zzyl.common.core.domain.AjaxResult;
import com.zzyl.common.core.domain.R;
import com.zzyl.common.core.page.TableDataInfo;
import com.zzyl.common.enums.BusinessType;
import com.zzyl.common.utils.poi.ExcelUtil;
import com.zzyl.nursing.domain.NursingProject;
import com.zzyl.nursing.domain.vo.NursingProjectVo;
import com.zzyl.nursing.service.INursingProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 护理项目Controller
 * 
 * @author ruoyi
 * @date 2025-07-20
 */
@Tag(name = "护理项目控制器")
@RestController
@RequestMapping("/nursing/NursingProject")
public class NursingProjectController extends BaseController
{
    @Autowired
    private INursingProjectService nursingProjectService;
    /**
     * 查询所有
     */
    @GetMapping("/all")
    @Operation(summary = "查询所有护理项目")
    public AjaxResult listAll()
    {
        List<NursingProjectVo> list = nursingProjectService.selectAll();
        return success(list);
    }

    /**
     * 查询护理项目列表
     */
    @Operation(summary = "查询护理项目列表")
    @PreAuthorize("@ss.hasPermi('serve:NursingProject:list')")
    @GetMapping("/list")
    public TableDataInfo<List<NursingProject>>  list(NursingProject nursingProject)
    {
        startPage();
        List<NursingProject> list = nursingProjectService.selectNursingProjectList(nursingProject);
        return getDataTable(list);
    }

    /**
     * 导出护理项目列表
     */
    @Operation(summary = "导出护理项目列表")
    @PreAuthorize("@ss.hasPermi('serve:NursingProject:export')")
    @Log(title = "护理项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NursingProject nursingProject)
    {
        List<NursingProject> list = nursingProjectService.selectNursingProjectList(nursingProject);
        ExcelUtil<NursingProject> util = new ExcelUtil<NursingProject>(NursingProject.class);
        util.exportExcel(response, list, "护理项目数据");
    }

    /**
     * 获取护理项目详细信息
     */
    @Operation(summary = "获取护理项目详细信息")
    @PreAuthorize("@ss.hasPermi('serve:NursingProject:query')")
    @GetMapping(value = "/{id}")
    public R<NursingProject> getInfo(@PathVariable("id") Integer id)
    {
        return R.ok(nursingProjectService.selectNursingProjectById(id));
    }

    /**
     * 新增护理项目
     */
    @Operation(summary = "新增护理项目")
    @PreAuthorize("@ss.hasPermi('serve:NursingProject:add')")
    @Log(title = "护理项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NursingProject nursingProject)
    {
        return toAjax(nursingProjectService.insertNursingProject(nursingProject));
    }

    /**
     * 修改护理项目
     */
    @Operation(summary = "修改护理项目")
    @PreAuthorize("@ss.hasPermi('serve:NursingProject:edit')")
    @Log(title = "护理项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NursingProject nursingProject)
    {
        return toAjax(nursingProjectService.updateNursingProject(nursingProject));
    }

    /**
     * 删除护理项目
     */
    @Operation(summary = "删除护理项目")
    @PreAuthorize("@ss.hasPermi('serve:NursingProject:remove')")
    @Log(title = "护理项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(nursingProjectService.deleteNursingProjectByIds(ids));
    }
}
