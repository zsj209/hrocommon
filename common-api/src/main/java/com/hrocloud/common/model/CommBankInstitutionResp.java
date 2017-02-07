package com.hrocloud.common.model;

import java.io.Serializable;
import java.util.Date;

import com.hrocloud.apigw.client.annoation.Description;
import com.hrocloud.common.api.model.BaseObj;
@Description("银行机构")
public class CommBankInstitutionResp implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8116900316460203203L;

	@Description("银行机构id")
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

	@Description("银行名称")
    public String bankName;

	@Description("银行简称")
    public String bankCname;

	@Description("备注")
    public String comment;

}