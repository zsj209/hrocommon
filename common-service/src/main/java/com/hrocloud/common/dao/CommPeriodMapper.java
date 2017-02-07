package com.hrocloud.common.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hrocloud.common.model.CommPeriod;
import com.hrocloud.common.model.CommPeriodResp;
import com.hrocloud.common.page.PageParameter;

public interface CommPeriodMapper {
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
    int deletePeriod(@Param("ids") String ids);

    /**
     * 添加
     * @param commPeriod
     * @return
     */
    int insertPeriod(CommPeriod commPeriod);
    
    /**
     * 添加
     * @param commPeriod
     * @return
     */
    int insertPeriodSelective(CommPeriod commPeriod);

    /**
     * 根据期间查询期间信息
     * @param commPeriod
     * @return
     */
    ArrayList<CommPeriodResp> selectPeriodByColumnPage(@Param("page")PageParameter pager,@Param("commPeriod") CommPeriod commPeriod);
    
    /**
     * 更新期间信息
     * @param commPeriod
     * @return
     */
    int updatePeriodByPrimaryKeySelective(CommPeriod commPeriod);

    /**
     * 更新期间信息
     * @param commPeriod
     * @return
     */
    int updatePeriodByPrimaryKey(CommPeriod commPeriod);
    
    /**
     * 判断信息是否存在
     * @param commPeriod
     * @return
     */
    int queryByPeriodInfoIsExist(CommPeriod commPeriod);
    
    ArrayList<CommPeriodResp> selDataListByIds(@Param("selList") String selList);
    
    CommPeriodResp selectPeriodById(Integer id);
}