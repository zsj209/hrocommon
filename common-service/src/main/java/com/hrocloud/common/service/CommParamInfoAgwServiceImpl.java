package com.hrocloud.common.service;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.hrocloud.common.dto.*;
import com.hrocloud.common.utils.Utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hrocloud.apigw.client.dubboext.DubboExtProperty;
import com.hrocloud.common.api.CommParamInfoService;
import com.hrocloud.common.api.CommParamInfoAgwService;
import com.hrocloud.common.api.CommParamTypeService;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.api.model.ParamValue;
import com.hrocloud.common.model.CommParamInfo;
import com.hrocloud.common.model.PubForIdselobj;
import com.hrocloud.common.page.PageParameter;
import com.hrocloud.util.CommonUtil;
@Service("commParamInfoAgwService")
public class CommParamInfoAgwServiceImpl implements
		CommParamInfoAgwService {
	private Logger logger = LoggerFactory.getLogger(CommParamInfoAgwServiceImpl.class);
	@Resource
	private CommParamInfoService commParamInfoService;
	@Resource
	private CommParamTypeService commParamTypeService;
	public int deleteParamInfo(String clientIp, long deviceId,
			long applicationId, String ids) {
		return commParamInfoService.deleteParamInfo(ids);
	}

	public int insertParamInfo(String clientIp, long deviceId, int userId,
			String data) {
		if(StringUtils.isBlank(data)){
			 logger.error("parameter(s) cannot be null,data was {}.",
					 data);
	            DubboExtProperty.setErrorCode(CommonServiceHttpCode.NECESSARY_COLUMN_ERROR);
	            return -1;
		}
		int i=0;
		try {
			i=commParamInfoService.insertParamInfo(userId,data);
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

	
	public List<CommParamInfoDTO> selectParamInfoByColumn(String clientIp,
			long deviceId, long applicationId, int id, int createBy, int updateBy,
			int companyId, String paramCode,String paramType, String paramName,String comment) {
		CommParamInfo commParamInfo=new CommParamInfo();
		commParamInfo.setId(id);
		commParamInfo.setUpdateBy(updateBy);
		commParamInfo.setCompanyId(companyId);
		commParamInfo.setParamCode(paramCode);
		commParamInfo.setParamType(paramType);
		commParamInfo.setParamName(paramName);
		commParamInfo.setComment(comment);
		List<CommParamInfoDTO> list=commParamInfoService.selectParamInfoByColumn(commParamInfo);
		return list;
	}

	public int updateParamInfoByPrimaryKey(String clientIp, long deviceId,
			int userId, String data) {
		int i=0;
		try {
			i=commParamInfoService.updateParamInfoByPrimaryKey(userId,data);
		} catch (ErrorCodeException e) {
			DubboExtProperty.setErrorCode(e.getAgwErrorCode());
			return -2;
		}
		return i;
	}



	public CommParamInfoDTO selectParamInfoById(String clientIp,
			long deviceId, long applicationId, int id) {
		return commParamInfoService.selectParamInfoById(id);
	}

	public List<CommParamInfoDTO> selDataListByCodes(String clientIp, long deviceId,
			long applicationId,int type,String paramids) {
		return commParamInfoService.selDataListByCodes(type, paramids);
	}
	public List<String> getTableSelectvl(String clientIp, long deviceId,
			long applicationId, int userId, String selids) {
		//CommonUtil.getValueList(commParamInfoService, "taxtype", null, "", true);

		return commParamInfoService.getTableSelectvl(userId, selids);
	}

	public List<ParamValueDTO> getSelect(String clientIp, long deviceId,
			long applicationId, String typeCode,String paramCode) {
		 List<ParamValueDTO> listDto=new ArrayList<ParamValueDTO>();
		List<ParamValue> list=CommonUtil.getValueList(commParamInfoService, typeCode, null, "", true);
		for (ParamValue paramValue : list) {
			ParamValueDTO paramValueDTO=new ParamValueDTO(paramValue);
			listDto.add(paramValueDTO);
		}
		
		return listDto;//commParamInfoService.getTableSelectvl(selid, userid, seltype);
	}

	public String getForIdselName(String clientIp, long deviceId,
			long applicationId, int selId, int userId, int selVal) {
		return commParamInfoService.getForIdselName(selId, userId, selVal);
	}

	public PubForIdselobjRespDTO getForIdselData(String clientIp,
			long deviceId, long applicationId, int id, String strVla,
			String strVlb, String strVlc, String strVld, String strVle,
			String strVlf, String strVlg, String strVlh, String strVli,
			String strVlj,int rows,int page) {
		PageParameter pagePar=new PageParameter();
		pagePar.setCurrentPage(page);
		pagePar.setPageSize(rows);
		PubForIdselobj pubForIdselobj=new PubForIdselobj();
		pubForIdselobj.id=id;
		pubForIdselobj.strVla=strVla;
		pubForIdselobj.strVlb=strVlb;
		pubForIdselobj.strVlc=strVlc;
		PubForIdselobjRespDTO pubDto=commParamInfoService.getForIdselData(pagePar,pubForIdselobj);
		return pubDto;
	}

	public CommParamInfoPageDTO selectParamInfo(String clientIp,
			long deviceId, long applicationId, int id, int createBy,int updateBy,
			int companyId,String paramCode, String paramType, String paramName,
			String comment, String types,int rows,int page) {
		PageParameter pagePar=new PageParameter();
		pagePar.setCurrentPage(page);
		pagePar.setPageSize(rows);
		CommParamInfo commParamInfo=new CommParamInfo();
		commParamInfo.setId(id);
		commParamInfo.setUpdateBy(updateBy);
		commParamInfo.setCompanyId(companyId);
		commParamInfo.setParamCode(paramCode);
		commParamInfo.setParamType(paramType);
		commParamInfo.setParamName(paramName);
		commParamInfo.setComment(comment);
		return commParamInfoService.selectParamInfo(pagePar,commParamInfo,types);
	}

	public List<ParamValueDTO> getParamList(String paramTypeCode) {


		List<ParamValueDTO> list = Utils.buildAgwParamList(paramTypeCode, null, commParamInfoService, "", true);

		return list;
	}

	public List<ParamGroupDTO> getParamList(List<String> paramTypeList) {
		List<ParamGroupDTO> result = new ArrayList<ParamGroupDTO>();
		for (String paramTypeCode : paramTypeList) {
			List<ParamValueDTO> list = Utils.buildAgwParamList(paramTypeCode, null, commParamInfoService, "", true);
			ParamGroupDTO paramGroup = new ParamGroupDTO();
			paramGroup.typeCode = paramTypeCode;
			paramGroup.paramList = list;
			result.add(paramGroup);
		}
		return result;
	}
}
