package com.hrocloud.common.model;
 
import java.io.Serializable;

import com.hrocloud.apigw.client.annoation.Description;
@Description("根据ID查询返回数据集")
public class PubForIdselobj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5862411455612684236L;
	
	@Description("ID")
	public int id;
	
	@Description("第一列值")
	public String strVla;
	
	@Description("第二列值")
	public String strVlb;
	
	@Description("第三列值")
	public String strVlc;
	
	@Description("第四列值")
	public String strVld;
	
	@Description("第五列值")
	public String strVle;
	
	@Description("第六列值")
	public String strVlf;
	
	@Description("第七列值")
	public String strVlg;
	
	@Description("第八列值")
	public String strVlh;
	
	@Description("第九列值")
	public String strVli;
	
	@Description("第十列值")
	public String strVlj;
	
	public PubForIdselobj(){
		
	}
}