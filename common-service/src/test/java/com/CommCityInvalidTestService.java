package com;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrocloud.common.api.CommCityInvalidAgwService;
import com.hrocloud.common.api.CommCityInvalidService;
import com.hrocloud.common.dto.CommCityInvalidDTO;
import com.hrocloud.common.dto.CommCityInvalidPageDTO;
import com.hrocloud.common.model.CommCityInvalid;
import com.hrocloud.common.utils.SecurityInit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/com/dubbo-common-consumer.xml",
		"classpath*:/com/spring-mybatis2.xml" })
public class CommCityInvalidTestService extends
		AbstractJUnit4SpringContextTests {
	private final static Logger logger = LoggerFactory
			.getLogger(CommCityInvalidTestService.class);

	@Autowired
	private CommCityInvalidService commCityInvalidService;

	@Autowired
	private CommCityInvalidAgwService commCityInvalidAgwService;

	@Before
	public void start() {
		new SecurityInit().init();
	}

	@Test
	public void testgetInvalidCityForSet() throws Exception {

		// test dubbo service
		List<CommCityInvalid> list = commCityInvalidService
				.getInvalidCityForSet(1, 1000);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				CommCityInvalid ctin = list.get(i);
				logger.info("citycode:" + ctin.getCityCode() + " cityname:"
						+ ctin.getCityName() + "citypcode:"
						+ ctin.getCityPcode() + " sublist:" + ctin.getSublist()
						+ " subnums:" + ctin.getSubnums() + " Subvalidnums:"
						+ ctin.getSubvalidnums() + " Setstyle:"
						+ ctin.getSetstyle());
			}
		} else
			logger.info("list is null");

		// test agw service
		List<CommCityInvalidDTO> list2 = commCityInvalidAgwService
				.getInvalidCityForSet("1", "1000");
		if (list2 != null) {
			for (int i = 0; i < list2.size(); i++) {
				CommCityInvalidDTO ctindto = list2.get(i);
				logger.info("citycode:" + ctindto.cityCode + " cityname:"
						+ ctindto.CityName + "citypcode:" + ctindto.cityPcode
						+ " sublist:" + ctindto.sublist + " Setstyle:"
						+ ctindto.setstyle);
			}
		} else
			logger.info("list2 is null");

	}

	@Test
	public void testsaveInvalidCity() throws Exception {

		// commCityInvalidService.saveInvalidCity(1008, 1, 1000,
		// "1000,1001,1028,1007,1009,1010,1013");

		// commCityInvalidService.saveInvalidCity(1008, 1, 1000,
		// "1000,1001,1028,1007,1009");

		commCityInvalidAgwService.saveInvalidCity("1008", "1", "1000",
				"1000,1001,1028,1007,1009");

	}

	@Test
	public void testselectInvalCityListPage() {
		// test agw service
		CommCityInvalidPageDTO ctpagedto = commCityInvalidAgwService
				.selectInvalCityList("1000", "上", 20, 1);
		if (ctpagedto != null) {
			for (int i = 0; i < ctpagedto.rows.size(); i++) {
				CommCityInvalidDTO ctindto = ctpagedto.rows.get(i);
				logger.info("citycode:" + ctindto.cityCode + " cityname:"
						+ ctindto.CityName );
			}
		} else
			logger.info("ctpagedto is null");
	}

}
