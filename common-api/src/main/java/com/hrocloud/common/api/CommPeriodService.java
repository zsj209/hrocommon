package com.hrocloud.common.api;

import java.util.ArrayList;
import java.util.List;




import com.hrocloud.common.dto.CommPeriodRespDTO;
import com.hrocloud.common.model.CommPeriod;
import com.hrocloud.common.model.CommPeriodResp;
import com.hrocloud.common.page.PageParameter;

/**
 * 
 * Created by zfy on 2016/12/8.
 * 公共类期间接口
 */
public interface CommPeriodService {
	/**
	 * 根据id 删除期间
	 * @param id
	 * @return
	 */
	int deletePeriod(String ids);
	
	/**
	 * 添加期间
	 * @param commPeriod
	 * @return
	 */
    int insertPeriod(int userId,String data);
    
    /**
     * 根据id 返回期间信息
     * @param id
     * @return
     */
    CommPeriodRespDTO selectPeriodByColumn(PageParameter pager,CommPeriod commPeriod);
  
    /**
     *更新期间信息
     * @param commPeriod
     * @return
     */
    
    int updatePeriodByPrimaryKey(int userId,String data);
    /**
     * 判断信息是否存在
     * @param commPeriod
     * @return
     */
    int queryByPeriodInfoIsExist(CommPeriod commPeriod);
    ArrayList<CommPeriodResp> selDataListByIds(String selList);
    
    CommPeriodResp selectPeriodById(Integer id);
}
