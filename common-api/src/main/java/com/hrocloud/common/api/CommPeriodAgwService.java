package com.hrocloud.common.api;

import java.util.ArrayList;
import java.util.List;

import com.hrocloud.apigw.client.annoation.ApiAutowired;
import com.hrocloud.apigw.client.annoation.ApiGroup;
import com.hrocloud.apigw.client.annoation.ApiParameter;
import com.hrocloud.apigw.client.annoation.DesignedErrorCode;
import com.hrocloud.apigw.client.annoation.HttpApi;
import com.hrocloud.apigw.client.define.CommonParameter;
import com.hrocloud.apigw.client.define.SecurityType;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.dto.CommPeriodRespDTO;
import com.hrocloud.common.model.CommPeriodResp;


/**
 * 
 * Created by zfy on 2016/12/2.
 * 公共期间对外接口
 */
@ApiGroup(name = "commperiod", minCode = 3000, maxCode = 4000, codeDefine = CommonServiceHttpCode.class, owner = "zfy")
public interface CommPeriodAgwService {
	@HttpApi(name = "commperiod.deletePeriod", desc = "刪除公共期间信息", security = SecurityType.UserLogin)
	@DesignedErrorCode({ CommonServiceHttpCode.C_DELETE_FAILED,
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
        CommonServiceHttpCode.C_PARAMETER_ERROR,
        CommonServiceHttpCode.C_SELECT_NOT_FOUND
		})
	int deletePeriod(
		@ApiAutowired(CommonParameter.clientIp) String clientIp,
        @ApiAutowired(CommonParameter.deviceId) long deviceId,
        @ApiAutowired(CommonParameter.applicationId) long applicationId,
		@ApiParameter(required = true, name = "delIds", desc = "公共期间id")String delIds
	);
	
	@HttpApi(name = "commperiod.insertPeriod", desc = "添加公共期间信息", security = SecurityType.UserLogin)//Staffinfo record
	@DesignedErrorCode({
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
        CommonServiceHttpCode.C_INSERT_EXISTS,
        CommonServiceHttpCode.C_INSERT_FAILED,
        CommonServiceHttpCode.C_PARAMETER_ERROR,
        CommonServiceHttpCode.C_SELECT_NOT_FOUND
		})
	int insertPeriod(
		@ApiAutowired(CommonParameter.clientIp) String clientIp,
        @ApiAutowired(CommonParameter.deviceId) long deviceId,
        @ApiAutowired(CommonParameter.userId) int userId,
		@ApiParameter(required = false, name = "data", desc = "备注") String data
		
    );
	

	@HttpApi(name = "commperiod.selectPeriodByColumn", desc = "查询公共期间信息", security = SecurityType.UserLogin)
	CommPeriodRespDTO selectPeriodByColumn(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
			@ApiParameter(required = false, name = "id", desc = "公共期间id") int id,
			@ApiParameter(required = false, name = "createBy", desc = "创建人") int createBy,
			@ApiParameter(required = false, name = "updateBy", desc = "更改人") int updateBy,
			//@ApiAutowired(CommonParameter.companyId) int companyId,
			@ApiParameter(required = false, name = "companyId", desc = "所属公司") int companyId,
			@ApiParameter(required = false, name = "periodCode", desc = "期间编码") String periodCode,
			@ApiParameter(required = false, name = "periodYear", desc = "期间年份") String periodYear,
			@ApiParameter(required = false, name = "periodMonth", desc = "期间月份") String periodMonth,
			@ApiParameter(required = false, name = "startTime", desc = "开始日期") String startTime,
			@ApiParameter(required = false, name = "endTime", desc = "截止日期") String endTime,
			@ApiParameter(required = false, name = "comment", desc = "备注") String comment,
			@ApiParameter(required = true, name = "rows", desc = "每页显示条数") int rows,
	        @ApiParameter(required = true, name = "page", desc = "当前页") int page
			);
	@HttpApi(name = "commperiod.updatePeriodByPrimaryKey", desc = "更改公共期间信息", security = SecurityType.UserLogin)
	@DesignedErrorCode({ 
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
        CommonServiceHttpCode.C_PARAMETER_ERROR,
        CommonServiceHttpCode.C_SELECT_NOT_FOUND,
        CommonServiceHttpCode.C_UPDATE_FAILED
		})
	int updatePeriodByPrimaryKey(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.userId) int userId,
            @ApiParameter(required = false, name = "data", desc = "备注") String data
            
			);
	
	@HttpApi(name = "commperiod.selectDataByIds", desc = "根据期间ids查询期间信息", security = SecurityType.UserLogin)
	ArrayList<CommPeriodResp> selectDataByIds(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
           @ApiAutowired(CommonParameter.deviceId) long deviceId,
           @ApiAutowired(CommonParameter.applicationId) long applicationId,
   		   @ApiParameter(required = true, name = "selIds", desc = "主键id") String selIds
		 );
	@HttpApi(name = "commperiod.selectParamInfoById", desc = "根据参数期间id查询期间信息", security = SecurityType.UserLogin)
	CommPeriodResp selectParamInfoById(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
           @ApiAutowired(CommonParameter.deviceId) long deviceId,
           @ApiAutowired(CommonParameter.applicationId) long applicationId,
   			@ApiParameter(required = true, name = "id", desc = "主键id") String id
		 );
}
