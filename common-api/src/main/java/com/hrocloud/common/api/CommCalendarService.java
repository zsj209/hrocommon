package com.hrocloud.common.api;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.dubbo.config.support.Parameter;
import com.hrocloud.common.dto.CommCalendarRespDTO;
import com.hrocloud.common.model.CommCalendar;
import com.hrocloud.common.model.CommCalendarResp;
import com.hrocloud.common.page.PageParameter;

/**
 * 
 * Created by zfy on 2016/12/8.
 * 公共类日历接口
 */
public interface CommCalendarService {
	/**
	 * 根据id 删除日历
	 * @param ids
	 * @return
	 */
	int deleteCalendar(String ids);

	/**
	 * 添加日历
	 * @param data
	 * @return
	 */
    int insertCalendar( int userId,String data);
    
    /**
     * 根据id 返回日历信息
     * @param
     * @return
     */
    CommCalendarRespDTO selectCalendarByColumn(PageParameter pager,CommCalendar commCalendar);
  
    /**
     *更新日历信息
     * @param data
     * @return
     */
    
    int updateCalendarByPrimaryKey( int userId,String data);
    
    /**
     * 判断信息是否存在
     * @param commCalendar
     * @return
     */
    int queryByCalendarInfoIsExist(CommCalendar commCalendar);
	 /**
     * 根据id日历信息
     * @param selList
     * @return
     */
    ArrayList<CommCalendarResp> selDataListByIds( String selList);
    
    CommCalendarResp selectCalendarById(Integer id);
}
