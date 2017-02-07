package com.hrocloud.common.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hrocloud.apigw.client.dubboext.DubboExtProperty;
import com.hrocloud.common.api.CommBankInstitutionAgwService;
import com.hrocloud.common.api.CommBankInstitutionService;
import com.hrocloud.common.dto.CommBankInstitutionDTO;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.model.CommBankInstitution;
import com.hrocloud.common.model.CommBankInstitutionResp;
import com.hrocloud.common.page.PageParameter;
@Service("commBankInstitutionAgwService")
public class CommBankInstitutionAgwServiceImpl implements CommBankInstitutionAgwService {
	private Logger logger = LoggerFactory.getLogger(CommBankInstitutionAgwServiceImpl.class);

	@Resource
	private CommBankInstitutionService commBankInstitutionService;
	public int deleteBatchByIds(String clientIp, long deviceId,
			long applicationId, String idList) {
		
		return commBankInstitutionService.deleteBatchByIds(idList);
	}

	public int insertBank(String clientIp, long deviceId, int userId,
			String data) {
		if(StringUtils.isBlank(data)){
			 logger.error("parameter(s) cannot be null,  data was {}.",
					 data);
	            DubboExtProperty.setErrorCode(CommonServiceHttpCode.NECESSARY_COLUMN_ERROR);
	            return -1;
		}
		int i=0;
		try {
			i=commBankInstitutionService.insertBank(userId,data);
			if(i==-3){
				DubboExtProperty.setErrorCode(CommonServiceHttpCode.INSERT_EXIST);
				return i;
			}
		} catch (ErrorCodeException e) {
			DubboExtProperty.setErrorCode(e.getAgwErrorCode());
			return -2;
		}
		return i;
	}


	public CommBankInstitutionResp selectByBankId(String clientIp, long deviceId,
			long applicationId, int id) {
		
		return commBankInstitutionService.selectByBankId(id);
	}

	public List<CommBankInstitutionResp> selectBanksByIds(String clientIp,
			long deviceId, long applicationId, String selIds) {
		
		return commBankInstitutionService.selectBanksByIds(selIds);
	}

	public CommBankInstitutionDTO selectBanks(String clientIp, long deviceId,
			long applicationId, int id, int createBy, int updateBy,
			int companyId, String bankName, String bankCname,int deleteFlag,
			String comment,int rows, int page) {
		CommBankInstitution bankInstitution=new CommBankInstitution();
		bankInstitution.setId(id);
		bankInstitution.setCreateBy(createBy);
		bankInstitution.setCompanyId(companyId);
		bankInstitution.setBankName(bankName);
		bankInstitution.setBankCname(bankCname);
		bankInstitution.setDeleteFlag((byte)deleteFlag);
		bankInstitution.setComment(comment);
		PageParameter pagePar=new PageParameter();
		pagePar.setPageSize(rows);
		pagePar.setCurrentPage(page);
		
		return commBankInstitutionService.selectBanks(pagePar, bankInstitution);
	}

	public int updateBank(String clientIp, long deviceId, int userId,
			String data) {
		int i=0;
		try {
			i=commBankInstitutionService.updateByBankId(userId,data);
		} catch (ErrorCodeException e) {
			DubboExtProperty.setErrorCode(e.getAgwErrorCode());
			return -2;
		}
		return i;
	}

}
