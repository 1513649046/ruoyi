package com.ruoyi.system.controller;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import eu.bitwalker.useragentutils.browser.SafariUtils;
import io.github.classgraph.InfoList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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
import com.ruoyi.system.domain.Information;
import com.ruoyi.system.service.IInformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资讯Controller
 *
 * @author ruoyi
 * @date 2021-07-23
 */
@Api("资讯")
@RestController
@RequestMapping("/system/information")
public class InformationController extends BaseController {
    @Autowired
    private IInformationService informationService;

//    @Autowired
//    private Information information;

    /**
     * 查询资讯列表
     */
    @ApiOperation(value = "查询资讯列表")
    @PreAuthorize("@ss.hasPermi('system:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(Information information) {


        startPage();
        List<Information> list = informationService.selectInformationList(information);
        return getDataTable(list);
    }

    /**
     * 导出资讯列表
     * Information information,
     * /{infoIds}
     */
    @ApiOperation(value = "导出资讯列表")

    @PreAuthorize("@ss.hasPermi('system:information:export')")
    @Log(title = "资讯", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Information information)
    {
        List<Information> list = informationService.selectInformationList(information);
        ExcelUtil<Information> util = new ExcelUtil<Information>(Information.class);
        return util.exportExcel(list, "资讯数据");
    }

    /**
     * 获取资讯详细信息
     */
    @ApiOperation(value = "获取资讯详细信息")

    @PreAuthorize("@ss.hasPermi('system:information:query')")
    @GetMapping(value = "/{infoId}")
    public AjaxResult getInfo(@PathVariable("infoId") Long infoId) {
        return AjaxResult.success(informationService.selectInformationById(infoId));
    }

    /**
     * 新增资讯
     */
    @ApiOperation(value = "新增资讯")
    @PreAuthorize("@ss.hasPermi('system:information:add')")
    @Log(title = "资讯", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Information information) {
        information.setCreateBy(SecurityUtils.getUsername());
        return toAjax(informationService.insertInformation(information));
    }

    /**
     * 修改资讯
     */
    @ApiOperation(value = "修改资讯")
    @PreAuthorize("@ss.hasPermi('system:information:edit')")
    @Log(title = "资讯", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Information information) {
        information.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(informationService.updateInformation(information));
    }

    /**
     * 删除资讯
     */
    @ApiOperation(value = "删除资讯")
    @PreAuthorize("@ss.hasPermi('system:information:remove')")
    @Log(title = "资讯", businessType = BusinessType.DELETE)
    @DeleteMapping("/{infoIds}")
    public AjaxResult remove(@PathVariable Long[] infoIds) {
        return toAjax(informationService.deleteInformationByIds(infoIds));
    }
}
