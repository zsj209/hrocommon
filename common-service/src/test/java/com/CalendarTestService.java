package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrocloud.common.api.CommCalendarAgwService;
import com.hrocloud.common.dto.CommCalendarRespDTO;
import com.hrocloud.common.model.CommCalendarResp;
import com.hrocloud.common.utils.SecurityInit;
import com.hrocloud.company.api.CompanyAgwService;
import com.hrocloud.company.dto.CompanyDto;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/com/dubbo-common-consumer.xml",
"classpath*:/com/spring-mybatis2.xml" })
public class CalendarTestService extends AbstractJUnit4SpringContextTests{
	@Resource
	private CommCalendarAgwService commCalendarAgwService;
	//@Resource
	//private CompanyAgwService companyAgwService;
	@Before
	public void start(){
		new SecurityInit().init();
	}
	
	//添加
	@Test
	public void addEmp() throws Exception{
		//int i=commCalendarAgwService.insertCalendar("1", 1, 1, "1000", "2016-11-29 19:28:27", "1000", "2016-11-29 19:28:27", "1000", "201610", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "测试");
		//System.out.println(i);
	}
	//删除
	@Test
	public void delEmp() throws Exception{
		int i=commCalendarAgwService.deleteCalendar("1",1,1,"1000,1001");
	System.out.println(i);
	}
	
	@Test
	public void selectEmp() throws Exception{
		CommCalendarRespDTO dto=commCalendarAgwService.selectCalendarByColumn("1", 1, 1, 1, 1, 1, 1, "", "", "", 5, 1);
		List<CommCalendarResp> list=dto.rows;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommCalendarResp commCalendarResp = (CommCalendarResp) iterator.next();
			System.out.println(commCalendarResp.calCode);
		}
	}
	//修改
	@Test
	public void updateEmp() throws Exception{
	//	int i=commCalendarAgwService.updateCalendarByPrimaryKey("1", 1, 1,"1000", "1000", "2016-11-29 19:28:27", "1000", "2016-11-29 19:28:27", "1000", "201612", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "");
	//	System.out.println(i);
	}
	
	
		@Test
		public void selectDataByIds() throws Exception{
			List<CommCalendarResp> list=commCalendarAgwService.selDataListByIds("1", 1, 1,"1000,1001");
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				CommCalendarResp commCalendarResp = (CommCalendarResp) iterator.next();
				System.out.println(commCalendarResp.calCode);
			}
		}
		
		@Test
		public void selectEmpById() throws Exception{
			CommCalendarResp commCalendarResp=commCalendarAgwService.selectCalendarById("1", 1, 1,"1004");
				System.out.println(commCalendarResp.calCode+"companyName="+commCalendarResp.companyIdDis);
		}
		
		@Test
		public void selectCompanyById() throws Exception{
			//CompanyDto  company=companyAgwService.selectById(1004);
			//	System.out.println(company.compName);
		}
}
