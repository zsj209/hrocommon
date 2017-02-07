package com.hrocloud.common.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hrocloud.common.api.model.BaseObj;
/**
 * 
 * Created by zfy on 2016/12/7.
 * 期间表
 */
public class CommPeriod extends BaseObj implements Serializable {
    /**
	 * 序列化
	 */
	private static final long serialVersionUID = -8506212939789650249L;


	private String periodCode;

    private String periodYear;

    private String periodMonth;

    private String startTime;

    private String endTime;
    
    private Integer companyId;

    private String comment;
    
    private Integer id;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public String getPeriodCode() {
		return periodCode;
	}


	public void setPeriodCode(String periodCode) {
		this.periodCode = periodCode;
	}


	public String getPeriodYear() {
		return periodYear;
	}


	public void setPeriodYear(String periodYear) {
		this.periodYear = periodYear;
	}


	public String getPeriodMonth() {
		return periodMonth;
	}


	public void setPeriodMonth(String periodMonth) {
		this.periodMonth = periodMonth;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


}