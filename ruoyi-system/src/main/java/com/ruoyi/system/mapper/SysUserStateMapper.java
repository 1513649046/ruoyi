package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysUserState;

/**
 * 预约功能Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-20
 */
public interface SysUserStateMapper 
{
    /**
     * 查询预约功能
     * 
     * @param number 预约功能ID
     * @return 预约功能
     */
    public SysUserState selectSysUserStateById(String number);

    /**
     * 查询预约功能列表
     * 
     * @param sysUserState 预约功能
     * @return 预约功能集合
     */
    public List<SysUserState> selectSysUserStateList(SysUserState sysUserState);

    /**
     * 新增预约功能
     * 
     * @param sysUserState 预约功能
     * @return 结果
     */
    public int insertSysUserState(SysUserState sysUserState);

    /**
     * 修改预约功能
     * 
     * @param sysUserState 预约功能
     * @return 结果
     */
    public int updateSysUserState(SysUserState sysUserState);

    /**
     * 删除预约功能
     * 
     * @param number 预约功能ID
     * @return 结果
     */
    public int deleteSysUserStateById(String number);

    /**
     * 批量删除预约功能
     * 
     * @param numbers 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysUserStateByIds(String[] numbers);
}
