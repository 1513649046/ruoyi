package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Type;

/**
 * 更多资讯Service接口
 * 
 * @author ruoyi
 * @date 2021-07-23
 */
public interface ITypeService 
{
    /**
     * 查询更多资讯
     * 
     * @param typeId 更多资讯ID
     * @return 更多资讯
     */
    public Type selectTypeById(Integer typeId);

    /**
     * 查询更多资讯列表
     * 
     * @param type 更多资讯
     * @return 更多资讯集合
     */
    public List<Type> selectTypeList(Type type);

    /**
     * 新增更多资讯
     * 
     * @param type 更多资讯
     * @return 结果
     */
    public int insertType(Type type);

    /**
     * 修改更多资讯
     * 
     * @param type 更多资讯
     * @return 结果
     */
    public int updateType(Type type);

    /**
     * 批量删除更多资讯
     * 
     * @param typeIds 需要删除的更多资讯ID
     * @return 结果
     */
    public int deleteTypeByIds(Integer[] typeIds);

    /**
     * 删除更多资讯信息
     * 
     * @param typeId 更多资讯ID
     * @return 结果
     */
    public int deleteTypeById(Integer typeId);
}
