package com.hrocloud.common.model;

import java.util.Date;

import com.hrocloud.common.api.model.BaseObj;

public class CommCityInvalid extends BaseObj {

	private static final long serialVersionUID = -2332800764112710763L;

	private Integer id; // 本表id, 如果是通过selectInvalidCityForSet查询，则是城市表id
	private Integer createBy;
	private Date createTime;
	private Integer updateBy;
	private Date updateTime;
	private Integer companyId; // 所属公司Id
	private Integer cityId; // 城市id
	private String cityCode; // 城市编码
	private String CityName; // 城市名称
	private String cityPid; // 所属上级Id
	private String cityPcode = ""; // 所属上级Code
	private String comment;

	// 以下5个字段主要是为了构造设置开通城市树
	private String sublist = ""; // 下级列表
	private Integer subnums = 0; // 下级数量
	private Integer subvalidnums = 0; // 已开通的下级数量
	private Integer selfvalidnums = 0; // 已开通的本节点数量
	private String setstyle = ""; // 设置样式

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

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getCityPid() {
		return cityPid;
	}

	public void setCityPid(String cityPid) {
		this.cityPid = cityPid;
	}

	public String getCityPcode() {
		return cityPcode;
	}

	public void setCityPcode(String cityPcode) {
		this.cityPcode = cityPcode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSublist() {
		return sublist;
	}

	public void setSublist(String sublist) {
		this.sublist = sublist;
	}

	public Integer getSubnums() {
		return subnums;
	}

	public void setSubnums(Integer subnums) {
		this.subnums = subnums;
	}

	public Integer getSubvalidnums() {
		return subvalidnums;
	}

	public void setSubvalidnums(Integer subvalidnums) {
		this.subvalidnums = subvalidnums;
	}

	public Integer getSelfvalidnums() {
		return selfvalidnums;
	}

	public void setSelfvalidnums(Integer selfvalidnums) {
		this.selfvalidnums = selfvalidnums;
	}

	public String getSetstyle() {
		return setstyle;
	}

	public void setSetstyle(String setstyle) {
		this.setstyle = setstyle;
	}
}