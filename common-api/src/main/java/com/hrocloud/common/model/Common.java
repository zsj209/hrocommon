package com.hrocloud.common.model;

import java.io.Serializable;

/**
 * 
 * Created by zfy on 2016/12/7.
 *公共字段
 */
public class Common implements Serializable{
	/**
	 * 实现序列化
	 */
	private static final long serialVersionUID = -244797467616894696L;

	private String id;

    private String createBy;

    private String createTime;

    private String updateBy;

    private String updateTime;

    private String companyId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
   
}
