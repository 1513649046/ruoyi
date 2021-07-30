package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 更多资讯对象 type
 * 
 * @author ruoyi
 * @date 2021-07-23
 */
public class Type extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 类型id */
    private Integer typeId;

    /** 资讯类型 */
    @Excel(name = "资讯类型")
    private String infoType;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

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
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("typeId", getTypeId())
            .append("infoType", getInfoType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("sort", getSort())
            .toString();
    }
}
