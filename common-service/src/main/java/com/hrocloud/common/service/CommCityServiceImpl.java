package com.hrocloud.common.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrocloud.apigw.client.dubboext.DubboExtProperty;
import com.hrocloud.common.api.CommCityService;
import com.hrocloud.common.api.CommParamInfoService;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.dao.CommCityMapper;
import com.hrocloud.common.dto.CommCityRespDTO;
import com.hrocloud.common.dto.CommParamInfoDTO;
import com.hrocloud.common.model.CommCity;
import com.hrocloud.common.model.CommCityResp;
import com.hrocloud.common.page.PageParameter;
@Service("commCityService")
public class CommCityServiceImpl implements CommCityService {
	@Autowired
	private CommCityMapper commCityMapper;
	@Resource
	private CommParamInfoService commParamInfoService;
	/**
	 * 删除城市
	 */
	public int deleteCityByPrimaryKey(String ids) {
		//判断删除的城市有没有下级
		String delIds="";
		CommCity commCity=new CommCity();
		if(ids.length()>0){
			 String []id=ids.split(",");
				for (int i = 0; i < id.length; i++) {
					String string = id[i];
					//查询该城市是否有子节点，若有都不能删除
					 List<CommCityResp> list=commCityMapper.queryChlidrenById(Integer.valueOf(string));
					 if(list.size()>0){
						 for (CommCityResp commCityResp : list) {
							 if (string.equals(commCityResp.cityPid)) {
								 return -3;
							}
						 }
					 }
					
				}
		}
		
		return commCityMapper.deleteCityByPrimaryKey(ids);
	}
	/**
	 * 添加城市
	 */
	public int insertCity(int userId,String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
		CommCity commCity = null;
		try {
			commCity = objectMapper.readValue(data, CommCity.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i=0;
		if(commCity!=null){
				try {
					commCity.setCreateBy(userId);
					//判断该条信息是否存在 存在则插入
					if(commCityMapper.queryByCityInfoIsExist(commCity.getCityCode())<=0){
						i=commCityMapper.insertCity(commCity);
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
	 * 返回城市列表
	 */
	public CommCityRespDTO selectCityListByColumn(PageParameter pager,CommCity commCity) {
		ArrayList<CommCityResp> list=commCityMapper.selectCityListByColumnPage(pager,commCity);
		CommCityRespDTO comm=new CommCityRespDTO();
		comm.rows=list;
		comm.page = pager.getCurrentPage();
		comm.total=pager.getTotalPage();
		comm.records=pager.getTotalCount();
	return comm;
	}
	/**
	 * 更新城市信息
	 */
	public int updateCityByPrimaryKey(int userId,String data) {
		int i=0;
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
		CommCity commCity = null;
		try {
			commCity = objectMapper.readValue(data, CommCity.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(commCity!=null){
			try {
				commCity.setUpdateBy(userId);
				i=commCityMapper.updateCityByPrimaryKey(commCity);
			} catch (Exception e) {
				throw new ErrorCodeException(CommonServiceHttpCode.UPDATE_FAILED);
			}
		}
	
		return i;
	}
	/**
	 * 递归返回城市信息
	 */
	public List<CommCityResp> queryTreeCityList(int cityPid) {
		return commCityMapper.queryTreeCityList(cityPid);
	}
	/**
	 * 判断城市信息是否存在
	 */
	public int queryByCityInfoIsExist(String cityCode) {
		
		return commCityMapper.queryByCityInfoIsExist(cityCode);
	}

	public CommCityResp selectCityById(Integer id) {
		if(id!=0){
			CommCityResp comm=commCityMapper.selectCityById(id);
			if(comm.id!=1000){
				comm.cityPidShow=commCityMapper.selectCityById(Integer.valueOf(comm.cityPid)).cityName;
			}
			return comm;
		}else{
			return null;
		}
		
	}
	public ArrayList<CommCityResp> selDataListByIds(String selList) {
		return commCityMapper.selDataListByIds(selList);
	}
	public CommCityRespDTO selectAllCityListByColumn(PageParameter pager, int id, String cityCode,String cityName, String cityPid,
			String cityType,int types) {
		
		String ids="";
		if(types==1 && id!=0){//获取所属下级id
				List<Integer> list=selectChlidrenById(id);
				if(list.size()>0){
					for (Integer integer : list) {
						ids=ids+integer+",";
					}
					if(ids.length()>0){
						ids=ids.substring(0, ids.length()-1);
					}
				}
				
			
		}else{
			if(id==0){
				ids="";
			}else{
				ids=id+"";
			}
			
		}
		ArrayList<CommCityResp> list=commCityMapper.selectAllCityListByColumnPage(pager, ids, cityCode, cityName, cityPid, cityType, types);
		if(types==1){
			String paramInfoIds="";
			String cityPids="";
			for (int i = 0; i < list.size(); i++) {
				paramInfoIds=paramInfoIds+"'"+list.get(i).cityType+"',";
				cityPids=cityPids+list.get(i).cityPid+",";
			}
			if (paramInfoIds.length()>0) {
				paramInfoIds=paramInfoIds.substring(0, paramInfoIds.length()-1);
				cityPids=cityPids.substring(0, cityPids.length()-1);
				//查询城市类型信息
				List<CommParamInfoDTO> typeList= commParamInfoService.selDataListByCodes(1, paramInfoIds);
				//获取城市信息
				ArrayList<CommCityResp> cityList=commCityMapper.selDataListByIds(cityPids);
				for (int i = 0; i < list.size(); i++) {
					if(typeList.size()>0){
						for(int j=0;j<typeList.size();j++){
							if(list.get(i).cityType.equals((typeList.get(j).paramCode))){
								list.get(i).cityType=typeList.get(j).paramName;
								break;
							}
						}
					}
					if(cityList.size()>0){
						for (int k = 0; k < cityList.size(); k++) {
								if(list.get(i).cityPid.equals(cityList.get(k).id+"")){
									list.get(i).cityPid=cityList.get(k).cityName;
									break;
							}
							
						}
					}
					if(list.get(i).cityPid.equals("0")||list.get(i).cityPid.equals("")){
						list.get(i).cityPid="";
					}
				}
			}
			
		}
		CommCityRespDTO comm=new CommCityRespDTO();
		comm.rows=list;
		comm.page = pager.getCurrentPage();
		comm.total=pager.getTotalPage();
		comm.records=pager.getTotalCount();
	return comm;
	}
	public List<Integer> selectChlidrenById(int id) {
		 List<CommCityResp> list=commCityMapper.queryChlidrenById(id);
		 List<Integer> str=null;
		 try {
			 if(list.size()>0){
				 str=new ArrayList<Integer>();
				 for (CommCityResp commCityResp : list) {
						if(commCityResp.id!=1000){
							str.add(Integer.valueOf(commCityResp.id));
						}
					}
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		/*CommCityResp city=commCityMapper.selectCityById(id);
		String code=city.cityCode;
		
		if(code!=null){
			str=new ArrayList<Integer>();
			List<CommCityResp> list=commCityMapper.queryChlidrenById(code);
			for (CommCityResp commCityResp : list) {
				if(!commCityResp.cityCode.equals("cty001")){
					str.add(commCityResp.id);
				}
			}
		}*/
		return str;
	}
	public List<CommCityResp> queryChlidrenById(int cityPid) {
		return commCityMapper.queryChlidrenById(cityPid);
	}

}
