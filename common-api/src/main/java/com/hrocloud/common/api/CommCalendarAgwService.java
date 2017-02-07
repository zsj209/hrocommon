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
import com.hrocloud.common.dto.CommCalendarRespDTO;
import com.hrocloud.common.model.CommCalendarResp;


/**
 * 
 * Created by zfy on 2016/12/8.
 * 公共日历对外接口
 */
@ApiGroup(name = "commcalendar", minCode = 3000, maxCode = 4000, codeDefine = CommonServiceHttpCode.class, owner = "zfy")
public interface CommCalendarAgwService {
	@HttpApi(name = "commcalendar.deleteCalendar", desc = "刪除日历信息", security = SecurityType.UserLogin)
	@DesignedErrorCode({ CommonServiceHttpCode.C_DELETE_FAILED,
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
        CommonServiceHttpCode.C_PARAMETER_ERROR
		})
	int deleteCalendar(
		@ApiAutowired(CommonParameter.clientIp) String clientIp,
        @ApiAutowired(CommonParameter.deviceId) long deviceId,
        @ApiAutowired(CommonParameter.applicationId) long applicationId,
		@ApiParameter(required = true, name = "delIds", desc = "日历id")String delIds
	);
	
	@HttpApi(name = "commcalendar.insertCalendar", desc = "添加公共日历信息", security = SecurityType.UserLogin)//Staffinfo record
	@DesignedErrorCode({
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
        CommonServiceHttpCode.C_INSERT_EXISTS,
        CommonServiceHttpCode.C_INSERT_FAILED,
        CommonServiceHttpCode.C_PARAMETER_ERROR
		})
	int insertCalendar(
		@ApiAutowired(CommonParameter.clientIp) String clientIp,
        @ApiAutowired(CommonParameter.deviceId) long deviceId,
        @ApiAutowired(CommonParameter.userId) int userId,
		@ApiParameter(required = false, name = "data", desc = "json参数") String data
		
    );
	
	@HttpApi(name = "commcalendar.selectCalendarByColumn", desc = "查询公共日历信息", security = SecurityType.UserLogin)
	CommCalendarRespDTO selectCalendarByColumn(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
			@ApiParameter(required = false, name = "id", desc = "公共日历id") int id,
			@ApiParameter(required = false, name = "createBy", desc = "创建人") int createBy,
			@ApiParameter(required = false, name = "updateBy", desc = "更改人") int updateBy,
			@ApiParameter(required = false, name = "companyId", desc = "所属公司") int companyId,
			@ApiParameter(required = false, name = "calCode", desc = "期间编码") String calCode,
			@ApiParameter(required = false, name = "calDate", desc = "日期") String calDate,
			@ApiParameter(required = false, name = "calType", desc = "类型(上班、休息、节假日)") String calType,
			@ApiParameter(required = true, name = "rows", desc = "每页显示条数") int rows,
	        @ApiParameter(required = true, name = "page", desc = "当前页") int page
			);
	@HttpApi(name = "commcalendar.updateCalendarByPrimaryKey", desc = "更改公共日历信息", security = SecurityType.UserLogin)
	@DesignedErrorCode({
        CommonServiceHttpCode.C_PARAMETER_ERROR,
        CommonServiceHttpCode.C_SELECT_NOT_FOUND,
        CommonServiceHttpCode.C_UPDATE_FAILED
		})
	int updateCalendarByPrimaryKey(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.userId) int userId,
            @ApiParameter(required = false, name = "data", desc = "json参数") String data
			);
	
	
	    @HttpApi(name = "commcalendar.selDataListByIds", desc = "获取select选项", security = SecurityType.UserLogin)
	    ArrayList<CommCalendarResp> selDataListByIds(
	            @ApiAutowired(CommonParameter.clientIp) String clientIp,
	            @ApiAutowired(CommonParameter.deviceId) long deviceId,
	            @ApiAutowired(CommonParameter.applicationId) long applicationId,
	            @ApiParameter(required = false, name = "selIds", desc = "节点id") String selIds);
	    
	    @HttpApi(name = "commcalendar.selectCalendarById", desc = "根据id获取日历信息", security = SecurityType.UserLogin)
	    CommCalendarResp selectCalendarById(
	            @ApiAutowired(CommonParameter.clientIp) String clientIp,
	            @ApiAutowired(CommonParameter.deviceId) long deviceId,
	            @ApiAutowired(CommonParameter.applicationId) long applicationId,
	            @ApiParameter(required = false, name = "id", desc = "节点id") String id);
	    
	    
}
