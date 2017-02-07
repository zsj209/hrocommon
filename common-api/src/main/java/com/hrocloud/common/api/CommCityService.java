package com.hrocloud.common.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hrocloud.common.dto.CommCityRespDTO;
import com.hrocloud.common.model.CommCity;
import com.hrocloud.common.model.CommCityResp;
import com.hrocloud.common.model.CommParamType;
import com.hrocloud.common.page.PageParameter;

/**
 * 
 * Created by zfy on 2016/12/7.
 * 省份城市接口
 */
public interface CommCityService {
	/**
	 * 根据id 删除省份城市
	 * @param ids
	 * @return
	 */
	int deleteCityByPrimaryKey(String ids);
	
	/**
	 * 添加省份城市
	 * @param data
	 * @return
	 */
    int insertCity(int userId,String data);
    /**
     * 根据id 返回省份城市信息
     * @param
     * @return
     */
    CommCityRespDTO selectCityListByColumn(PageParameter page,CommCity commCity);
  
    /**
     *更新省份城市信息
     * @param
     * @return
     */
    
    int updateCityByPrimaryKey(int userId,String data);
    /**
     * 递归城市
     * @param
     * @return
     */
    
    List<CommCityResp> queryTreeCityList(int cityPid);
    
    /**
     * 查询信息是否存在
     * @param
     * @return
     */
    int queryByCityInfoIsExist(String cityCode);
    
    /***
     * 根据id查询城市信息
     */
    CommCityResp selectCityById(Integer id);
    
    ArrayList<CommCityResp> selDataListByIds(String selList);
    
    /***
     * 点击树节点展开的城市
     */
    CommCityRespDTO selectAllCityListByColumn(PageParameter page, int id, String cityCode,String provCityName, String cityPid,
			String cityType,int types);
    /**
     * 根据id获取下级所有节点
     * @param id
     * @return
     */
    List<Integer> selectChlidrenById(int id);
    /***
     * 根据cityCode查询所有信息
     */
    List<CommCityResp> queryChlidrenById(int cityPid);
}
