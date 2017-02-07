package com.hrocloud.common.dto;

import java.io.Serializable;
import java.util.Date;

import com.hrocloud.apigw.client.annoation.Description;
import com.hrocloud.common.model.CommParamInfo;
/**
 * 
 * Created by zfy on 2016/12/7.
 * 公共参数信息表
 */
@Description("公共参数信息表")
public class CommParamInfoDTO implements Serializable{
    /**
	 * 实现序列化
	 */
	private static final long serialVersionUID = 5014734065280030920L;

	@Description("参数信息id")
  	public int id;

	 @Description("创建人")
	 public long createBy;
	
    @Description("创建时间")
    public long createTime;
    
    @Description("最后更新时间")
    public long updateTime;
    
    @Description("最后人")
    public long updateBy;
    
    @Description("所属公司")
	 public int companyId;

    @Description("编码")
   	public String paramCode;
    
	@Description("参数类型")
	public String paramType;

	@Description("参数名称")
	public String paramName;

	@Description("备注")
	public String comment;
	
	@Description("类型名称")
	public String typeName;
	
	@Description("显示公司名称")
  	public String companyIdDis;
	
	/*public CommParamInfoDTO(CommParamInfo commParamInfo){
		this.id=commParamInfo.getId();
		this.createBy=commParamInfo.getCreateBy()==null?0:commParamInfo.getCreateBy();
		this.createTime=commParamInfo.getCreateTime()==null?0:commParamInfo.getCreateTime().getTime();
		this.updateBy=commParamInfo.getUpdateBy()==null?0:commParamInfo.getUpdateBy();
		this.updateTime=commParamInfo.getUpdateTime()==null?0:commParamInfo.getCreateTime().getTime();
		this.paramType=commParamInfo.getParamType();
		this.paramName=commParamInfo.getParamName();
		this.comment=commParamInfo.getComment();
	}
*/
	
}