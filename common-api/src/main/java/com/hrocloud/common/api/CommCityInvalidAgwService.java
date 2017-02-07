package com.hrocloud.common.api;

import java.util.List;

import com.hrocloud.apigw.client.annoation.ApiAutowired;
import com.hrocloud.apigw.client.annoation.ApiGroup;
import com.hrocloud.apigw.client.annoation.ApiParameter;
import com.hrocloud.apigw.client.annoation.HttpApi;
import com.hrocloud.apigw.client.define.CommonParameter;
import com.hrocloud.apigw.client.define.SecurityType;
import com.hrocloud.common.dto.CommCityInvalidDTO;
import com.hrocloud.common.dto.CommCityInvalidPageDTO;
import com.hrocloud.common.exception.CommonServiceHttpCode;

/**
 * 
 * Created by darren on 2017/1/12. 开通城市网关接口
 */
@ApiGroup(name = "commoncityinvalid", minCode = 3000, maxCode = 4000, codeDefine = CommonServiceHttpCode.class, owner = "darren")
public interface CommCityInvalidAgwService {

	@HttpApi(name = "commoncityinvalid.getcityforset", desc = "基于设置获取开通城市", security = SecurityType.UserLogin)
	List<CommCityInvalidDTO> getInvalidCityForSet(
			@ApiParameter(required = true, name = "rootcompanyid", desc = "根城市id", defaultValue = "1") String rootcompanyid,
			@ApiParameter(required = true, name = "curcompanyid", desc = "hro公司城市id") String curcompanyid);

	@HttpApi(name = "commoncityinvalid.saveinvcity", desc = "保存开通城市", security = SecurityType.UserLogin)
	boolean saveInvalidCity(
			@ApiAutowired(CommonParameter.userId) String userId,
			@ApiParameter(required = true, name = "rootcompanyid", desc = "根城市id", defaultValue = "1") String rootcompanyid,
			@ApiParameter(required = true, name = "curcompanyid", desc = "hro公司城市id") String curcompanyid,
			@ApiParameter(required = true, name = "cityids", desc = "城市Ids") String cityids);

	@HttpApi(name = "commoncityinvalid.selectInvalCityList", desc = "选择开通城市信息", security = SecurityType.UserLogin)
	CommCityInvalidPageDTO selectInvalCityList(
			@ApiParameter(required = true, name = "companyid", desc = "hro公司城市id") String companyid,
			@ApiParameter(required = false, name = "cityname", desc = "城市名臣") String cityname,
			@ApiParameter(required = true, name = "rows", desc = "每页显示条数") int rows,
			@ApiParameter(required = true, name = "page", desc = "当前页") int page);
}
