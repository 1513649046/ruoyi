package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TypeMapper;
import com.ruoyi.system.domain.Type;
import com.ruoyi.system.service.ITypeService;

/**
 * 更多资讯Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-23
 */
@Service
public class TypeServiceImpl implements ITypeService 
{
    @Autowired
    private TypeMapper typeMapper;

    /**
     * 查询更多资讯
     * 
     * @param typeId 更多资讯ID
     * @return 更多资讯
     */
    @Override
    public Type selectTypeById(Integer typeId)
    {
        return typeMapper.selectTypeById(typeId);
    }

    /**
     * 查询更多资讯列表
     * 
     * @param type 更多资讯
     * @return 更多资讯
     */
    @Override
    public List<Type> selectTypeList(Type type)
    {
        return typeMapper.selectTypeList(type);
    }

    /**
     * 新增更多资讯
     * 
     * @param type 更多资讯
     * @return 结果
     */
    @Override
    public int insertType(Type type)
    {
        type.setCreateTime(DateUtils.getNowDate());
        return typeMapper.insertType(type);
    }

    /**
     * 修改更多资讯
     * 
     * @param type 更多资讯
     * @return 结果
     */
    @Override
    public int updateType(Type type)
    {
        type.setUpdateTime(DateUtils.getNowDate());
        return typeMapper.updateType(type);
    }

    /**
     * 批量删除更多资讯
     * 
     * @param typeIds 需要删除的更多资讯ID
     * @return 结果
     */
    @Override
    public int deleteTypeByIds(Integer[] typeIds)
    {
        return typeMapper.deleteTypeByIds(typeIds);
    }

    /**
     * 删除更多资讯信息
     * 
     * @param typeId 更多资讯ID
     * @return 结果
     */
    @Override
    public int deleteTypeById(Integer typeId)
    {
        return typeMapper.deleteTypeById(typeId);
    }
}
