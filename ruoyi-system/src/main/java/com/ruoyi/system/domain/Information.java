package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资讯对象 information
 * 
 * @author ruoyi
 * @date 2021-07-23
 */
public class Information extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 资讯id */
    private Long infoId;

    /** 资讯标题 */
    @Excel(name = "资讯标题")
    private String infoTitle;

    /** 资讯内容 */
    @Excel(name = "资讯内容")
    private String infoContent;

    /** 资讯状态 */
    @Excel(name = "资讯状态")
    private String infoStates;

    /** 类型id */
    private Integer typeId;

    /** 资讯类型 */
    @Excel(name = "资讯类型")
    private String infoType;

    /** 删除标志 */
    @Excel(name = "删除标志")
    private Integer deleteFlag;

    /** 排序 */
    @Excel(name = "排序")
    private Integer infoSort;

    /** 备注 */
    @Excel(name = "备注")
    private String infoRemarks;

    /** 是否首页 */
    private String isFpage;

    /** 浏览量 */
    private Long infoViews;

    /** 留言 */
    private String infoMassage;

    /** 热度 */
    private String isHotinfo;

    public void setInfoId(Long infoId) 
    {
        this.infoId = infoId;
    }

    public Long getInfoId() 
    {
        return infoId;
    }
    public void setInfoTitle(String infoTitle) 
    {
        this.infoTitle = infoTitle;
    }

    public String getInfoTitle() 
    {
        return infoTitle;
    }
    public void setInfoContent(String infoContent) 
    {
        this.infoContent = infoContent;
    }

    public String getInfoContent() 
    {
        return infoContent;
    }
    public void setInfoStates(String infoStates) 
    {
        this.infoStates = infoStates;
    }

    public String getInfoStates() 
    {
        return infoStates;
    }
    public void setTypeId(Integer typeId) 
    {
        this.typeId = typeId;
    }

    public Integer getTypeId() 
    {
        return typeId;
    }
    public void setInfoType(String infoType) 
    {
        this.infoType = infoType;
    }

    public String getInfoType() 
    {
        return infoType;
    }
    public void setDeleteFlag(Integer deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public Integer getDeleteFlag() 
    {
        return deleteFlag;
    }
    public void setInfoSort(Integer infoSort) 
    {
        this.infoSort = infoSort;
    }

    public Integer getInfoSort() 
    {
        return infoSort;
    }
    public void setInfoRemarks(String infoRemarks) 
    {
        this.infoRemarks = infoRemarks;
    }

    public String getInfoRemarks() 
    {
        return infoRemarks;
    }
    public void setIsFpage(String isFpage) 
    {
        this.isFpage = isFpage;
    }

    public String getIsFpage() 
    {
        return isFpage;
    }
    public void setInfoViews(Long infoViews) 
    {
        this.infoViews = infoViews;
    }

    public Long getInfoViews() 
    {
        return infoViews;
    }
    public void setInfoMassage(String infoMassage) 
    {
        this.infoMassage = infoMassage;
    }

    public String getInfoMassage() 
    {
        return infoMassage;
    }
    public void setIsHotinfo(String isHotinfo) 
    {
        this.isHotinfo = isHotinfo;
    }

    public String getIsHotinfo() 
    {
        return isHotinfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("infoId", getInfoId())
            .append("infoTitle", getInfoTitle())
            .append("infoContent", getInfoContent())
            .append("infoStates", getInfoStates())
            .append("typeId", getTypeId())
            .append("infoType", getInfoType())
            .append("deleteFlag", getDeleteFlag())
            .append("infoSort", getInfoSort())
            .append("infoRemarks", getInfoRemarks())
            .append("isFpage", getIsFpage())
            .append("infoViews", getInfoViews())
            .append("infoMassage", getInfoMassage())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("isHotinfo", getIsHotinfo())
            .toString();
    }
}
