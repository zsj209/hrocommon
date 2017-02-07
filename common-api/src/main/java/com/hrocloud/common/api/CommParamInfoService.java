package com.hrocloud.common.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hrocloud.common.dto.CommParamInfoDTO;
import com.hrocloud.common.dto.CommParamInfoPageDTO;
import com.hrocloud.common.dto.PubForIdselobjRespDTO;
import com.hrocloud.common.model.CommParamInfo;
import com.hrocloud.common.model.CommCityResp;
import com.hrocloud.common.model.PubForIdselobj;
import com.hrocloud.common.page.PageParameter;

/**
 * 
 * Created by zfy on 2016/12/7.
 * 公共参数信息表接口
 */
public interface CommParamInfoService {
	/**
	 * 根据id 删除省份城市
	 * @param id
	 * @return
	 */
	int deleteParamInfo(String ids);
	
	/**
	 * 添加省份城市
	 * @param commParamInfo
	 * @return
	 */
    int insertParamInfo(int userId,String data);

    public List<CommParamInfoDTO> selectParamInfoByColumn(CommParamInfo commParamInfo);
   
  
    /**
     *更改参数信息
     * @param commParamInfo
     * @return
     */
    
    int updateParamInfoByPrimaryKey(int userId,String data);

    /**
     * 查询信息是否存在
     * @param commParamInfo
     * @return
     */
    int queryByParamInfoInfoIsExist(CommParamInfo commParamInfo);
    
   
    /**
     * 根据id查询参数信息
     */
    CommParamInfoDTO selectParamInfoById(int id);
    
    List<CommParamInfoDTO> selDataListByCodes(int types,String selList);
    
    public List<String> getTableSelectvl(int userId,String selids);
    
    public ArrayList<String> getTableSelectvl(int selid, int userid, int seltype);

	public PubForIdselobjRespDTO getForIdselData(PageParameter pager,PubForIdselobj pubForIdselobj);

	public String getForIdselName(int selId, int userId, int selVal);
	
	CommParamInfoPageDTO selectParamInfo(PageParameter pagePar,CommParamInfo commParamInfo,String types);
	
    int deleteParamInfoByType(@Param("ids") String ids);
}
