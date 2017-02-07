package com.hrocloud.common.model;

import java.io.Serializable;
import java.util.List;

import com.hrocloud.apigw.client.annoation.Description;
/**
 * 
 * Created by zfy on 2016/12/2.
 * 公共类城市响应字段
 */
@Description("公共城市字段信息")
public class CommCityResp implements Serializable {

	/**
	 * 实现序列化
	 */
	private static final long serialVersionUID = -8675006742513055646L;
	@Description("城市id")
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
    public String companyId;
    
    @Description("城市编码")
	public String cityCode;
    
	@Description("城市名称")
	public String cityName;

	@Description("所属上级")
    public String cityPid;

	@Description("城市类型(1省份、2城市、3区县)")
    public String cityType;
	
	@Description("是否有效")
	public String cityIsvalid;

	@Description("备注")
    public String comment;
	
	@Description("城市类型名称")
    public String cityTypeName;
	
	@Description("省份显示")
    public String cityPidShow;
	
	@Description("返回城市列表信息")
	public List<CommCityResp> list;
	
}
