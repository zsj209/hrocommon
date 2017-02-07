package com.hrocloud.common.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.client.utils.DateUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrocloud.apigw.client.dubboext.DubboExtProperty;
import com.hrocloud.common.api.CommCityService;
import com.hrocloud.common.api.CommParamTypeService;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.dao.CommCityMapper;
import com.hrocloud.common.dao.CommParamInfoMapper;
import com.hrocloud.common.dao.CommParamTypeMapper;
import com.hrocloud.common.dto.CommParamInfoDTO;
import com.hrocloud.common.dto.CommParamTypeDTO;
import com.hrocloud.common.dto.CommParamTypePageDTO;
import com.hrocloud.common.model.CommParamInfo;
import com.hrocloud.common.model.CommParamType;
import com.hrocloud.common.model.CommCityResp;
import com.hrocloud.common.page.PageParameter;
import com.hrocloud.company.api.CompanyAgwService;
import com.hrocloud.company.api.CompanyService;
import com.hrocloud.company.model.Company;
import com.hrocloud.util.DateFormatStr;

@Service("commParamTypeService")
public class CommParamTypeServiceImpl implements CommParamTypeService {
	@Resource
	private CommParamTypeMapper commParamTypeMapper;
	@Resource
	private CommParamInfoMapper commParamInfoMapper;
	
	@Resource 	
	private CompanyService companyService;
	/**
	 * 删除类型
	 */
	public int deleteParamType(String ids) {
		//根据参数类型id查找编码
		List<CommParamTypeDTO> list=commParamTypeMapper.selDataListByIds(ids);
		//删除参数类型
		if(commParamTypeMapper.deleteParamType(ids)>0){
			if(list.size()>0){
				String typeCodes="";
				for (CommParamTypeDTO commParamTypeDTO : list) {
					typeCodes+="'"+commParamTypeDTO.typeCode+"',";
				}
				if(typeCodes.length()>0){
					//根据主表编码查找字表的id
					typeCodes=typeCodes.substring(0, typeCodes.length()-1);
					List<CommParamInfoDTO> listIds=commParamInfoMapper.selDataListByCodes(2, typeCodes);
					if(listIds.size()>0){
						String typeIds="";
						for (CommParamInfoDTO commParamInfoDTO : listIds) {
							typeIds+=commParamInfoDTO.id+",";
						}
						//根据参数id删除参数信息
						if(typeIds.length()>0){
							typeIds=typeIds.substring(0, typeIds.length()-1);
							int i=commParamInfoMapper.deleteParamInfo(typeIds);
						}
						
					}
				}
			}
			
		}
		return 1;
	}

