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

import com.hrocloud.common.api.CommBankInstitutionAgwService;
import com.hrocloud.common.dto.CommBankInstitutionDTO;
import com.hrocloud.common.model.CommBankInstitutionResp;
import com.hrocloud.common.utils.SecurityInit;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/com/dubbo-common-consumer.xml",
"classpath*:/com/spring-mybatis2.xml" })
public class CommBankService extends AbstractJUnit4SpringContextTests{
	@Resource
	private CommBankInstitutionAgwService commBankInstitutionAgwService;
	
	@Before
	public void start(){
		new SecurityInit().init();
	}
	//添加
	@Test
	public void addEmp() throws Exception{
		String data="";
		int i=commBankInstitutionAgwService.insertBank("1", 1, 1,data);
		System.out.println(i);
	}
	//删除
	@Test
	public void delEmp() throws Exception{
		commBankInstitutionAgwService.deleteBatchByIds("1",1,1,"1019");
	//System.out.println(i);
	}
	
	@Test
	public void selectBanks() throws Exception{
		CommBankInstitutionDTO dto=commBankInstitutionAgwService.selectBanks("", 1, 1, 1000, 1, 1, 100, "", "",1, "", 5, 1);
		/*PageParameter pager=new PageParameter();
		pager.setPageSize(5);
		pager.setCurrentPage(1);
		CommParamType commParamTypes=new CommParamType();
		CommParamTypeDTO to=commParamTypeService.selectParamTypeByColumn(pager, commParamTypes);*/
		List<CommBankInstitutionResp> list=dto.rows;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommBankInstitutionResp BankInstitutionResp = (CommBankInstitutionResp) iterator.next();
			System.out.println(BankInstitutionResp.bankName+"别称="+BankInstitutionResp.bankCname);
		}
	}
	//修改
	@Test
	public void updateEmp() throws Exception{
	//	int i=commParamTypeAgwService.updateParamTypeByPrimaryKey("1", 1, 1,1000, 1000, 1000, 1061,"", "性别ss", "0", "测ddd试");
	//	System.out.println(i);
		// int i=staffinfoServiceHttpExport.updateByPrimaryKey("1005","0001", "test", "1000", "1000", "121", "1000", "2016-12-03 16:43:49", "1000", "1000", "1000", "江苏省", "上海市", "fuyun@souhu.com", "1000", "18701819754", "zfy", "2232", "2016-12-03 16:43:49", "sss001", "2016-12-03 16:43:49","2016-12-03 16:43:49", "1", "1", "1", "12", "2016-12-03 16:43:49", "1", "2016-12-03 16:43:49", "1", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "1", "1", "1", "12", "001", "1", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1", "0", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "001", "1", "1", "1000", "1000", "1", "2016-12-03 16:43:49", "1", "1", "1", "11", "zfy", "001", "测试");
		// int i=staffinfoServiceHttpExport.updateByPrimaryKeySelective("1005","0001", "test21", "1000", "1000", "121", "1000", "2016-12-03 16:43:49", "1000", "1000", "1000", "江苏省", "上海市", "fuyun@souhu.com", "1000", "18701819754", "zfy", "2232", "2016-12-03 16:43:49", "sss001", "2016-12-03 16:43:49","2016-12-03 16:43:49", "1", "1", "1", "12", "2016-12-03 16:43:49", "1", "2016-12-03 16:43:49", "1", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "1", "1", "1", "12", "001", "1", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1", "0", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "001", "1", "1", "1000", "1000", "1", "2016-12-03 16:43:49", "1", "1", "1", "11", "zfy", "001", "测试");
		// System.out.println(i);
	}
	//根据参数类型获取参数信息
	@Test
	public void selectByBankId() throws Exception{
		CommBankInstitutionResp  bankInstitutionResp=commBankInstitutionAgwService.selectByBankId("1", 1, 1, 1000); 

			System.out.println(bankInstitutionResp.bankName);
		}
	//修改
	@Test
	public void selectBanksByIds() throws Exception{
		List<CommBankInstitutionResp>  list=commBankInstitutionAgwService.selectBanksByIds("1", 1, 1, "1020");
		//List<CommParamTypeResp> list=commParamTypeResp.list;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommBankInstitutionResp bankInstitutionResp = (CommBankInstitutionResp) iterator.next();
			System.out.println(bankInstitutionResp.bankName);
		}
	}
}
