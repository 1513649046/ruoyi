package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预约功能对象 sys_user_state
 * 
 * @author ruoyi
 * @date 2021-07-20
 */
public class SysUserState extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String number;

    /** 预约状态 */
    @Excel(name = "预约状态")
    private String state;

    /** 昵称 */
    @Excel(name = "昵称")
    private String uid;

    /** 身份证 */
    @Excel(name = "身份证")
    private Long cardid;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private Long phonenumber;

    /** 携带人数 */
    @Excel(name = "携带人数")
    private Integer getnum;

    /** 预约时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预约时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statetime;

    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getNumber() 
    {
        return number;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setUid(String uid) 
    {
        this.uid = uid;
    }

    public String getUid() 
    {
        return uid;
    }
    public void setCardid(Long cardid) 
    {
        this.cardid = cardid;
    }

    public Long getCardid() 
    {
        return cardid;
    }
    public void setPhonenumber(Long phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public Long getPhonenumber() 
    {
        return phonenumber;
    }
    public void setGetnum(Integer getnum) 
    {
        this.getnum = getnum;
    }

    public Integer getGetnum() 
    {
        return getnum;
    }
    public void setStatetime(Date statetime) 
    {
        this.statetime = statetime;
    }

    public Date getStatetime() 
    {
        return statetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("number", getNumber())
            .append("state", getState())
            .append("uid", getUid())
            .append("cardid", getCardid())
            .append("phonenumber", getPhonenumber())
            .append("getnum", getGetnum())
            .append("statetime", getStatetime())
            .toString();
    }
}
