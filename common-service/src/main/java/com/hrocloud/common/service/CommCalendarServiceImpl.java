package com.hrocloud.common.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Service;

import com.hrocloud.apigw.client.dubboext.DubboExtProperty;
import com.hrocloud.common.api.CommCalendarService;
import com.hrocloud.common.api.CommParamInfoService;
import com.hrocloud.common.api.model.ParamValue;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.dao.CommCalendarMapper;
import com.hrocloud.common.dao.CommPeriodMapper;
import com.hrocloud.common.dto.CommCalendarRespDTO;
import com.hrocloud.common.model.CommCalendar;
import com.hrocloud.common.model.CommCalendarResp;
import com.hrocloud.common.model.CommPeriodResp;
import com.hrocloud.common.page.PageParameter;
import com.hrocloud.company.api.CompanyAgwService;
import com.hrocloud.company.api.CompanyService;
import com.hrocloud.company.dto.CompanyDto;
import com.hrocloud.company.model.Company;
import com.hrocloud.util.CommonUtil;
/**
 * 
 * Created by zfy on 2016/12/8.
 * 日历接口的实现
 */
@Service("commCalendarService")
public class CommCalendarServiceImpl implements CommCalendarService {
	@Resource
	private CommCalendarMapper commCalendarMapper;
	@Resource
	private CommPeriodMapper commPeriodMapper;
	@Resource
	private CommParamInfoService commParamInfoService;
	@Resource 	
	private CompanyService companyService;
	/**
	 * 删除
	 */
	public int deleteCalendar(String ids) {
		return commCalendarMapper.deleteCalendar(ids);
	}
	/**
	 * 添加
	 */
	public int insertCalendar(int userId,String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
		CommCalendar commCalendar = null;
		try {
			commCalendar = objectMapper.readValue(data, CommCalendar.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i=0;
		try {
			commCalendar.setCreateBy(userId);
			if(commCalendarMapper.queryByCalendarInfoIsExist(commCalendar)>0){
		         return -3;
			}
			i=commCalendarMapper.insertCalendar(commCalendar);
		} catch (Exception e) {
         throw new ErrorCodeException(CommonServiceHttpCode.INSERT_FAILED);
		}
		return i;
	}

	/**
	 * 查询
	 */
	public CommCalendarRespDTO selectCalendarByColumn(PageParameter pager,CommCalendar commCalendar) {
		List<CommCalendarResp> list=commCalendarMapper.selectCalendarByColumnPage(pager,commCalendar);
		if(list.size()>0){
			
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
			 String periods="";
			 //处理日期类型
			for (CommCalendarResp commCalendarResp : list) {
				periods=periods+commCalendarResp.calCode+",";
				List<ParamValue> codelist=CommonUtil.getValueList(commParamInfoService, "datetype", null, commCalendarResp.calType, true);
				if(codelist.size()>0){
					for (ParamValue paramValue : codelist) {
						if(paramValue.getCode().equals(commCalendarResp.calType)){
							commCalendarResp.calType=paramValue.getDesc();
							break;
						}
						
					}
				}
				//所属公司
			if(commCalendarResp.companyId!=100 && commCalendarResp.companyId!=0){
					Company selectById = null;
					try {
						selectById = companyService.selectById(commCalendarResp.companyId);
					} catch (Exception e) {
						// TODO: handle exception
					}
					if (selectById != null) {
						commCalendarResp.companyIdDis = selectById.getCompName();
					}
				}
				
				//日期格式的处理
				try {
					commCalendarResp.calDate=formatter2.format(formatter.parse(commCalendarResp.calDate));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			//日历编码的处理
			if(periods.length()>0){
				periods=periods.substring(0, periods.length()-1);
			List<CommPeriodResp>plist=commPeriodMapper.selDataListByIds(periods);
				if(plist.size()>0){
					for (CommCalendarResp commCalendarResp : list) {
						for (CommPeriodResp commPeriodResp : plist) {
							if(commCalendarResp.calCode.equals(commPeriodResp.id+"")){
								commCalendarResp.calCodeName=commPeriodResp.periodCode;
								break;
							}
						}
					
					}
					
				}
			}
		}
		CommCalendarRespDTO comm=new CommCalendarRespDTO();
		comm.rows=list;
		comm.total=pager.getTotalPage();
		comm.records=pager.getTotalCount();
		
		/*for (CommCalendarResp commCalendarResp : list) {
			commCalendarResp.createTime=DateUtils.formatDate(commCalendarResp.createTime,DateFormatStr.yyyymmddhhmmss);

		}*/
		return comm;
	}
	/**
	 * 更新
	 */
	public int updateCalendarByPrimaryKey(int userId,String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
		CommCalendar commCalendar = null;
		try {
			commCalendar = objectMapper.readValue(data, CommCalendar.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i=0;
		if(commCalendar!=null){
			try {
				commCalendar.setUpdateBy(userId);
				i=commCalendarMapper.updateCalendarByPrimaryKey(commCalendar);
			} catch (Exception e) {
				throw new ErrorCodeException(CommonServiceHttpCode.UPDATE_FAILED);
			}
		}
		return i;
	}
	/**
	 * 查询该信息是否存在
	 */
	public int queryByCalendarInfoIsExist(CommCalendar commCalendar) {
		return commCalendarMapper.queryByCalendarInfoIsExist(commCalendar);
	}
	

	public ArrayList<CommCalendarResp> selDataListByIds(String selList) {
		return commCalendarMapper.selDataListByIds(selList);
	}
	public CommCalendarResp selectCalendarById(Integer id) {
		CommCalendarResp calendar=commCalendarMapper.selectCalendarById(id);
		if(calendar!=null){
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
			 if(calendar.calCode!=null){//获取日期了编码
					calendar.calCodeName=commPeriodMapper.selectPeriodById(Integer.valueOf(calendar.calCode)).periodCode;
			 }
			 //获取公司名称
			/*if(calendar.companyId!=100 && calendar.companyId!=0){
				calendar.companyIdDis=companyAgwService.selectById(calendar.companyId).compName;
			}*/
			 try {
				 if(calendar.calDate!=null){
					 //获取日期格式
					 calendar.calDate=formatter2.format(formatter.parse(calendar.calDate)) ;
				 }
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return calendar;
	}

}
