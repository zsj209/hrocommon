package com.hrocloud.common.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hrocloud.apigw.client.dubboext.DubboExtProperty;
import com.hrocloud.common.api.CommCityService;
import com.hrocloud.common.api.CommCityAgwService;
import com.hrocloud.common.api.CommParamInfoService;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.dto.CommCityRespDTO;
import com.hrocloud.common.model.CommCity;
import com.hrocloud.common.model.CommCityResp;
import com.hrocloud.common.page.PageParameter;
@Service("commCityAgwService")
public class CommCityAgwServiceImpl implements CommCityAgwService {
	private Logger logger = LoggerFactory.getLogger(CommCityAgwServiceImpl.class);
	@Resource
	private CommCityService commCityService;
	@Resource
	private CommParamInfoService commParamInfoService;
	/**
	 * 根据ID删除城市信息
	 */
	public int deleteCityByPrimaryKey(String clientIp, long deviceId,
			long applicationId, String ids) {
		int i=commCityService.deleteCityByPrimaryKey(ids);
		if(i==-3){
			  DubboExtProperty.setErrorCode(CommonServiceHttpCode.DELETEChlid_EXISTS);
			  return i;
		}
		return i;
	}

	public int insertCity(String clientIp, long deviceId, int userId,
			 String data) {
		if(StringUtils.isBlank(data)){
			 logger.error("parameter(s) cannot be null, data was {}.",
					 data);
	            DubboExtProperty.setErrorCode(CommonServiceHttpCode.NECESSARY_COLUMN_ERROR);
	            return -1;
		}
		int i=0;
		try {
			i=commCityService.insertCity(userId,data);
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

	

	public CommCityRespDTO selectCityListByColumn(String clientIp, long deviceId,
			long applicationId, int id, int createBy, int updateBy,
			int companyId,String cityCode, String cityName, String cityPid,
			String cityType, String comment,int rows,int page) {
		PageParameter pager=new PageParameter();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		CommCity commCity=new CommCity();
		commCity.setId(id);
		commCity.setCreateBy(createBy);
		commCity.setUpdateBy(updateBy);
		commCity.setCompanyId(companyId);
		commCity.setCityCode(cityCode);
		commCity.setCityName(cityName);
		commCity.setCityPid(cityPid);
		commCity.setCityType(cityType);
		commCity.setComment(comment);
		/*for (CommCityResp commCityResp : list) {
			if(!commCityResp.cityPid.endsWith("1")){
				CommCityResp city=commCityService.selectCityById(Integer.valueOf(commCityResp.cityPid));
				commCityResp.pidName=city.provCityName;
			}
			
			CommParamInfoResp commParamInfoResp =commParamInfoService.selectParamInfoById(Integer.valueOf(commCityResp.cityType));
			commCityResp.cityTypeName=commParamInfoResp.paramName;
		}*/
		//CommCityResp commCityResp=new CommCityResp();
		//commCityResp.list=list;
		return commCityService.selectCityListByColumn(pager,commCity);
	}

	public int updateByPrimaryKey(String clientIp, long deviceId,
			int userId, String data) {
		int i=0;
		try {
			i=commCityService.updateCityByPrimaryKey(userId,data);
		} catch (Exception e) {
			DubboExtProperty.setErrorCode(CommonServiceHttpCode.UPDATE_FAILED);
			return -2;
		}
		return i;
	}


	/**
	 * 根据id递归城市信息
	 */
	public List<CommCityResp> queryTreeCityList(String clientIp, long deviceId,
			long applicationId, int cityPid) {
		//if(cityPid==""||cityPid.equals("null")){
			cityPid=0;
		//}
	
		return commCityService.queryTreeCityList(cityPid);
	}

	

	public CommCityResp selectCityById(String clientIp, long deviceId,
			long applicationId, int id) {
		return commCityService.selectCityById(id);
	}

	public ArrayList<CommCityResp> selectDataListByIds(String clientIp,
			long deviceId, long applicationId, String selIds) {
		return commCityService.selDataListByIds(selIds);
	}

	public CommCityRespDTO selectAllCityListByColumn(String clientIp,
			long deviceId, long applicationId, int id, String cityCode,String cityName, String cityPid,
			String cityType,int types,int rows,int page) {
		PageParameter pager=new PageParameter();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		return commCityService.selectAllCityListByColumn(pager, id, cityCode, cityName, cityPid, cityType, types);
	}


/*	public List<CommCityResp> queryChlidrenByCode(String cityCode) {
		// TODO Auto-generated method stub
		return commCityService.queryChlidrenByCode(cityCode);
	}*/


}
