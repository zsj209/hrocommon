package com.hrocloud.common.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hrocloud.apigw.client.dubboext.DubboExtProperty;
import com.hrocloud.common.api.CommPeriodService;
import com.hrocloud.common.api.CommPeriodAgwService;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.dto.CommPeriodRespDTO;
import com.hrocloud.common.model.CommCity;
import com.hrocloud.common.model.CommPeriod;
import com.hrocloud.common.model.CommPeriodResp;
import com.hrocloud.common.page.PageParameter;
/**
 * 
 *Created by zfy on 2016/12/8.
 * 公共期间对外接口的实现
 */
@Service("commPeriodAgwService")
public class CommPeriodAgwServiceImpl implements
		CommPeriodAgwService {
	private Logger logger = LoggerFactory.getLogger(CommPeriodAgwServiceImpl.class);
	@Resource
	private CommPeriodService commPeriodService;
	public int deletePeriod(String clientIp, long deviceId,
			long applicationId, String ids) {
		return commPeriodService.deletePeriod(ids);
	}

	public int insertPeriod(String clientIp, long deviceId, int userId,
			String data) {
		if(StringUtils.isBlank(data)){
			 logger.error("parameter(s) cannot be null, data was {}.",
					 data);
	            DubboExtProperty.setErrorCode(CommonServiceHttpCode.NECESSARY_COLUMN_ERROR);
	            return -1;
		}
		int i=0;
		try {
			i=commPeriodService.insertPeriod(userId,data);
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


	public CommPeriodRespDTO selectPeriodByColumn(String clientIp, long deviceId,
			long applicationId, int id, int createBy,
			 int updateBy,
			int companyId, String periodCode, String periodYear,
			String periodMonth, String startTime, String endTime,
			String comment,int rows,int page) {
		PageParameter pager=new PageParameter();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		CommPeriod commPeriod=new CommPeriod();
		commPeriod.setId(id);
		commPeriod.setCreateBy(createBy);
		commPeriod.setUpdateBy(updateBy);
		commPeriod.setCompanyId(companyId);
		commPeriod.setPeriodCode(periodCode);
		commPeriod.setPeriodYear(periodYear);
		commPeriod.setPeriodMonth(periodMonth);
		commPeriod.setStartTime(startTime);
		commPeriod.setEndTime(endTime);
		commPeriod.setComment(comment);
		return commPeriodService.selectPeriodByColumn(pager,commPeriod);
	}

	public int updatePeriodByPrimaryKey(String clientIp, long deviceId,
			int userId,String data) {
		int i=0;
		try {
			i=commPeriodService.updatePeriodByPrimaryKey(userId,data);
		} catch (ErrorCodeException e) {
			DubboExtProperty.setErrorCode(e.getAgwErrorCode());
			return -2;
		}
		return i;
	}



	public ArrayList<CommPeriodResp> selectDataByIds(String clientIp,
			long deviceId, long applicationId, String selIds) {
		return commPeriodService.selDataListByIds(selIds);
	}

	public CommPeriodResp selectParamInfoById(String clientIp, long deviceId,
			long applicationId, String id) {
		return commPeriodService.selectPeriodById(Integer.valueOf(id));
	}
	
}
