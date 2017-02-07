package com.hrocloud.common.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Service;

import com.hrocloud.apigw.client.dubboext.DubboExtProperty;
import com.hrocloud.common.api.CommParamInfoService;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.dao.CommCityMapper;
import com.hrocloud.common.dao.CommParamInfoMapper;
import com.hrocloud.common.dao.CommParamTypeMapper;
import com.hrocloud.common.dto.CommParamInfoDTO;
import com.hrocloud.common.dto.CommParamInfoPageDTO;
import com.hrocloud.common.dto.CommParamTypeDTO;
import com.hrocloud.common.dto.PubForIdselobjRespDTO;
import com.hrocloud.common.model.CommParamInfo;
import com.hrocloud.common.model.PubForIdselobj;
import com.hrocloud.common.page.PageParameter;
import com.hrocloud.company.api.CompanyService;
import com.hrocloud.company.model.Company;

@Service("commParamInfoService")
public class CommParamInfoServiceImpl implements CommParamInfoService {
	@Resource
	private CommParamInfoMapper commParamInfoMapper;
	
	@Resource
	private CommParamTypeMapper commParamTypeMapper;
	@Resource
	private CommCityMapper commCityMapper;
	@Resource 	
	private CompanyService companyService;
	/**
	 * 删除
	 */
	public int deleteParamInfo(String ids) {
		return commParamInfoMapper.deleteParamInfo(ids);
	}
	/**
	 * 添加
	 */
	public int insertParamInfo(int userId,String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
		CommParamInfo commParamInfo = null;
		try {
			commParamInfo = objectMapper.readValue(data, CommParamInfo.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i=0;
		if(commParamInfo!=null){
			try {
				commParamInfo.setCreateBy(userId);
				//判断该条信息是否存在 存在则插入(添加的时候判断编码是否存在)
				if(commParamInfoMapper.queryByParamInfoInfoIsExist(commParamInfo)<=0){
					i=commParamInfoMapper.insertParamInfo(commParamInfo);
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
	 * 根据参数信息查看参数列表
	 */
	public List<CommParamInfoDTO> selectParamInfoByColumn(CommParamInfo commParamInfo) {
		List<CommParamInfoDTO> list=commParamInfoMapper.selectParamInfoByColumn(commParamInfo);
		
		return list;
	}
	/**
	 * 更新参数信息
	 */
	public int updateParamInfoByPrimaryKey(int userId,String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
		CommParamInfo commParamInfo = null;
		try {
			commParamInfo = objectMapper.readValue(data, CommParamInfo.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i=0;
		if(commParamInfo!=null){
			try {
				commParamInfo.setUpdateBy(userId);
				i=commParamInfoMapper.updateParamInfoByPrimaryKey(commParamInfo);
				
			} catch (Exception e) {
				throw new ErrorCodeException(CommonServiceHttpCode.UPDATE_FAILED);
			}
		}
		return i;
	}
	/**
	 * 查询参数信息是否存在
	 */
	public int queryByParamInfoInfoIsExist(CommParamInfo commParamInfo) {
		return commParamInfoMapper.queryByParamInfoInfoIsExist(commParamInfo);
	}
	/**
	 * 根据id查询该对象信息
	 */
	public CommParamInfoDTO selectParamInfoById(int id) {
		CommParamInfoDTO commParamInfoDTO=commParamInfoMapper.selectParamInfoById(id);
		if(!commParamInfoDTO.paramType.equals("")){
		//查询参数类型名称	
		List<CommParamTypeDTO> list=commParamTypeMapper.selDatasByCodes("'"+commParamInfoDTO.paramType+"'");
			if(list.size()>0){
				commParamInfoDTO.typeName=list.get(0).typeName;
			}	
		
		}
		//获取公司信息
		if(commParamInfoDTO.companyId!=0 && commParamInfoDTO.companyId!=100){
			String name="";
			Company comp;
			try {
				comp=companyService.selectById(commParamInfoDTO.companyId);
				if(comp!=null){
					commParamInfoDTO.companyIdDis=comp.getCompName();
				}
			} catch (Exception e) {
				name="";
			}
		}
		
		return commParamInfoDTO;
	}
	public List<CommParamInfoDTO> selDataListByCodes(int types,
			String selList) {
		List<CommParamInfoDTO> comlist=commParamInfoMapper.selDataListByCodes(types,selList);
		return comlist;
	}
	public List<String> getTableSelectvl(int userId, String selids) {
		List<String> headList=new ArrayList<String>();
		String selval="";
		CommParamInfo compinf=new CommParamInfo();
		compinf.setParamType(selids);
		List<CommParamInfoDTO> comResp=commParamInfoMapper.selectParamInfoByColumn(compinf);
		for (int i = 0; i < comResp.size(); i++) {
			selval=selval+"{nid:'"+comResp.get(i).paramType+"',vid:'"+comResp.get(i).paramCode+"',vstr:'"+comResp.get(i).paramName+"'},";
		}
		//selval=selval.substring(0, selval.length()-1);
		selval="["+selval+"]";
		headList.add(0,selval);
		return headList;
	}
	public ArrayList<String> getTableSelectvl(int selid, int userid, int seltype) {
		ArrayList<String> headList=new ArrayList<String>(); 
		//id根据自己模块的对应  但是必须与字段表配置的一致
		if(selid==3001){
			//获取参数类型表头
			String clStr="id,参数名称";//,{name:'strVlb',type:'2',selid:'2000'},{name:'strVlc',type:'3',selid:'1000'}
			String clname="[{name:'id'},{name:'strVla',type:'1',selid:'0'}]";
			headList.add(0,clStr);
			headList.add(1,clname);
		}else if(selid==3002){
			//获取参数类型表头
			String clStr="id,参数名称";//,{name:'strVlb',type:'2',selid:'2000'},{name:'strVlc',type:'3',selid:'1000'}
			String clname="[{name:'id'},{name:'strVla',type:'1',selid:'0'}]";
			headList.add(0,clStr);
			headList.add(1,clname);
		}
		return headList;
		
	}
	public PubForIdselobjRespDTO getForIdselData(
			PageParameter pager,PubForIdselobj pubForIdselobj) {
		ArrayList<PubForIdselobj> rtpub=new ArrayList<PubForIdselobj>();
		/*if(pubForIdselobj.id==3001){
			//获取参数数据
			CommParamType commParamType=new CommParamType();
			ArrayList<CommParamTypeResp> arlis=commParamTypeMapper.selectParamTypeByColumn(pager,commParamType);
			for (int i = 0; i < arlis.size(); i++) {
				PubForIdselobj puobj=new PubForIdselobj();
				puobj.id=arlis.get(i).id;
				puobj.strVla=arlis.get(i).typeName;
				rtpub.add(puobj);
			}			 
		}else if(pubForIdselobj.id==3002){
			//获取参数数据
			CommCity commCity=new CommCity();
			ArrayList<CommCityResp> arlis=commCityMapper.selectAllCityListByColumn(pager,commCity);
			for (int i = 0; i < arlis.size(); i++) {
				PubForIdselobj puobj=new PubForIdselobj();
				puobj.id=arlis.get(i).id;
				puobj.strVla=arlis.get(i).provCityName;
				rtpub.add(puobj);
			}			 
		}
		PubForIdselobjRespDTO pubDto=new PubForIdselobjRespDTO();
		pubDto.rows=rtpub;
		pubDto.total=pager.getTotalPage();
		pubDto.records=pager.getTotalCount();
		return pubDto;*/
		PubForIdselobjRespDTO pubForIdselobjRespDTO=new PubForIdselobjRespDTO();
		return pubForIdselobjRespDTO;
	}
	public String getForIdselName(int selId, int userId, int selVal) {
		String rtStr="";
		try {
			if(selId==3001){
				//获取城市名称
				return commParamTypeMapper.selectParamTypeById(selVal).typeName;
			}else if(selId==3002){
				//获取城市名称
				return commCityMapper.selectCityById(selVal).cityName;
			}
			else{
				return rtStr;
			}
		} catch (Exception e) {
			return rtStr;
		}
	}
	public CommParamInfoPageDTO selectParamInfo(PageParameter pager,CommParamInfo commParamInfo,String types) {
		List<CommParamInfoDTO> list=commParamInfoMapper.selectParamInfoPage(pager,commParamInfo);
	if(!"1".equals(types)){
			String paramIds="";
			for (int i = 0; i < list.size(); i++) {
				paramIds=paramIds+"'"+list.get(i).paramType+"',";
				/*if(list.get(i).companyId!=0 && list.get(i).companyId!=100){
					list.get(i).companyIdDis=companyAgwService.selectById(list.get(i).companyId).compName;
				}*/
			}
			if (paramIds.length()>0) {
				paramIds=paramIds.substring(0, paramIds.length()-1);
				List<CommParamTypeDTO> typeList= commParamTypeMapper.selDatasByCodes(paramIds);
				for (int i = 0; i < list.size(); i++) {
					for(int j=0;j<typeList.size();j++){
						//System.out.println("typeid="+list.get(i).paramType+"===="+typeList.get(j).id);
						if(list.get(i).paramType.equals((typeList.get(j).typeCode))){
							//System.out.println(1);
							list.get(i).paramType=typeList.get(j).typeName;
							break;
						}
					}
				}
			}
			
		}
	CommParamInfoPageDTO commParamInfoRespDTO=new CommParamInfoPageDTO();
	commParamInfoRespDTO.rows=list;
	commParamInfoRespDTO.page = pager.getCurrentPage();
	commParamInfoRespDTO.total=pager.getTotalPage();
	commParamInfoRespDTO.records=pager.getTotalCount();
	return commParamInfoRespDTO;
	}
	public int deleteParamInfoByType(String ids) {
		return commParamInfoMapper.deleteParamInfoByType(ids);
	}
}
