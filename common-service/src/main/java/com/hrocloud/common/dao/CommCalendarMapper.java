package com.hrocloud.common.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hrocloud.common.model.CommCalendar;
import com.hrocloud.common.model.CommCalendarResp;
import com.hrocloud.common.page.PageParameter;

public interface CommCalendarMapper {
	/**
	 * 删除日历信息
	 * @param ids
	 * @return
	 */
    int deleteCalendar(@Param("ids") String ids);
    
    /**
     * 插入日历信息
     * @param commCalendar
     * @return
     */
    int insertCalendar(CommCalendar commCalendar);

    /**
     * 根据日历信息查询日历列表
     * @param commCalendar
     * @return
     */
    List<CommCalendarResp> selectCalendarByColumnPage(@Param("page") PageParameter pager,@Param("commCalendar") CommCalendar commCalendar);
    /**
     * 更新日历信息
     * @param commCalendar
     * @return
     */
    int updateCalendarByPrimaryKey(CommCalendar commCalendar);
    /**
     * 判断信息是否存在
     * @param commCalendar
     * @return
     */
    int queryByCalendarInfoIsExist(CommCalendar commCalendar);
    
    /**
     * 根据日历id信息查询日历列表
     * @param commCalendar
     * @return
     */
    ArrayList<CommCalendarResp> selDataListByIds(@Param("selList") String selList);
    
    CommCalendarResp selectCalendarById(Integer id);
    
    
}