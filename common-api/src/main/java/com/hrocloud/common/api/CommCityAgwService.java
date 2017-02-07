package com.hrocloud.common.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hrocloud.apigw.client.annoation.ApiAutowired;
import com.hrocloud.apigw.client.annoation.ApiGroup;
import com.hrocloud.apigw.client.annoation.ApiParameter;
import com.hrocloud.apigw.client.annoation.DesignedErrorCode;
import com.hrocloud.apigw.client.annoation.HttpApi;
import com.hrocloud.apigw.client.define.CommonParameter;
import com.hrocloud.apigw.client.define.SecurityType;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.dto.CommCityRespDTO;
import com.hrocloud.common.model.CommCity;
import com.hrocloud.common.model.CommCityResp;


/**
 * 
 * Created by zfy on 2016/12/2.
 * 省份城市对外接口
 */
@ApiGroup(name = "commoncity", minCode = 3000, maxCode = 4000, codeDefine = CommonServiceHttpCode.class, owner = "zfy")
public interface CommCityAgwService {
	@HttpApi(name = "commoncity.deleteCity", desc = "刪除城市信息", security = SecurityType.UserLogin)
	@DesignedErrorCode({ CommonServiceHttpCode.C_DELETE_FAILED,
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
		CommonServiceHttpCode.C_DELETEChlid_EXISTS,
		CommonServiceHttpCode.C_SELECT_NOT_FOUND,
		CommonServiceHttpCode.C_PARAMETER_ERROR
		})
	int deleteCityByPrimaryKey(
		@ApiAutowired(CommonParameter.clientIp) String clientIp,
        @ApiAutowired(CommonParameter.deviceId) long deviceId,
        @ApiAutowired(CommonParameter.applicationId) long applicationId,
		@ApiParameter(required = true, name = "delIds", desc = "城市id")String delIds
	);
	
	@HttpApi(name = "commoncity.insertCity", desc = "添加城市信息", security = SecurityType.UserLogin)//Staffinfo record
	@DesignedErrorCode({
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
		CommonServiceHttpCode.C_INSERT_EXISTS,
		CommonServiceHttpCode.C_INSERT_FAILED,
		CommonServiceHttpCode.C_PARAMETER_ERROR
		})
	int insertCity(
		@ApiAutowired(CommonParameter.clientIp) String clientIp,
        @ApiAutowired(CommonParameter.deviceId) long deviceId,
        @ApiAutowired(CommonParameter.userId) int userId,
		@ApiParameter(required = true, name = "data", desc = "备注") String data
		
    );
	
	@HttpApi(name = "commoncity.selectCityListByColumn", desc = "查询城市信息", security = SecurityType.UserLogin)
	CommCityRespDTO selectCityListByColumn(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
			@ApiParameter(required = false, name = "id", desc = "城市id") int id,
			@ApiParameter(required = false, name = "createBy", desc = "创建人") int createBy,
			@ApiParameter(required = false, name = "updateBy", desc = "更改人") int updateBy,
			@ApiParameter(required = false, name = "companyId", desc = "所属公司") int companyId,
			@ApiParameter(required = false, name = "cityCode", desc = "编码") String cityCode,
			@ApiParameter(required = false, name = "cityName", desc = "省市区名称") String cityName,
			@ApiParameter(required = false, name = "cityPid", desc = "所属上级") String cityPid,
			@ApiParameter(required = false, name = "cityType", desc = "城市类型") String cityType,
			@ApiParameter(required = false, name = "comment", desc = "备注") String comment,
			@ApiParameter(required = true, name = "rows", desc = "每页显示条数") int rows,
	        @ApiParameter(required = true, name = "page", desc = "当前页") int page
			);
	@HttpApi(name = "commoncity.updateCityByPrimaryKey", desc = "更改城市信息", security = SecurityType.UserLogin)
	@DesignedErrorCode({
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
		CommonServiceHttpCode.C_UPDATE_FAILED,
		CommonServiceHttpCode.C_SELECT_NOT_FOUND,
		CommonServiceHttpCode.C_PARAMETER_ERROR
		})
	int updateByPrimaryKey(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.userId) int userId,
        	@ApiParameter(required = true, name = "data", desc = "备注") String data
			);
	
	@HttpApi(name = "commoncity.queryTreeCityList", desc = "递归城市列表", security = SecurityType.UserLogin)
	List<CommCityResp> queryTreeCityList(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
			@ApiParameter(required = false, name = "cityPid", desc = "城市id") int cityPid
			);
	
	@HttpApi(name = "commoncity.selectCityById", desc = "根据id查询下级级点", security = SecurityType.UserLogin)
	CommCityResp selectCityById(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
			@ApiParameter(required = true, name = "id", desc = "城市id") int id
			);
	 @HttpApi(name = "commoncity.selectDataByIds", desc = "根据id批量查询城市信息", security = SecurityType.UserLogin)
	    ArrayList<CommCityResp> selectDataListByIds(
	            @ApiAutowired(CommonParameter.clientIp) String clientIp,
	            @ApiAutowired(CommonParameter.deviceId) long deviceId,
	            @ApiAutowired(CommonParameter.applicationId) long applicationId,
	            @ApiParameter(required = true, name = "selIds", desc = "ID字符串") String selIds);

		@HttpApi(name = "commoncity.selectAllCityListByColumn", desc = "查询城市信息", security = SecurityType.UserLogin)
		CommCityRespDTO selectAllCityListByColumn(
				@ApiAutowired(CommonParameter.clientIp) String clientIp,
	            @ApiAutowired(CommonParameter.deviceId) long deviceId,
	            @ApiAutowired(CommonParameter.applicationId) long applicationId,
				@ApiParameter(required = false, name = "id", desc = "城市id") int id,
				@ApiParameter(required = false, name = "cityCode", desc = "编码") String cityCode,
				@ApiParameter(required = false, name = "cityName", desc = "省市区名称") String cityName,
				@ApiParameter(required = false, name = "cityPid", desc = "所属上级") String cityPid,
				@ApiParameter(required = false, name = "cityType", desc = "城市类型") String cityType,
				@ApiParameter(required = false, name = "types", desc = "备注") int types,
				@ApiParameter(required = true, name = "rows", desc = "每页显示条数") int rows,
		        @ApiParameter(required = true, name = "page", desc = "当前页") int page
				);
		/*@HttpApi(name = "commoncity.queryChlidrenByCode", desc = "根据编码查询下级级点", security = SecurityType.UserLogin)
		List<CommCityResp> queryChlidrenByCode(
				@ApiParameter(required = true, name = "cityCode", desc = "城市cityCode") String cityCode
				);*/
}
