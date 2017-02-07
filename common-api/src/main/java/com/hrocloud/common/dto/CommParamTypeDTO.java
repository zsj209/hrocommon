package com.hrocloud.common.dto;
  

import java.io.Serializable;


import java.util.List;

import com.hrocloud.apigw.client.annoation.Description;
import com.hrocloud.common.model.CommParamType;
@Description("参数信息")
public class CommParamTypeDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2083375612555101038L;
	

	@Description("类型id")
  	public int id;

    @Description("创建时间")
    public String createTime;
    
	@Description("创建人")
    public int createBy;
	
	 @Description("更改人")
     public int updateBy;
	
    @Description("公司id")
  	public int companyId;
    
    @Description("最后更新时间")
    public String updateTime;
    
    @Description("编码")
	public String typeCode;
    
	@Description("参数类型名称")
	public String typeName;
	
	@Description("不可修改标志")
	public String typeIsupdate;

	@Description("不可修改标志")
	public String comment;
	
	 @Description("显示公司名称")
	 public String companyIdDis;
	    

	
	/*public CommParamTypeDTO(){}
	public CommParamTypeDTO(CommParamType commParamType){
		this.id=commParamType.getId();
		this.createTime=commParamType.getCreateTime()==null?0:commParamType.getCreateTime().getTime();
		this.updateTime=commParamType.getUpdateTime()==null?0:commParamType.getUpdateTime().getTime();
		this.typeName=commParamType.getTypeName();
		this.typeIsupdate=commParamType.getTypeIsupdate();
		this.comment=commParamType.getComment();
	}*/
}