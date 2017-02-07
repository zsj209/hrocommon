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
import com.hrocloud.common.dto.CommParamTypeDTO;
import com.hrocloud.common.dto.CommParamTypePageDTO;


/**
 * 
 * Created by zfy on 2016/12/2.
 * 公共参数类型对外接口
 */
@ApiGroup(name = "commparmtype", minCode = 3000, maxCode = 4000, codeDefine = CommonServiceHttpCode.class, owner = "zfy")
public interface CommParamTypeAgwService {
	/**
	 * 更加类型id删除类型信息
	 * @param clientIp
	 * @param deviceId
	 * @param applicationId
	 * @param delIds
	 * @return
	 */
	@HttpApi(name = "commparmtype.delete", desc = "刪除公共参数类型信息", security = SecurityType.UserLogin)
	@DesignedErrorCode({ CommonServiceHttpCode.C_DELETE_FAILED,
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
		CommonServiceHttpCode.C_PARAMETER_ERROR
		})
	int deleteParamType(
		@ApiAutowired(CommonParameter.clientIp) String clientIp,
        @ApiAutowired(CommonParameter.deviceId) long deviceId,
        @ApiAutowired(CommonParameter.applicationId) long applicationId,
		@ApiParameter(required = true, name = "idList", desc = "公共参数类型id")String idList
	);
	/***
	 * 添加公共参数类型信息
	 * @param clientIp
	 * @param deviceId
	 * @param applicationId
	 * @param createBy
	 * @param createTime
	 * @param updateBy
	 * @param updateTime
	 * @param companyId
	 * @param typeName
	 * @param typeIsupdate
	 * @param comment
	 * @return
	 */
	@HttpApi(name = "commparmtype.insertParamType", desc = "添加公共参数类型信息", security = SecurityType.UserLogin)//Staffinfo record
	@DesignedErrorCode({
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
		CommonServiceHttpCode.C_INSERT_EXISTS,
		CommonServiceHttpCode.C_INSERT_FAILED,
		CommonServiceHttpCode.C_PARAMETER_ERROR,
		CommonServiceHttpCode.C_SELECT_NOT_FOUND
		})
	int insertParamType(
		@ApiAutowired(CommonParameter.clientIp) String clientIp,
        @ApiAutowired(CommonParameter.deviceId) long deviceId,
        @ApiAutowired(CommonParameter.userId) int userId,
        @ApiParameter(required = true, name = "data", desc = "json字符串") String data
    );
	
	/**
	 * 查询公共参数类型信息
	 * @param clientIp
	 * @param deviceId
	 * @param applicationId
	 * @param id
	 * @param createBy
	 * @param createTime
	 * @param updateBy
	 * @param updateTime
	 * @param companyId
	 * @param typeName
	 * @param typeIsupdate
	 * @param comment
	 * @param rows
	 * @param page
	 * @return
	 */
	@HttpApi(name = "commparmtype.selectParamTypeByColumn", desc = "查询公共参数类型信息", security = SecurityType.UserLogin)
	CommParamTypePageDTO selectParamTypeByColumn(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
			@ApiParameter(required = false, name = "id", desc = "公共参数类型id") int id,
			@ApiParameter(required = false, name = "createBy", desc = "创建人") int createBy,
			@ApiParameter(required = false, name = "updateBy", desc = "更改人") int updateBy,
			@ApiParameter(required = false, name = "companyId", desc = "所属公司") int companyId,
			@ApiParameter(required = false, name = "typeCode", desc = "编码") String typeCode,
			@ApiParameter(required = false, name = "typeName", desc = "参数类型名称") String typeName,
			@ApiParameter(required = false, name = "typeIsupdate", desc = "不可修改标志(本类型下公共参数信息不可修改)") String typeIsupdate,
			@ApiParameter(required = false, name = "comment", desc = "备注") String comment,
			@ApiParameter(required = true, name = "rows", desc = "每页显示条数") int rows,
	        @ApiParameter(required = true, name = "page", desc = "当前页") int page
			);
	/**
	 * 更改公共参数类型信息
	 * @param clientIp
	 * @param deviceId
	 * @param applicationId
	 * @param id
	 * @param createBy
	 * @param createTime
	 * @param updateBy
	 * @param updateTime
	 * @param companyId
	 * @param typeName
	 * @param typeIsupdate
	 * @param comment
	 * @return
	 */
	@HttpApi(name = "commparmtype.updateParamTypeByPrimaryKey", desc = "更改公共参数类型信息", security = SecurityType.UserLogin)
	@DesignedErrorCode({ 
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
		CommonServiceHttpCode.C_PARAMETER_ERROR,
		CommonServiceHttpCode.C_SELECT_NOT_FOUND,
		CommonServiceHttpCode.C_UPDATE_FAILED
		})
	int updateParamTypeByPrimaryKey(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.userId) int userId,
            @ApiParameter(required = true, name = "data", desc = "json字符串") String data
			);
	
	/**
	 * 根据参数类型id查询参数信息
	 * @param clientIp
	 * @param deviceId
	 * @param applicationId
	 * @param id
	 * @return
	 */
	@HttpApi(name = "commparmtype.selectParamTypeById", desc = "根据参数类型id查询参数信息", security = SecurityType.UserLogin)
	CommParamTypeDTO selectParamTypeById(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
            @ApiParameter(required = true, name = "id", desc = "公共参数类型id") int id
			);
	/**
	 * 获取jqGrid表头
	 * @param clientIp
	 * @param deviceId
	 * @param applicationId
	 * @param userId
	 * @param funId
	 * @param stype
	 * @return
	 */
	 @HttpApi(name = "commparmtype.getTableHead", desc = "获取jqGrid表头", security = SecurityType.UserLogin)
	    List<String> getTableHead(
	            @ApiAutowired(CommonParameter.clientIp) String clientIp,
	            @ApiAutowired(CommonParameter.deviceId) long deviceId,
	            @ApiAutowired(CommonParameter.applicationId) long applicationId,
	            @ApiParameter(required = false, name = "userid", desc = "用户id") int userId,
	            @ApiParameter(required = false, name = "funid", desc = "节点id") int funId,
	            @ApiParameter(required = false, name = "stype", desc = "类型") int stype);
	 /**
	  * 根据参数类型ids查询参数信息
	  * @param clientIp
	  * @param deviceId
	  * @param applicationId
	  * @param selIds
	  * @return
	  */
	 @HttpApi(name = "commparmtype.selectDataByIds", desc = "根据参数类型ids查询参数信息", security = SecurityType.UserLogin)
	 List<CommParamTypeDTO> selectDataByIds(
			 	@ApiAutowired(CommonParameter.clientIp) String clientIp,
	           @ApiAutowired(CommonParameter.deviceId) long deviceId,
	           @ApiAutowired(CommonParameter.applicationId) long applicationId,
	   			@ApiParameter(required = true, name = "selIds", desc = "主键id") String selIds
			 );
}
