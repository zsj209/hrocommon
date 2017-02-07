package com.hrocloud.common.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hrocloud.common.dto.CommParamInfoDTO;
import com.hrocloud.common.model.CommParamInfo;
import com.hrocloud.common.page.PageParameter;

public interface CommParamInfoMapper {
	/**
	 * 根据一组ids删除参数信息
	 * @param ids
	 * @return
	 */
    int deleteParamInfo(@Param("ids") String ids);
    /**
     * 根据参数类型删除参数信息
     * @param ids
     * @return
     */
    int deleteParamInfoByType(@Param("ids") String ids);
    /**
     * 添加参数信息
     * @param commParamInfo
     * @return
     */
    int insertParamInfo(CommParamInfo commParamInfo);

    /**
     * 查询参数信息
     * @param commParamInfo
     * @return
     */
     
    List<CommParamInfoDTO> selectParamInfoByColumn(@Param("commParamInfo") CommParamInfo commParamInfo);

    /**
     * 更改参数信息
     * @param record
     * @return
     */
    int updateParamInfoByPrimaryKey(CommParamInfo record);
    
    /**
     * 查询信息是否存在
     * @param commParamInfo
     * @return
     */
    int queryByParamInfoInfoIsExist(CommParamInfo commParamInfo);

    /**
     * 根据id查看参数信息
     * @param id
     * @return
     */
    CommParamInfoDTO selectParamInfoById(int id);
    
    /**
     * selList参数类型id
     * @param selList
     * @return
     */
   List<CommParamInfoDTO> selDataListByCodes(@Param("types") int types,@Param("selList") String selList);
   
    /**
     * 查询参数信息
     * @param page
     * @param commParamInfo
     * @return
     */
    List<CommParamInfoDTO> selectParamInfoPage(@Param("page") PageParameter page,@Param("commParamInfo") CommParamInfo commParamInfo);
}