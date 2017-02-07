package com;


import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrocloud.common.api.CommCityAgwService;
import com.hrocloud.common.api.CommCityService;
import com.hrocloud.common.dto.CommCityRespDTO;
import com.hrocloud.common.model.CommCityResp;
import com.hrocloud.common.utils.SecurityInit;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/com/dubbo-common-consumer.xml",
"classpath*:/com/spring-mybatis2.xml" })
public class TestService extends AbstractJUnit4SpringContextTests {
	@Autowired
	private CommCityAgwService commCityAgwService;
	@Autowired
	private CommCityService commCityService;

	// @Resource
	// private SsecAccountServiceHttpExport ssecAccountServiceHttpExport;
	// 添加
	@Before
	public void start(){
		new SecurityInit().init();
	}
	
	@Test
	public void addEmp() throws Exception {
	/*	 int i=commCityAgwService.insertCity("1", 1, 1, 1000,
		 1000, 100, "cty005","南京市",
		 "cty003", "p_city_01", "");*/
		
	// System.out.println(i);

	}

	// 删除
	@Test
	public void delEmp() throws Exception {
		commCityAgwService.deleteCityByPrimaryKey("1", 1, 1,
				"1004,1005,1006");
		// System.out.println(i);
	}

	@Test
	public void selectEmp() throws Exception {
		CommCityRespDTO dto = commCityAgwService
				.selectCityListByColumn("1", 1, 1, 0, 0,0, 0,"",
						"", "", "", "",5,1);
		 List<CommCityResp> list=dto.rows;
		//commCityAgwService.selectCityListByColumn(clientIp, deviceId, applicationId, id, createBy, createTime, updateBy, updateTime, companyId, cityName, cityPid, cityType, comment)
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommCityResp commCity = (CommCityResp) iterator.next();
			System.out.println(commCity.cityName + "="
					+ commCity.cityPid + "==" + commCity.id);
		}
	}

	// 修改
	@Test
	public void updateEmp() throws Exception {
		/*commCityAgwService.updateByPrimaryKey("1", 1, 1, 1000, 1000,
				 1000,  1000,"c001",
				"重庆", "1000", "1000", "");*/

	}
//TODO
	@Test
	public void selectTreeList() throws Exception {
		// CommCity commCity=new CommCity();
		// commCity.setCity_pid("1000");
		List<CommCityResp> list = commCityAgwService.queryTreeCityList(
				"1", 1, 1, 1000);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommCityResp commCityResp = (CommCityResp) iterator.next();
			System.out.println(commCityResp.cityName);
		}
	}


	@Test
	public void selectCityIdList() throws Exception {
		List<CommCityResp> list = commCityService.selDataListByIds("1000,1002,1004,1000");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommCityResp commCity = (CommCityResp) iterator.next();
			System.out.println(commCity.cityName);
		}
	}
	@Test
	public void selectAllEmp() throws Exception {
		CommCityRespDTO dto = commCityAgwService
				.selectAllCityListByColumn("1",1,1, 1000, "", "", "", "", 2, 5, 1);
		
		 List<CommCityResp> list=dto.rows;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommCityResp commCity = (CommCityResp) iterator.next();
			System.out.println(commCity.cityName + 
					"==" + commCity.cityType+"=="+commCity.cityPid);
		}
	}

	@Test
	public void selectCityById() throws Exception {
		CommCityResp comm= commCityService.selectCityById(1003);
		System.out.println(comm.cityName);
	}
	@Test
	public void selectChildrenByCodes() throws Exception {
		List<CommCityResp> list = commCityService.queryChlidrenById(1000);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommCityResp commCityResp = (CommCityResp) iterator.next();
			System.out.println(commCityResp.cityName);
		}
	}
	
	@Test
	public void selectChlidrenById() throws Exception {
		List<Integer> list = commCityService.selectChlidrenById(1002);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
