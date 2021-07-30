package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Type;
import com.ruoyi.system.service.ITypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 更多资讯Controller
 * 
 * @author ruoyi
 * @date 2021-07-23
 */
@RestController
@RequestMapping("/system/type")
public class TypeController extends BaseController
{
    @Autowired
    private ITypeService typeService;

    /**
     * 查询更多资讯列表
     */
    @PreAuthorize("@ss.hasPermi('system:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(Type type)
    {
        startPage();
        List<Type> list = typeService.selectTypeList(type);
        return getDataTable(list);
    }

    /**
     * 导出更多资讯列表
     */
    @PreAuthorize("@ss.hasPermi('system:type:export')")
    @Log(title = "更多资讯", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Type type)
    {
        List<Type> list = typeService.selectTypeList(type);
        ExcelUtil<Type> util = new ExcelUtil<Type>(Type.class);
        return util.exportExcel(list, "更多资讯数据");
    }

    /**
     * 获取更多资讯详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:type:query')")
    @GetMapping(value = "/{typeId}")
    public AjaxResult getInfo(@PathVariable("typeId") Integer typeId)
    {
        return AjaxResult.success(typeService.selectTypeById(typeId));
    }

    /**
     * 新增更多资讯
     */
    @PreAuthorize("@ss.hasPermi('system:type:add')")
    @Log(title = "更多资讯", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Type type)
    {
        type.setCreateBy(SecurityUtils.getUsername());
        return toAjax(typeService.insertType(type));
    }

    /**
     * 修改更多资讯
     */
    @PreAuthorize("@ss.hasPermi('system:type:edit')")
    @Log(title = "更多资讯", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Type type)
    {
        type.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(typeService.updateType(type));
    }

    /**
     * 删除更多资讯
     */
    @PreAuthorize("@ss.hasPermi('system:type:remove')")
    @Log(title = "更多资讯", businessType = BusinessType.DELETE)
	@DeleteMapping("/{typeIds}")
    public AjaxResult remove(@PathVariable Integer[] typeIds)
    {
        return toAjax(typeService.deleteTypeByIds(typeIds));
    }
}
