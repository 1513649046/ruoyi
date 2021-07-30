package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InformationMapper;
import com.ruoyi.system.domain.Information;
import com.ruoyi.system.service.IInformationService;

/**
 * 资讯Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-23
 */
@Service
public class InformationServiceImpl implements IInformationService 
{
    @Autowired
    private InformationMapper informationMapper;

    /**
     * 查询资讯
     * 
     * @param infoId 资讯ID
     * @return 资讯
     */
    @Override
    public Information selectInformationById(Long infoId)
    {
        return informationMapper.selectInformationById(infoId);
    }

    /**
     * 查询资讯列表
     * 
     * @param information 资讯
     * @return 资讯
     */
    @Override
    public List<Information> selectInformationList(Information information)
    {

        return informationMapper.selectInformationList(information);
    }

    /**
     * 新增资讯
     * 
     * @param information 资讯
     * @return 结果
     */
    @Override
    public int insertInformation(Information information)
    {
        information.setCreateTime(DateUtils.getNowDate());
        return informationMapper.insertInformation(information);
    }

    /**
     * 修改资讯
     * 
     * @param information 资讯
     * @return 结果
     */
    @Override
    public int updateInformation(Information information)
    {
        information.setUpdateTime(DateUtils.getNowDate());
        return informationMapper.updateInformation(information);
    }

    /**
     * 批量删除资讯
     * 
     * @param infoIds 需要删除的资讯ID
     * @return 结果
     */
    @Override
    public int deleteInformationByIds(Long[] infoIds)
    {
        return informationMapper.deleteInformationByIds(infoIds);
    }

    /**
     * 删除资讯信息
     * 
     * @param infoId 资讯ID
     * @return 结果
     */
    @Override
    public int deleteInformationById(Long infoId)
    {
        return informationMapper.deleteInformationById(infoId);
    }
}
