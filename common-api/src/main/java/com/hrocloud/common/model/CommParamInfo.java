package com.hrocloud.common.model;

import java.io.Serializable;
import java.util.Date;

import com.hrocloud.common.api.model.BaseObj;

/**
 * 
 * Created by zfy on 2016/12/7.
 * 公共参数信息表
 */
public class CommParamInfo extends BaseObj implements Serializable{
    /**
	 * 实现序列化
	 */
	private static final long serialVersionUID = 5014734065280030920L;

	private String paramCode;
	
	private String paramType;

    private String paramName;

    private String comment;
    
    private int companyId;
    
    private CommParamType commParamType;
    
    private Integer id;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;
    
    
	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public CommParamType getCommParamType() {
		return commParamType;
	}

	public void setCommParamType(CommParamType commParamType) {
		this.commParamType = commParamType;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

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

	

}