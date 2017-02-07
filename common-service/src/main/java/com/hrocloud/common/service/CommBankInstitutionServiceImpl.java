package com.hrocloud.common.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Service;

import com.hrocloud.apigw.client.dubboext.DubboExtProperty;
import com.hrocloud.common.api.CommBankInstitutionService;
import com.hrocloud.common.dao.CommBankInstitutionMapper;
import com.hrocloud.common.dto.CommBankInstitutionDTO;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.model.CommBankInstitution;
import com.hrocloud.common.model.CommBankInstitutionResp;
import com.hrocloud.common.model.CommParamType;
import com.hrocloud.common.page.PageParameter;
@Service("commBankInstitutionService")
public class CommBankInstitutionServiceImpl implements CommBankInstitutionService{
	@Resource
	private CommBankInstitutionMapper commBankInstitutionMapper;
	public int deleteBatchByIds(String ids) {
		
		return commBankInstitutionMapper.deleteBatchByIds(ids);
	}

	public int insertBank(int userId,String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
		CommBankInstitution bankInstitution = null;
		try {
			bankInstitution= objectMapper.readValue(data, CommBankInstitution.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		if(bankInstitution!=null){
				try {
					bankInstitution.setCreateBy(userId);
					if(commBankInstitutionMapper.selectBankIsExist(bankInstitution)<=0){
						commBankInstitutionMapper.insertBank(bankInstitution);
						
					}else{
				          return -3;
					}
				} catch (Exception e) {
					 throw new ErrorCodeException(CommonServiceHttpCode.INSERT_FAILED);
				}
				
			}
		return 1;
	}


	public List<CommBankInstitutionResp> selectBanksByIds(String ids) {
		
		return commBankInstitutionMapper.selectBanksByIds(ids);
	}

	public CommBankInstitutionResp selectByBankId(Integer id) {
		
		return commBankInstitutionMapper.selectByBankId(id);
	}

	public int updateByBankId(CommBankInstitution bankInstitution) {
		
		return commBankInstitutionMapper.updateByBankId(bankInstitution);
	}

	public CommBankInstitutionDTO selectBanks(PageParameter pager,	CommBankInstitution bankInstitution) {
		List<CommBankInstitutionResp> list=commBankInstitutionMapper.selectBanksPage(pager, bankInstitution);
		CommBankInstitutionDTO comm=new CommBankInstitutionDTO();
		comm.rows=list;
		comm.page = pager.getCurrentPage();
		comm.total=pager.getTotalPage();
		comm.records=pager.getTotalCount();
		return comm;
	}

	public int updateByBankId(int userId,String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
		CommBankInstitution bankInstitution = null;
		try {
			bankInstitution= objectMapper.readValue(data, CommBankInstitution.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(bankInstitution!=null){
			//判断id是否存在，若存在，则更改，否则添加
				try {
					bankInstitution.setUpdateBy(userId);
					int i=commBankInstitutionMapper.updateByBankId(bankInstitution);
				} catch (Exception e) {
					 throw new ErrorCodeException(CommonServiceHttpCode.UPDATE_FAILED);
				}
		}
		return 1;
	}

}
