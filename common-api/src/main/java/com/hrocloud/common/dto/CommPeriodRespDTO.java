package com.hrocloud.common.dto;
  

import java.io.Serializable;


import java.util.List;

import com.hrocloud.apigw.client.annoation.Description;
import com.hrocloud.common.model.CommPeriodResp;
@Description("城市信息分页")
public class CommPeriodRespDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2083375612555101038L;
	
	@Description("当前页码")
	public int page;//当前页码
	@Description("总页数")
	public int total;//总页数
	@Description("总行数")
	public int records;//数据行总数的数据
	@Description("表格中的数据")
	public List<CommPeriodResp> rows;

	@Override
	public String toString() {
		return "PageDTO [page=" + page + ", total=" + total + ", records="
				+ records + ", rows=" + rows + "]";
	}
}