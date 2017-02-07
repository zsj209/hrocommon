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
import com.hrocloud.common.dto.CommBankInstitutionDTO;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.model.CommBankInstitutionResp;


/**
 * 
 * Created by zfy on 2016/12/2.
 * 银行机构对外接口
 */
@ApiGroup(name = "bankInstitution", minCode = 3000, maxCode = 4000, codeDefine = CommonServiceHttpCode.class, owner = "zfy")
public interface CommBankInstitutionAgwService {
	/**
	 * 根据银行机构id删除银行信息
	 * @param clientIp
	 * @param deviceId
	 * @param applicationId
	 * @param delIds
	 * @return
	 */
	@HttpApi(name = "bankInstitution.deleteBatchByIds", desc = "刪除银行机构信息", security = SecurityType.UserLogin)
	@DesignedErrorCode({ CommonServiceHttpCode.C_DELETE_FAILED,
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
		CommonServiceHttpCode.C_PARAMETER_ERROR,
		CommonServiceHttpCode.C_SELECT_NOT_FOUND
		})
	int deleteBatchByIds(
		@ApiAutowired(CommonParameter.clientIp) String clientIp,
        @ApiAutowired(CommonParameter.deviceId) long deviceId,
        @ApiAutowired(CommonParameter.applicationId) long applicationId,
		@ApiParameter(required = true, name = "idList", desc = "银行机构ids")String idList
	);
/**
 * 添加银行机构
 * @param clientIp
 * @param deviceId
 * @param applicationId
 * @param data
 * @return
 */
	@HttpApi(name = "bankInstitution.updateBank", desc = "添加银行机构信息", security = SecurityType.UserLogin)//Staffinfo record
	@DesignedErrorCode({ CommonServiceHttpCode.C_UPDATE_FAILED,
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
		CommonServiceHttpCode.C_PARAMETER_ERROR,
		CommonServiceHttpCode.C_SELECT_NOT_FOUND
		})
	int updateBank(
		@ApiAutowired(CommonParameter.clientIp) String clientIp,
        @ApiAutowired(CommonParameter.deviceId) long deviceId,
        @ApiAutowired(CommonParameter.userId) int userId,
        @ApiParameter(required = true, name = "data", desc = "json字符串") String data
    );
	@HttpApi(name = "bankInstitution.insertBank", desc = "修改银行机构信息", security = SecurityType.UserLogin)//Staffinfo record
	@DesignedErrorCode({ 
		CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
		CommonServiceHttpCode.C_INSERT_EXISTS,
		CommonServiceHttpCode.C_INSERT_FAILED,
		CommonServiceHttpCode.C_PARAMETER_ERROR,
		CommonServiceHttpCode.C_SELECT_NOT_FOUND
		})
	int insertBank(
		@ApiAutowired(CommonParameter.clientIp) String clientIp,
        @ApiAutowired(CommonParameter.deviceId) long deviceId,
        @ApiAutowired(CommonParameter.userId) int userId,
        @ApiParameter(required = true, name = "data", desc = "json字符串") String data
    );
	/**
	 * 查询银行机构信息
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
	@HttpApi(name = "bankInstitution.selectBanks", desc = "查询银行机构信息", security = SecurityType.UserLogin)
	CommBankInstitutionDTO selectBanks(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
			@ApiParameter(required = false, name = "id", desc = "银行机构id") int id,
			@ApiParameter(required = false, name = "createBy", desc = "创建人") int createBy,
			@ApiParameter(required = false, name = "updateBy", desc = "更改人") int updateBy,
			@ApiParameter(required = false, name = "companyId", desc = "所属公司") int companyId,
			@ApiParameter(required = false, name = "bankName", desc = "银行名称") String bankName,
			@ApiParameter(required = false, name = "bankCname", desc = "银行简称") String bankCname,
			@ApiParameter(required = false, name = "deleteFlag", desc = "删除标记") int deleteFlag,
			@ApiParameter(required = false, name = "comment", desc = "备注") String comment,
			@ApiParameter(required = true, name = "rows", desc = "每页显示条数") int rows,
	        @ApiParameter(required = true, name = "page", desc = "当前页") int page
			);
	
	/**
	 * 根据机构id查询银行机构信息
	 * @param clientIp
	 * @param deviceId
	 * @param applicationId
	 * @param id
	 * @return
	 */
	@HttpApi(name = "bankInstitution.selectByBankId", desc = "根据银行机构id查询银行信息", security = SecurityType.UserLogin)
	CommBankInstitutionResp selectByBankId(
			@ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
            @ApiParameter(required = true, name = "id", desc = "银行机构id") int id
			);
	 /**
	  * 根据银行机构ids查询机构信息
	  * @param clientIp
	  * @param deviceId
	  * @param applicationId
	  * @param selIds
	  * @return
	  */
	 @HttpApi(name = "bankInstitution.selectBanksByIds", desc = "根据银行机构ids查询机构信息", security = SecurityType.UserLogin)
	 List<CommBankInstitutionResp> selectBanksByIds(
			 @ApiAutowired(CommonParameter.clientIp) String clientIp,
	         @ApiAutowired(CommonParameter.deviceId) long deviceId,
	         @ApiAutowired(CommonParameter.applicationId) long applicationId,
	   		 @ApiParameter(required = true, name = "selIds", desc = "主键id") String selIds
			 );
}
