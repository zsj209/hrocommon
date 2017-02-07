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
import com.hrocloud.common.api.CommPeriodService;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.dao.CommPeriodMapper;
import com.hrocloud.common.dto.CommPeriodRespDTO;
import com.hrocloud.common.model.CommPeriod;
import com.hrocloud.common.model.CommPeriodResp;
import com.hrocloud.common.page.PageParameter;
/**
 * 
 * Created by zfy on 2016/12/8.
 * 期间接口的实现
 *
 */
@Service("commPeriodService")
public class CommPeriodServiceImpl implements CommPeriodService {
	@Resource
	private CommPeriodMapper commPeriodMapper;
	/**
	 * 删除
	 */
	public int deletePeriod(String ids) {
		return commPeriodMapper.deletePeriod(ids);
	}
	/**
	 * 添加
	 */
	public int insertPeriod(int userId,String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
		CommPeriod commPeriod = null;
		try {
			commPeriod = objectMapper.readValue(data, CommPeriod.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i=0;
		try {
			commPeriod.setCreateBy(userId);
			//判断该条信息是否存在 存在则插入
			if(commPeriodMapper.queryByPeriodInfoIsExist(commPeriod)>0){
		           return -3;
			}
			i=commPeriodMapper.insertPeriod(commPeriod);
		} catch (Exception e) {
           throw new ErrorCodeException(CommonServiceHttpCode.INSERT_FAILED);
		}
		return i;
	}

	/**
	 * 查询
	 */
	public CommPeriodRespDTO selectPeriodByColumn(PageParameter pager,CommPeriod commPeriod) {
		ArrayList<CommPeriodResp> list=commPeriodMapper.selectPeriodByColumnPage(pager,commPeriod);
		if(list.size()>.0){
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
			for (CommPeriodResp commPeriodResp : list) {
				 try {
						commPeriodResp.startTime=formatter2.format(formatter.parse(commPeriodResp.startTime)) ;
						commPeriodResp.endTime=formatter2.format(formatter.parse(commPeriodResp.endTime)) ;
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		CommPeriodRespDTO comm=new CommPeriodRespDTO();
		comm.rows=list;
		comm.total=pager.getTotalPage();
		comm.records=pager.getTotalCount();
		return comm;
	}

	/**
	 * 更改
	 */
	public int updatePeriodByPrimaryKey(int userId,String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
		CommPeriod commPeriod = null;
		try {
			commPeriod = objectMapper.readValue(data, CommPeriod.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i=0;
		if(commPeriod!=null){
			try {
				commPeriod.setUpdateBy(userId);
				i=commPeriodMapper.updatePeriodByPrimaryKey(commPeriod);
			} catch (Exception e) {
		           throw new ErrorCodeException(CommonServiceHttpCode.UPDATE_FAILED);
			}
		}
		return i;
	}
	public int queryByPeriodInfoIsExist(CommPeriod commPeriod) {
		return commPeriodMapper.queryByPeriodInfoIsExist(commPeriod);
	}
	public ArrayList<CommPeriodResp> selDataListByIds(String selList) {
		return commPeriodMapper.selDataListByIds(selList);
	}
	public CommPeriodResp selectPeriodById(Integer id) {
		CommPeriodResp commPeriodResp=new CommPeriodResp();
		commPeriodResp=commPeriodMapper.selectPeriodById(Integer.valueOf(id));
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			commPeriodResp.startTime=formatter2.format(formatter.parse(commPeriodResp.startTime)) ;
			commPeriodResp.endTime=formatter2.format(formatter.parse(commPeriodResp.endTime)) ;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commPeriodResp;
	}

}
