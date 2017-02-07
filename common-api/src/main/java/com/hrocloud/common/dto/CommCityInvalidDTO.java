package com.hrocloud.common.dto;

import java.io.Serializable;

import com.hrocloud.apigw.client.annoation.Description;

@Description("开通城市信息")
public class CommCityInvalidDTO implements Serializable {

	private static final long serialVersionUID = 6882133701349553939L;

	@Description("id")
	public int id; // 本表id, 如果是通过selectInvalidCityForSet查询，则是城市表id

	@Description("所属公司Id")
	public int companyId; // 所属公司Id

	@Description("城市id")
	public int cityId; // 城市id

	@Description("城市编码")
	public String cityCode; // 城市编码

	@Description("城市名称")
	public String CityName; // 城市名称

	@Description("所属上级Id")
	public String cityPid; // 所属上级Id

	@Description("所属上级Code")
	public String cityPcode; // 所属上级Code

	// 以下2个字段主要是为了构造设置开通城市树
	@Description("下级列表")
	public String sublist;

	@Description("设置样式")
	public String setstyle; // 设置样式

}