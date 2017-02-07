package com.hrocloud.common.model;

import java.io.Serializable;

import com.hrocloud.apigw.client.annoation.Description;
/**
 * 
 * Created by zfy on 2016/12/2.
 *公共字段响应
 */
@Description("公共字段信息")
public class CommonResp implements Serializable {

	/**
	 * 实现序列化
	 */
	public static final long serialVersionUID = -2713370010500179470L;
	@Description("合同id")
  	public int id;

	@Description("创建人")
    public String createBy;

    @Description("创建时间")
    public String createTime;

    @Description("更新人")
    public String updateBy;

    @Description("更新时间")
    public String updateTime;

    @Description("所属公司")
    public String companyId;
}
