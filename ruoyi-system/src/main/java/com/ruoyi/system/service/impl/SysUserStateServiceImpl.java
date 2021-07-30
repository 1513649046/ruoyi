package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysUserStateMapper;
import com.ruoyi.system.domain.SysUserState;
import com.ruoyi.system.service.ISysUserStateService;

/**
 * 预约功能Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-20
 */
@Service
public class SysUserStateServiceImpl implements ISysUserStateService 
{
    @Autowired
    private SysUserStateMapper sysUserStateMapper;

    /**
     * 查询预约功能
     * 
     * @param number 预约功能ID
     * @return 预约功能
     */
    @Override
    public SysUserState selectSysUserStateById(String number)
    {
        return sysUserStateMapper.selectSysUserStateById(number);
    }

    /**
     * 查询预约功能列表
     * 
     * @param sysUserState 预约功能
     * @return 预约功能
     */
    @Override
    public List<SysUserState> selectSysUserStateList(SysUserState sysUserState)
    {
        return sysUserStateMapper.selectSysUserStateList(sysUserState);
    }

    /**
     * 新增预约功能
     * 
     * @param sysUserState 预约功能
     * @return 结果
     */
    @Override
    public int insertSysUserState(SysUserState sysUserState)
    {
        return sysUserStateMapper.insertSysUserState(sysUserState);
    }

    /**
     * 修改预约功能
     * 
     * @param sysUserState 预约功能
     * @return 结果
     */
    @Override
    public int updateSysUserState(SysUserState sysUserState)
    {
        return sysUserStateMapper.updateSysUserState(sysUserState);
    }

    /**
     * 批量删除预约功能
     * 
     * @param numbers 需要删除的预约功能ID
     * @return 结果
     */
    @Override
    public int deleteSysUserStateByIds(String[] numbers)
    {
        return sysUserStateMapper.deleteSysUserStateByIds(numbers);
    }

    /**
     * 删除预约功能信息
     * 
     * @param number 预约功能ID
     * @return 结果
     */
    @Override
    public int deleteSysUserStateById(String number)
    {
        return sysUserStateMapper.deleteSysUserStateById(number);
    }
}
