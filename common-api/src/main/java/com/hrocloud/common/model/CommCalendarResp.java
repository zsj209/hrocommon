package com.hrocloud.common.model;

import java.io.Serializable;
import java.util.List;

import com.hrocloud.apigw.client.annoation.Description;
/**
 * 
 * Created by zfy on 2016/12/8.
 * 公共日历表响应信息
 */
@Description("公共日历字段响应信息")
public class CommCalendarResp implements Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 2416690261600231881L;
	@Description("日历id")
  	public int id;
	
	@Description("创建时间")
	public String createTime;
	
	@Description("创建人")
    public int createBy;
	
	@Description("更新人")
    public int updateBy;

    @Description("更新时间")
    public String updateTime;

    @Description("所属公司")
    public int companyId;
    
	@Description("期间编码")
    public String calCode;

	@Description("期间编码名称")
    public String calCodeName;
	
	@Description("日期")
    public String calDate;

	@Description("日期类型")
    public String calType;

	@Description("所属公司显示名称")
	public String companyIdDis;

	@Description("备注")
    public String comment;
	

}