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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrocloud.common.api.CommParamInfoService;
import com.hrocloud.common.api.CommParamInfoAgwService;
import com.hrocloud.common.dto.CommParamInfoDTO;
import com.hrocloud.common.dto.CommParamInfoPageDTO;
import com.hrocloud.common.dto.ParamGroupDTO;
import com.hrocloud.common.dto.ParamValueDTO;
import com.hrocloud.common.model.CommParamInfo;
import com.hrocloud.common.utils.SecurityInit;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/com/dubbo-common-consumer.xml",
"classpath*:/com/spring-mybatis2.xml" })
public class CommParamInfoTestService extends AbstractJUnit4SpringContextTests{
	@Resource
	private CommParamInfoAgwService commParamInfoAgwService;
	@Resource
	private CommParamInfoService commParamInfoService;
	
	@Before
	public void start(){
		new SecurityInit().init();
	}
	//添加
	@Test
	public void addEmp() throws Exception{
		String data="{'paramCode':'121'}";
		int i=commParamInfoAgwService.insertParamInfo("1", 1, 1, data);
		System.out.println(i);
	}
	//删除
	@Test
	public void delEmp() throws Exception{
		commParamInfoAgwService.deleteParamInfo("1",1,1,"1023");
	//System.out.println(i);
	}
	
	@Test
	public void selectEmp() throws Exception{
		/*List<CommParamInfoDTO> list=commParamInfoAgwService.selectParamInfoByColumn("1", 1, 1,0, 0, 0, 0, "p_taxtp_01","", "", "");
		//List<CommParamInfo> list=commParamInfoService.selectParamInfoAndTypes();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommParamInfoDTO commParamInfos = (CommParamInfoDTO) iterator.next();
			System.out.println(commParamInfos.paramName+"=="+commParamInfos.paramType+"code="+commParamInfos.paramCode);
			
		}*/
		CommParamInfo commParamInfo=new CommParamInfo();
		commParamInfo.setParamType("p_taxtp");
		List<CommParamInfoDTO> list2=commParamInfoService.selectParamInfoByColumn(commParamInfo);
		for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
			CommParamInfoDTO commParamInfos = (CommParamInfoDTO) iterator.next();
			System.out.println(commParamInfos.paramName+"=="+commParamInfos.paramType+"code="+commParamInfos.paramCode);
			
		}
	}
	//修改
	@Test
	public void updateEmp() throws Exception{
		//int i=commParamInfoAgwService.updateParamInfoByPrimaryKey("1", 1, 1,1000, 1000, 1000, 1000, "1001","", "本地城镇", "11");
		//System.out.println(i);
		// int i=staffinfoServiceHttpExport.updateByPrimaryKey("1005","0001", "test", "1000", "1000", "121", "1000", "2016-12-03 16:43:49", "1000", "1000", "1000", "江苏省", "上海市", "fuyun@souhu.com", "1000", "18701819754", "zfy", "2232", "2016-12-03 16:43:49", "sss001", "2016-12-03 16:43:49","2016-12-03 16:43:49", "1", "1", "1", "12", "2016-12-03 16:43:49", "1", "2016-12-03 16:43:49", "1", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "1", "1", "1", "12", "001", "1", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1", "0", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "001", "1", "1", "1000", "1000", "1", "2016-12-03 16:43:49", "1", "1", "1", "11", "zfy", "001", "测试");
		// int i=staffinfoServiceHttpExport.updateByPrimaryKeySelective("1005","0001", "test21", "1000", "1000", "121", "1000", "2016-12-03 16:43:49", "1000", "1000", "1000", "江苏省", "上海市", "fuyun@souhu.com", "1000", "18701819754", "zfy", "2232", "2016-12-03 16:43:49", "sss001", "2016-12-03 16:43:49","2016-12-03 16:43:49", "1", "1", "1", "12", "2016-12-03 16:43:49", "1", "2016-12-03 16:43:49", "1", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "1", "1", "1", "12", "001", "1", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1", "0", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "2016-12-03 16:43:49", "001", "1", "1", "1000", "1000", "1", "2016-12-03 16:43:49", "1", "1", "1", "11", "zfy", "001", "测试");
		// System.out.println(i);
	}
	
	
	//根据id获取参数信息
		@Test
		public void selectParamInfoById()throws Exception{
			CommParamInfoDTO commParamInfos=commParamInfoAgwService.selectParamInfoById("1", 1, 1,1001);

				System.out.println(commParamInfos.paramName+"类型名称="+commParamInfos.typeName+"公司名称="+commParamInfos.companyIdDis);
		}
	
		
		@Test
		public void selectParamInfo() throws Exception{
			List<CommParamInfoDTO> list=commParamInfoAgwService.selDataListByCodes("1", 0, 0,1,"'p_taxtp_01','p_taxtp_02'");
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				CommParamInfoDTO commParamInfos = (CommParamInfoDTO) iterator.next();
				System.out.println(commParamInfos.paramName+"=="+commParamInfos.paramType+"code="+commParamInfos.paramCode);
				
			}
		}
		
		@Test
		public void selectEmp2() throws Exception{
			CommParamInfoPageDTO comm=commParamInfoAgwService.selectParamInfo("1", 0, 0, 0, 0, 0, 0,"", "", "", "", "1", 5, 1);
			List<CommParamInfoDTO> list=comm.rows;
			//List<CommParamInfo> list=commParamInfoService.selectParamInfoAndTypes();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				CommParamInfoDTO commParamInfos = (CommParamInfoDTO) iterator.next();
				System.out.println(commParamInfos.paramName+"=="+commParamInfos.paramType);
				
			}
		}
		@Test
		public void selectSelectT() throws Exception{
			List<String> list=commParamInfoAgwService.getTableSelectvl("1", 0, 0, 1, "citytype");
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				System.out.println(string);
				//System.out.println(string.nid);
			}
		}
		
		@Test
		public void selectCommSelectT() throws Exception{
			List<ParamValueDTO> list=commParamInfoAgwService.getSelect("1", 0, 1, "selmonths","");
			for (ParamValueDTO paramValueDTO : list) {
				System.out.println(paramValueDTO.code+"="+paramValueDTO.desc);
			}
		}
		@Test
		public void getParamList() throws Exception{
			List<ParamValueDTO> list=commParamInfoAgwService.getParamList( "datetype");
			for (ParamValueDTO paramValueDTO : list) {
				System.out.println(paramValueDTO.code+"="+paramValueDTO.desc);
			}
		}
		@Test
		public void getParamLists() throws Exception{
			List<String>paramTypeList=new ArrayList<String>();
			paramTypeList.add("datetype");
			paramTypeList.add("yesno");
			List<ParamGroupDTO> list=commParamInfoAgwService.getParamList(paramTypeList);
			for (ParamGroupDTO paramGroupDTO : list) {
				System.out.println(paramGroupDTO.typeCode+"="+paramGroupDTO.paramList);
			}
		}
}
