package com.hrocloud.common.exception;

import com.hrocloud.apigw.client.define.AbstractReturnCode;

/**
 * Created by hanzhihua on 2016/11/23.
 */
public class CommonServiceHttpCode extends AbstractReturnCode {

	public CommonServiceHttpCode(String desc, int code) {
		super(desc, code);
	}

	public final static int C_NECESSARY_COLUMN_ERROR = 3001;
	public final static AbstractReturnCode NECESSARY_COLUMN_ERROR = new CommonServiceHttpCode(
			"必填字段不能为空", C_NECESSARY_COLUMN_ERROR);

	public final static int C_INSERT_FAILED = 3002;
	public final static AbstractReturnCode INSERT_FAILED = new CommonServiceHttpCode(
			"添加失败", C_INSERT_FAILED);

	public final static int C_SELECT_NOT_FOUND = 3005;
	public final static AbstractReturnCode SELECT_NOT_FOUND = new CommonServiceHttpCode(
			"查询不存在", C_SELECT_NOT_FOUND);

	public final static int C_UPDATE_FAILED = 3004;
	public final static AbstractReturnCode UPDATE_FAILED = new CommonServiceHttpCode(
			"修改失败", C_UPDATE_FAILED);

	public final static int C_DELETE_FAILED = 3003;
	public final static AbstractReturnCode DELETE_FAILED = new CommonServiceHttpCode(
			"删除失败", C_DELETE_FAILED);

	public final static int C_PARAMETER_ERROR = 3006;
	public final static AbstractReturnCode PARAMETER_ERROR = new CommonServiceHttpCode(
			"参数错误", C_PARAMETER_ERROR);

	public final static int C_INSERT_EXISTS = 3007;
	public final static AbstractReturnCode INSERT_EXIST = new CommonServiceHttpCode(
			"信息已经存在", C_INSERT_EXISTS);
	
	public final static int C_DELETEChlid_EXISTS = 3008;
	public final static AbstractReturnCode DELETEChlid_EXISTS = new CommonServiceHttpCode(
			"存在下级信息", C_DELETEChlid_EXISTS);

	public final static int C_CITYIDS_ISNULL = 3017;
	public final static AbstractReturnCode CITYIDS_ISNULL = new CommonServiceHttpCode(
			"选择城市为空", C_CITYIDS_ISNULL);

	public final static int C_CITY_ISNULL = 3018;
	public final static AbstractReturnCode CITY_ISNULL = new CommonServiceHttpCode(
			"基础城市未维护", C_CITY_ISNULL);

	public final static int C_COMMON_EXCEPTION = 3019;
	public final static AbstractReturnCode COMMON_EXCEPTION = new CommonServiceHttpCode(
			"系统执行sql或Java异常", C_COMMON_EXCEPTION);

}
