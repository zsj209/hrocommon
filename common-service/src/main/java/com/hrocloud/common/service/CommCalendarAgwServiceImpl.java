package com.hrocloud.common.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hrocloud.apigw.client.dubboext.DubboExtProperty;
import com.hrocloud.common.api.CommCalendarService;
import com.hrocloud.common.api.CommCalendarAgwService;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.dto.CommCalendarRespDTO;
import com.hrocloud.common.model.CommCalendar;
import com.hrocloud.common.model.CommCalendarResp;
import com.hrocloud.common.model.CommPeriod;
import com.hrocloud.common.page.PageParameter;
/**
 * 
 * Create by zfy on 2016/10/8
 * 公共日历对外接口的实现
 */
@Service("commCalendarAgwService")
public class CommCalendarAgwServiceImpl implements
		CommCalendarAgwService {
	private Logger logger = LoggerFactory.getLogger(CommCalendarAgwServiceImpl.class);
	@Resource
	private CommCalendarService commCalendarService;
	/**
	 * 删除
	 */
	public int deleteCalendar(String clientIp, long deviceId,
			long applicationId, String ids) {
		return commCalendarService.deleteCalendar(ids);
	}

	/**
	 * 添加日历
	 */
	public int insertCalendar(String clientIp, long deviceId, int userId,
			String data) {
		if(StringUtils.isBlank(data)){
			 logger.error("parameter(s) cannot be null, data was {}.",
					 data);
	            DubboExtProperty.setErrorCode(CommonServiceHttpCode.NECESSARY_COLUMN_ERROR);
	            return -1;
		}
		int i=0;
		try {
			i=commCalendarService.insertCalendar(userId,data);
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

	/**
	 * 根据日历查询日历信息
	 */
	public CommCalendarRespDTO selectCalendarByColumn(String clientIp,
			long deviceId, long applicationId, int id, int createBy,int updateBy, 
			int companyId, String calCode, String calDate, String calType,
			 int rows,int page) {
		PageParameter pager=new PageParameter();
		pager.setPageSize(rows);
		pager.setCurrentPage(page);
		CommCalendar commCalendar=new CommCalendar();
		commCalendar.setId(id);
		commCalendar.setCreateBy(createBy);
		commCalendar.setUpdateBy(updateBy);
		commCalendar.setCompanyId(companyId);
		commCalendar.setCalCode(calCode);
		commCalendar.setCalDate(calDate);
		commCalendar.setCalType(calType);
		return commCalendarService.selectCalendarByColumn(pager,commCalendar);
	}

	/**
	 * 更新日历信息
	 */
	public int updateCalendarByPrimaryKey(String clientIp, long deviceId,
			 int userId, String data) {
		int i=0;
		try {
			i=commCalendarService.updateCalendarByPrimaryKey(userId,data);
		} catch (Exception e) {
			DubboExtProperty.setErrorCode(CommonServiceHttpCode.UPDATE_FAILED);
			return -2;
		}
		return i;
	}


	public ArrayList<CommCalendarResp> selDataListByIds(String clientIp, long deviceId,
			long applicationId, String cityids) {
		return commCalendarService.selDataListByIds(cityids);
	}

	public CommCalendarResp selectCalendarById(String clientIp, long deviceId,
			long applicationId, String id) {
		return commCalendarService.selectCalendarById(Integer.valueOf(id));
	}



}
