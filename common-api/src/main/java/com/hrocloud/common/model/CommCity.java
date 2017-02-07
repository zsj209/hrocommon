package com.hrocloud.common.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.hrocloud.common.api.model.BaseObj;

/**
 * 
 * Created by zfy on 2016/12/7.
 * 公共类城市
 *
 */
public class CommCity extends BaseObj implements Serializable{
    /**
	 * 序列化
	 */
	private static final long serialVersionUID = 2360702177138201303L;
	
	private Integer id;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;
    
    private Integer companyId;
    
    private String cityCode;//城市编码
    
    private String  cityName;//城市名称

    private String cityPid;//所属上级

    private String cityType;//城市类型

    private String cityIsvalid;//是否启用

    private String comment;//备注

    private List<CommCity> list;//城市集合
    
    
    
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

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public List<CommCity> getList() {
		return list;
	}

	public void setList(List<CommCity> list) {
		this.list = list;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public String getCityPid() {
		return cityPid;
	}

	public void setCityPid(String cityPid) {
		this.cityPid = cityPid;
	}

	public String getCityType() {
		return cityType;
	}

	public void setCityType(String cityType) {
		this.cityType = cityType;
	}

	public String getCityIsvalid() {
		return cityIsvalid;
	}

	public void setCityIsvalid(String cityIsvalid) {
		this.cityIsvalid = cityIsvalid;
	}

	public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

	public List<CommCity> getCommCityLists() {
		return list;
	}

	public void setCommCityLists(List<CommCity> list) {
		this.list = list;
	}
    
}