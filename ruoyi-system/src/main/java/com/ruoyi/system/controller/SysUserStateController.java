package com.ruoyi.system.controller;

import java.util.List;
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
import com.ruoyi.system.domain.SysUserState;
import com.ruoyi.system.service.ISysUserStateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预约功能Controller
 * 
 * @author ruoyi
 * @date 2021-07-20
 */
@RestController
@RequestMapping("/system/state")
public class SysUserStateController extends BaseController
{
    @Autowired
    private ISysUserStateService sysUserStateService;

    /**
     * 查询预约功能列表
     */
    @PreAuthorize("@ss.hasPermi('system:state:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysUserState sysUserState)
    {
        startPage();
        List<SysUserState> list = sysUserStateService.selectSysUserStateList(sysUserState);
        return getDataTable(list);
    }

    /**
     * 导出预约功能列表
     */
    @PreAuthorize("@ss.hasPermi('system:state:export')")
    @Log(title = "预约功能", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysUserState sysUserState)
    {
        List<SysUserState> list = sysUserStateService.selectSysUserStateList(sysUserState);
        ExcelUtil<SysUserState> util = new ExcelUtil<SysUserState>(SysUserState.class);
        return util.exportExcel(list, "预约功能数据");
    }

    /**
     * 获取预约功能详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:state:query')")
    @GetMapping(value = "/{number}")
    public AjaxResult getInfo(@PathVariable("number") String number)
    {
        return AjaxResult.success(sysUserStateService.selectSysUserStateById(number));
    }

    /**
     * 新增预约功能
     */
    @PreAuthorize("@ss.hasPermi('system:state:add')")
    @Log(title = "预约功能", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysUserState sysUserState)
    {
        return toAjax(sysUserStateService.insertSysUserState(sysUserState));
    }

    /**
     * 修改预约功能
     */
    @PreAuthorize("@ss.hasPermi('system:state:edit')")
    @Log(title = "预约功能", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUserState sysUserState)
    {
        return toAjax(sysUserStateService.updateSysUserState(sysUserState));
    }

    /**
     * 删除预约功能
     */
    @PreAuthorize("@ss.hasPermi('system:state:remove')")
    @Log(title = "预约功能", businessType = BusinessType.DELETE)
	@DeleteMapping("/{numbers}")
    public AjaxResult remove(@PathVariable String[] numbers)
    {
        return toAjax(sysUserStateService.deleteSysUserStateByIds(numbers));
    }
}
