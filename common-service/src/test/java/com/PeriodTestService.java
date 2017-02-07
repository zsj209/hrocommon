package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrocloud.common.api.CommCalendarAgwService;
import com.hrocloud.common.api.CommCityService;
import com.hrocloud.common.api.CommCityAgwService;
import com.hrocloud.common.api.CommParamInfoAgwService;
import com.hrocloud.common.api.CommParamTypeService;
import com.hrocloud.common.api.CommParamTypeAgwService;
import com.hrocloud.common.api.CommPeriodAgwService;
import com.hrocloud.common.dto.CommPeriodRespDTO;
import com.hrocloud.common.model.CommCalendarResp;
import com.hrocloud.common.model.CommCity;
import com.hrocloud.common.model.CommCityResp;
import com.hrocloud.common.model.CommParamType;
import com.hrocloud.common.model.CommPeriodResp;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/com/dubbo-common-consumer.xml",
"classpath*:/com/spring-mybatis2.xml" })
public class PeriodTestService extends AbstractJUnit4SpringContextTests{
	@Resource
	private CommPeriodAgwService CommPeriodAgwService;
	//添加
	@Test
	public void addEmp() throws Exception{
		String periodCode="201703";
		String data="{'companyId':'100','periodCode':"+periodCode+"}";
		int i=CommPeriodAgwService.insertPeriod("1", 1, 1, data);
		//int i=CommPeriodAgwService.insertPeriod("1", 1, 1,  100, 1000, 1,"201507", "2015", "9", "2016-12-01", "2016-12-30", "");
		
		System.out.println(i);
	}
	//删除
	@Test
	public void delEmp() throws Exception{
		CommPeriodAgwService.deletePeriod("1",1,1,"1000");
	//System.out.println(i);
	}
	
	@Test
	public void selectEmp() throws Exception{
		CommPeriodRespDTO dto=CommPeriodAgwService.selectPeriodByColumn("1", 1, 1, 0,0, 0, 1002, "", "", "", "", "", "",3,1);
		List<CommPeriodResp> list=dto.rows;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommPeriodResp commCity = (CommPeriodResp) iterator.next();
			System.out.println(commCity.periodCode+"=="+commCity.startTime);
		}
	}
	//修改
	@Test
	public void updateEmp() throws Exception{
		//int i=CommPeriodAgwService.updatePeriodByPrimaryKey("1", 1, 1, 1000,1000, 1000, 1000, "201512", "2015", "12", "2016-12-01", "2016-12-30", "");
		
		//System.out.println(i);
	}
	@Test
	public void selectEmpIds() throws Exception{
		List<CommPeriodResp> list=CommPeriodAgwService.selectDataByIds("1", 1, 1,"1000,1001");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommPeriodResp commCity = (CommPeriodResp) iterator.next();
			System.out.println(commCity.periodCode);
		}
	}
	
	@Test
	public void selectEmpById() throws Exception{
		CommPeriodResp  commPeriodResp=CommPeriodAgwService.selectParamInfoById("1", 1, 1,"1001");
			System.out.println(commPeriodResp.periodCode+"=="+commPeriodResp.startTime);
	}
}
