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

import com.hrocloud.common.api.CommParamTypeService;
import com.hrocloud.common.api.CommParamTypeAgwService;
import com.hrocloud.common.dto.CommParamTypeDTO;
import com.hrocloud.common.dto.CommParamTypePageDTO;
import com.hrocloud.common.model.CommParamType;
import com.hrocloud.common.page.PageParameter;
import com.hrocloud.common.utils.SecurityInit;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/com/dubbo-common-consumer.xml",
		"classpath*:/com/spring-mybatis2.xml" })
public class CommParamTypesTestService extends AbstractJUnit4SpringContextTests{
	@Resource
	private CommParamTypeAgwService commParamTypeAgwService;
	@Resource
	private CommParamTypeService commParamTypeService;
	@Before
	public void start(){
		new SecurityInit().init();
	}
	//添加
	@Test
	public void addEmp() throws Exception{
		String data="";
		int i=commParamTypeAgwService.insertParamType("1", 1, 1,data);
		System.out.println(i);
	}
	//删除
	@Test
	public void delEmp() throws Exception{
		commParamTypeAgwService.deleteParamType("1",1,1,"1019");
	//System.out.println(i);
	}
	
	@Test
	public void selectEmp() throws Exception{
		CommParamTypePageDTO dto=commParamTypeAgwService.selectParamTypeByColumn("", 1, 1, 0, 0, 0, 0, "","性别", "", "", 5, 1);
		/*PageParameter pager=new PageParameter();
		pager.setPageSize(5);
		pager.setCurrentPage(1);
		CommParamType commParamTypes=new CommParamType();
		CommParamTypeDTO to=commParamTypeService.selectParamTypeByColumn(pager, commParamTypes);*/
		List<CommParamTypeDTO> list=dto.rows;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommParamTypeDTO commParamType = (CommParamTypeDTO) iterator.next();
			System.out.println(commParamType.typeName+"创建时间="+commParamType.createTime+"修改="+commParamType.typeIsupdate);
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
	public void selectOneParam() throws Exception{
		CommParamTypeDTO  commParamType=commParamTypeAgwService.selectParamTypeById("1", 1, 1, 1061);

			System.out.println(commParamType.typeName);
		}
	//修改
	@Test
	public void selectTabEmp() throws Exception{
		List<String> list=commParamTypeAgwService.getTableHead("1", 1, 1, 1, 1, 1);
		System.out.println(list);
	}
	@Test
	public void selectEmpIds() throws Exception{
		List<CommParamTypeDTO>  list=commParamTypeAgwService.selectDataByIds("1", 1, 1, "1020");
		//List<CommParamTypeResp> list=commParamTypeResp.list;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CommParamTypeDTO commParamType = (CommParamTypeDTO) iterator.next();
			System.out.println(commParamType.typeName);
		}
	}
}
