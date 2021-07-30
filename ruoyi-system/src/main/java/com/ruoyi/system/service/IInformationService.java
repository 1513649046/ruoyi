package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Information;

/**
 * 资讯Service接口
 * 
 * @author ruoyi
 * @date 2021-07-23
 */
public interface IInformationService 
{
    /**
     * 查询资讯
     * 
     * @param infoId 资讯ID
     * @return 资讯
     */
    public Information selectInformationById(Long infoId);

    /**
     * 查询资讯列表
     * 
     * @param information 资讯
     * @return 资讯集合
     */
    public List<Information> selectInformationList(Information information);

    /**
     * 新增资讯
     * 
     * @param information 资讯
     * @return 结果
     */
    public int insertInformation(Information information);

    /**
     * 修改资讯
     * 
     * @param information 资讯
     * @return 结果
     */
    public int updateInformation(Information information);

    /**
     * 批量删除资讯
     * 
     * @param infoIds 需要删除的资讯ID
     * @return 结果
     */
    public int deleteInformationByIds(Long[] infoIds);

    /**
     * 删除资讯信息
     * 
     * @param infoId 资讯ID
     * @return 结果
     */
    public int deleteInformationById(Long infoId);
}
