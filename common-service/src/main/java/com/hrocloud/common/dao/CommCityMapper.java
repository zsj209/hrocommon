package com.hrocloud.common.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hrocloud.common.model.CommCity;
import com.hrocloud.common.model.CommCityResp;
import com.hrocloud.common.page.PageParameter;
/**
 * 
 * Created by zfy on 2016/12/2.
 * 省份城市
 */
public interface CommCityMapper {
	/**
	 * 根据一组ids删除城市信息
	 * @param ids
	 * @return
	 */
    int deleteCityByPrimaryKey(@Param("ids") String ids);
    /**
     * 添加城市
     * @param commCity
     * @return
     */
    int insertCity(CommCity commCity);
    /**
     * 添加城市
     * @param commCity
     * @return
     */
    int insertCitySelective(CommCity commCity);
    /**
     * 根据城市信息查看城市集合
     * @param commCity
     * @return
     */
    ArrayList<CommCityResp> selectCityListByColumnPage(@Param("page")PageParameter pager,@Param("commCity")CommCity commCity);
    /**
     * 更新城市信息
     * @param commCity
     * @return
     */
    int updateCityByPrimaryKeySelective(CommCity commCity);
    /**
     * 更新城市信息
     * @param commCity
     * @return
     */
    int updateCityByPrimaryKey(CommCity commCity);
    /**
     * 递归城市
     * @param commCity
     * @returnMap<String, Integer> map
     */
    List<CommCityResp> queryTreeCityList(Integer id);
    /**
     * 查询信息是否存在
     * @param commCity
     * @return
     */
    int queryByCityInfoIsExist(String cityCode);
   
    int adderWithParameterMap(CommCity commCity);
    /**
     * 查詢有效的城市
     */
    List<CommCityResp> selectCityValid(CommCity commCity);
    /***
     * 根据id查询城市信息
     */
    CommCityResp selectCityById(Integer id);
    /**
     * 根据id查询城市信息
     * @param selList
     * @return
     */
    ArrayList<CommCityResp> selDataListByIds(@Param("selList") String selList);
    /***
     * 点击树节点展开的城市
     */
    ArrayList<CommCityResp> selectAllCityListByColumnPage(@Param("page")PageParameter pager,@Param("ids") String ids,@Param("cityCode") String cityCode,@Param("cityName") String cityName,@Param("cityPid") String cityPid,@Param("cityType") String cityType,@Param("types") int types);
    
    CommCityResp selectIdByCode(String cityCode);
    
    /**
     * 根据一组code查询城市信息
     * @param selList
     * @return
     */
    ArrayList<CommCityResp> selDataListByCodes(@Param("selList") String selList);
    
    List<CommCityResp> queryChlidrenById(int cityPid);
}