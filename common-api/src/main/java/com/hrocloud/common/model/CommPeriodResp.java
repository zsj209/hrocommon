package com.hrocloud.common.model;

import java.io.Serializable;
import java.util.List;

import com.hrocloud.apigw.client.annoation.Description;
/**
 * 
 * Created by zfy on 2016/12/8.
 * 期间表
 */
@Description("公共期间响应字段")
public class CommPeriodResp implements Serializable {
	/**
	 * 序列化
	 */

	private static final long serialVersionUID = -4226854241093548111L;
	@Description("合同id")
  	public int id;
	
	@Description("创建人")
    public int createBy;
	
	 @Description("创建时间")
	 public String createTime;
	 
	 @Description("更改人")
     public int updateBy;

	 @Description("更改时间")
     public String updateTime;
	
	 @Description("所属公司")
	 public int companyId;
	 
	@Description("期间编码")
    public String periodCode;

	@Description("期间年份")
    public String periodYear;

	@Description("期间月份")
    public String periodMonth;

	@Description("开始日期")
    public String startTime;

	@Description("截止日期")
    public String endTime;

	@Description("公司名称")
    public String companyIdDis;
	
	@Description("备注")
    public String comment;
	
//	@Description("返回期间集合信息")
//	public List<CommPeriodResp> list;
	

}