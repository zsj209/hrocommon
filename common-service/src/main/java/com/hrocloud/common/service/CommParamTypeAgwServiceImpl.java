package com.hrocloud.common.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hrocloud.apigw.client.dubboext.DubboExtProperty;
import com.hrocloud.common.api.CommParamTypeService;
import com.hrocloud.common.api.CommParamTypeAgwService;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.dto.CommParamTypeDTO;
import com.hrocloud.common.dto.CommParamTypePageDTO;
import com.hrocloud.common.model.CommParamType;
import com.hrocloud.common.page.PageParameter;

@Service("commParamTypeAgwService")
public class CommParamTypeAgwServiceImpl implements
		CommParamTypeAgwService {
	private Logger logger = LoggerFactory.getLogger(CommParamTypeAgwServiceImpl.class);
	@Resource
	private CommParamTypeService commParamTypeService;
	public int deleteParamType(String clientIp, long deviceId,
			long applicationId, String ids) {
		return commParamTypeService.deleteParamType(ids);
	}

	public int insertParamType(String clientIp, long deviceId, int userId,
			String data) {
		if(StringUtils.isBlank(data)){
			 logger.error("parameter(s) cannot be null,  data was {}.",
					 data);
	            DubboExtProperty.setErrorCode(CommonServiceHttpCode.NECESSARY_COLUMN_ERROR);
	            return -1;
		}
		int i=0;
		try {
			i=commParamTypeService.insertParamType(userId,data);
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

	public CommParamTypePageDTO selectParamTypeByColumn(String clientIp, long deviceId,
			long applicationId, int id, int createBy,int updateBy, 
			int companyId, String typeCode,String typeName, String typeIsupdate,
			String comment,int rows,int page) {
		PageParameter pager=new PageParameter();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		CommParamType commParamType=new CommParamType();
		commParamType.setId(id);
		commParamType.setCreateBy(createBy);
		commParamType.setUpdateBy(updateBy);
		commParamType.setCompanyId(companyId);
		commParamType.setTypeCode(typeCode);
		commParamType.setTypeName(typeName);
		commParamType.setTypeIsupdate(typeIsupdate);
		commParamType.setComment(comment);
		 return commParamTypeService.selectParamTypeByColumn(pager,commParamType);
	}

	public int updateParamTypeByPrimaryKey(String clientIp, long deviceId,
			int userId,String data) {
		int i=0;
		try {
			i= commParamTypeService.updateParamTypeByPrimaryKey(userId,data);
		} catch (ErrorCodeException e) {
			DubboExtProperty.setErrorCode(e.getAgwErrorCode());
			return -2;
		}
		return i;
	}

	public CommParamTypeDTO selectParamTypeById(String clientIp,
			long deviceId, long applicationId, int id) {
		return commParamTypeService.selectParamTypeById(Integer.valueOf(id));
	}

	public List<String> getTableHead(String clientIp, long deviceId,
			long applicationId, int userId, int funId, int stype) {
		return commParamTypeService.getTableHead(userId, funId, stype);
	}

	public List<CommParamTypeDTO> selectDataByIds(String clientIp, long deviceId,
			long applicationId, String paramTypeids) {
		return commParamTypeService.selDataListByIds(paramTypeids);
	}


}