	/**
	 * 添加类型
	 */
	public int insertParamType(int userId,String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
		CommParamType commParamType = null;
		try {
			commParamType = objectMapper.readValue(data, CommParamType.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i=0;
		if(commParamType!=null){//id存在的时候修改否则添加
			
			try {
				commParamType.setCreateBy(userId);
				//判断该条信息是否存在 存在则插入
				if(commParamTypeMapper.queryByParamTypeInfoIsExist(commParamType)<=0){
					i=commParamTypeMapper.insertParamType(commParamType);
				}else{
			          return -3;
				}
			} catch (Exception e) {
	          throw new ErrorCodeException(CommonServiceHttpCode.INSERT_FAILED);
			}
		}
		return i;
		
	}

	/**
	 * 根据类型查询类型集合
	 */
	public CommParamTypePageDTO selectParamTypeByColumn(PageParameter pager,
			CommParamType commParamType) {
		List<CommParamTypeDTO> list=commParamTypeMapper.selectParamTypeByColumnPage(pager,commParamType);
	
		CommParamTypePageDTO comm=new CommParamTypePageDTO();
		comm.rows=list;
		comm.page = pager.getCurrentPage();
		comm.total=pager.getTotalPage();
		comm.records=pager.getTotalCount();
		return comm;
	}

	/**
	 * 更新类型
	 */
	public int updateParamTypeByPrimaryKey(int userId,String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
		CommParamType commParamType = null;
		try {
			commParamType = objectMapper.readValue(data, CommParamType.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i=0;
		if(commParamType!=null){
			try {
				commParamType.setUpdateBy(userId);
				i=commParamTypeMapper.updateParamTypeByPrimaryKey(commParamType);
			} catch (Exception e) {
				throw new ErrorCodeException(CommonServiceHttpCode.UPDATE_FAILED);
			}
			
		}else{
			//DubboExtProperty.setErrorCode(CommonServiceHttpCode.INSERT_FAILED);
	           return -2;
		}
		return i;
	}

	/**
	 * 查询类型是否存在
	 */
	public int queryByParamTypeInfoIsExist(CommParamType commParamType) {
		return commParamTypeMapper.queryByParamTypeInfoIsExist(commParamType);
	}

	/**
	 * 根据id查询该对象
	 */
	public CommParamTypeDTO selectParamTypeById(Integer id) {
		CommParamTypeDTO comm=commParamTypeMapper.selectParamTypeById(id);
		if(comm.companyId!=0 && comm.companyId!=100){
			String name="";
			Company comp;
			try {
				comp=companyService.selectById(comm.companyId);
				if(comp!=null){
					comm.companyIdDis=comp.getCompName();
				}
			} catch (Exception e) {
				name="";
			}
					
			
		}
		return comm;
	}

	public ArrayList<String> getTableHead(int userId, int funId, int stype) {
		// 根据用户判断该用户有哪些字段
		ArrayList<String> headList = new ArrayList<String>();
		if (userId == 1) {
			if (stype == 2) {
				String bnStr = "[{code:'bn_add',name:'新增'},{code:'bn_upd',name:'修改'},{code:'bn_del',name:'删除'}]";
				headList.add(0, bnStr);
			} else if (stype == 1) {
				String clStr = "id,创建时间,参数类型名称,不可修改标志,备注";
				String clname = "[{name:'id'},{name:'createTime',type:'1',check:'0',selid:'0'},{name:'typeName',type:'1',check:'0',selid:'0'},"
						+ "{name:'typeIsupdate',type:'4',check:'0',selid:'0'},{name:'comment',type:'5',check:'0',selid:'0'}]";
				headList.add(0, clStr);
				headList.add(1, clname);
			}else if (stype == 3) {
				String clStr = "id,参数类型名称,不可修改标志,备注";
				String clname = "[{name:'id'},{name:'typeName',type:'1',check:'0',selid:'0'},"
						+ "{name:'typeIsupdate',type:'4',check:'0',selid:'0'},{name:'comment',type:'5',check:'0',selid:'0'}]";
				headList.add(0, clStr);
				headList.add(1, clname);
			} else {
				headList.add(0, "error");
			}
		} else if (userId == 2) {
			if (stype == 2) {
				String bnStr = "[{code:'bn_add',name:'新增'},{code:'bn_upd',name:'修改'},{code:'bn_del',name:'删除'}]";
				headList.add(0, bnStr);
			} else if (stype == 1) {
				String clStr = "id,所属公司,参数类型,参数名称,备注";
				String clname = "[{name:'id'},{name:'companyId',type:'1',check:'0',selid:'0'},{name:'paramType',type:'2',check:'0',selid:'3001'},"
						+ "{name:'paramName',type:'1',check:'0',selid:'0'},{name:'comment',type:'5',check:'0',selid:'0'}]";
				headList.add(0, clStr);
				headList.add(1, clname);
			} else if (stype == 3) {
				String clStr = "id,参数类型,参数名称,备注";
				String clname = "[{name:'id'},{name:'paramType',type:'2',check:'0',selid:'3001'},"
						+ "{name:'paramName',type:'1',check:'0',selid:'0'},{name:'comment',type:'5',check:'0',selid:'0'}]";
				headList.add(0, clStr);
				headList.add(1, clname);
			} else {
				headList.add(0, "error");
			}
		} else if (userId == 3) {
			if (stype == 2) {
				String bnStr = "[{code:'bn_add',name:'新增'},{code:'bn_upd',name:'修改'},{code:'bn_del',name:'删除'}]";
				headList.add(0, bnStr);
			} else if (stype == 1) {
				String clStr = "id,创建时间,期间编码,期间年份,期间月份,开始日期,截止日期,备注";
				String clname = "[{name:'id'},{name:'createTime',type:'1',check:'0',selid:'0'},{name:'periodCode',type:'1',check:'0',selid:'0'},"
						+ "{name:'periodYear',type:'1',check:'0',selid:'0'},{name:'periodMonth',type:'1',check:'0',selid:'0'},"
						+ "{name:'startTime',type:'1',check:'0',selid:'0'},{name:'endTime',type:'1',check:'0',selid:'0'},"
						+ "{name:'comment',type:'5',check:'0',selid:'0'}]";
				headList.add(0, clStr);
				headList.add(1, clname);
			}else if (stype == 3) {
				String clStr = "id,期间编码,期间年份,期间月份,开始日期,截止日期,备注";
				String clname = "[{name:'id'},{name:'periodCode',type:'1',check:'0',selid:'0'},"
						+ "{name:'periodYear',type:'1',check:'0',selid:'0'},{name:'periodMonth',type:'1',check:'0',selid:'0'},"
						+ "{name:'startTime',type:'1',check:'0',selid:'0'},{name:'endTime',type:'1',check:'0',selid:'0'},"
						+ "{name:'comment',type:'5',check:'0',selid:'0'}]";
				headList.add(0, clStr);
				headList.add(1, clname);
			}  else {
				headList.add(0, "error");
			}
		}else if (userId == 4) {
			if (stype == 2) {
				String bnStr = "[{code:'bn_add',name:'新增'},{code:'bn_upd',name:'修改'},{code:'bn_del',name:'删除'}]";
				headList.add(0, bnStr);
			} else if (stype == 1) {
				String clStr = "id,创建时间,所属公司,省份,城市名称,城市类型,备注";
				String clname = "[{name:'id'},{name:'createTime',type:'1',check:'0',selid:'0'},{name:'companyId',type:'1',check:'0',selid:'0'},"
						+ "{name:'cityPid',type:'2',check:'0',selid:'3002'},{name:'provCityName',type:'1',check:'0',selid:'0'},{name:'cityType',type:'3',check:'0',selid:'1004'},"
						+ "{name:'comment',type:'5',check:'0',selid:'0'}]";
				headList.add(0, clStr);
				headList.add(1, clname);
			}else if (stype == 3) {
				String clStr = "id,省份,城市名称,城市类型,备注";
				String clname = "[{name:'id'},"
						+ "{name:'cityPid',type:'2',check:'0',selid:'3002'},{name:'provCityName',type:'1',check:'0',selid:'0'},{name:'cityType',type:'3',check:'0',selid:'1004'},"
						+ "{name:'comment',type:'5',check:'0',selid:'0'}]";
				headList.add(0, clStr);
				headList.add(1, clname);
			} else {
				headList.add(0, "error");
			}
		}else if(userId==5){
			if(stype==2){
				String bnStr="[{code:'bn_add',name:'新增'},{code:'bn_upd',name:'修改'},{code:'bn_del',name:'删除'}]";
				headList.add(0,bnStr);
			}else if(stype==1){
				String clStr="id,创建时间,期间编码,一日,二日,三日,四日,五日,六日,七日,八日,九日,十日,十一日,十二日,十三日,十四日,十五日,十六日,十七日,十八,十九,二十,二十一,二十二,二十三,二十四,二十五,二十六,二十七,二十八,二十九,三十,三十一,备注";
				String clname="[{name:'id'},"
						+ "{name:'createTime',type:'1',check:'0',selid:'0'},{name:'periodCode',type:'1',check:'0',selid:'0'},"
						+ "{name:'day1',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day2',type:'3',check:'0',selid:'1055'},{name:'day3',type:'3',check:'0',selid:'1055'},{name:'day4',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day5',type:'3',check:'0',selid:'1055'},{name:'day6',type:'3',check:'0',selid:'1055'},{name:'day10',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day8',type:'3',check:'0',selid:'1055'},{name:'day9',type:'3',check:'0',selid:'1055'},{name:'day7',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day11',type:'3',check:'0',selid:'1055'},{name:'day12',type:'3',check:'0',selid:'1055'},{name:'day13',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day14',type:'3',check:'0',selid:'1055'},{name:'day15',type:'3',check:'0',selid:'1055'},{name:'day16',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day17',type:'3',check:'0',selid:'1055'},{name:'day18',type:'3',check:'0',selid:'1055'},{name:'day19',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day20',type:'3',check:'0',selid:'1055'},{name:'day21',type:'3',check:'0',selid:'1055'},{name:'day22',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day23',type:'3',check:'0',selid:'1055'},{name:'day24',type:'3',check:'0',selid:'1055'},{name:'day25',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day26',type:'3',check:'0',selid:'1055'},{name:'day27',type:'3',check:'0',selid:'1055'},{name:'day28',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day29',type:'3',check:'0',selid:'1055'},{name:'day30',type:'3',check:'0',selid:'1055'},{name:'day31',type:'3',check:'0',selid:'1055'},"
						+ "{name:'comment',type:'1',check:'0',selid:'0'}]";
						
				
				headList.add(0,clStr);
				headList.add(1,clname);
			}else if(stype==3){
				String clStr="id,期间编码,一日,二日,三日,四日,五日,六日,七日,八日,九日,十日,十一日,十二日,十三日,十四日,十五日,十六日,十七日,十八,十九,二十,二十一,二十二,二十三,二十四,二十五,二十六,二十七,二十八,二十九,三十,三十一,备注";
				String clname="[{name:'id'},"
						+ "{name:'periodCode',type:'1',check:'0',selid:'0'},"
						+ "{name:'day1',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day2',type:'3',check:'0',selid:'1055'},{name:'day3',type:'3',check:'0',selid:'1055'},{name:'day4',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day5',type:'3',check:'0',selid:'1055'},{name:'day6',type:'3',check:'0',selid:'1055'},{name:'day10',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day8',type:'3',check:'0',selid:'1055'},{name:'day9',type:'3',check:'0',selid:'1055'},{name:'day7',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day11',type:'3',check:'0',selid:'1055'},{name:'day12',type:'3',check:'0',selid:'1055'},{name:'day13',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day14',type:'3',check:'0',selid:'1055'},{name:'day15',type:'3',check:'0',selid:'1055'},{name:'day16',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day17',type:'3',check:'0',selid:'1055'},{name:'day18',type:'3',check:'0',selid:'1055'},{name:'day19',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day20',type:'3',check:'0',selid:'1055'},{name:'day21',type:'3',check:'0',selid:'1055'},{name:'day22',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day23',type:'3',check:'0',selid:'1055'},{name:'day24',type:'3',check:'0',selid:'1055'},{name:'day25',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day26',type:'3',check:'0',selid:'1055'},{name:'day27',type:'3',check:'0',selid:'1055'},{name:'day28',type:'3',check:'0',selid:'1055'},"
						+ "{name:'day29',type:'3',check:'0',selid:'1055'},{name:'day30',type:'3',check:'0',selid:'1055'},{name:'day31',type:'3',check:'0',selid:'1055'},"
						+ "{name:'comment',type:'1',check:'0',selid:'0'}]";
						
				
				headList.add(0,clStr);
				headList.add(1,clname);
			}else{
				headList.add(0,"error");
			}
		}

		return headList;
	}

	public ArrayList<String> getTableSelectvl(int userId, String selids) {
		ArrayList<String> headList = new ArrayList<String>();
		// 类型id 参数id 参数值
		String selval = "[{nid:'1000',vid:'1001',vstr:'中国银行报盘'},{nid:'1000',vid:'1002',vstr:'农业银行报盘'},"
				+ "{nid:'1001',vid:'1003',vstr:'中国银行'},{nid:'1001',vid:'1004',vstr:'农业银行'}]";
		headList.add(0, selval);
		return headList;
	}

	public List<CommParamTypeDTO> selDataListByIds(String selList) {
		return commParamTypeMapper.selDataListByIds(selList);
	}

	public List<CommParamTypeDTO> selDatasByCodes(String selList) {
		return commParamTypeMapper.selDatasByCodes(selList);
	}

}
