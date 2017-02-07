package com.hrocloud.common.dao;

import java.util.List;

import javax.annotation.PreDestroy;

import org.apache.ibatis.annotations.Param;

import com.alibaba.dubbo.config.support.Parameter;
import com.hrocloud.common.dto.CommParamTypeDTO;
import com.hrocloud.common.model.CommParamType;
import com.hrocloud.common.page.PageParameter;

public interface CommParamTypeMapper {
	/**
	 * 根据一组ids删除参数类型
	 * @param ids
	 * @return
	 */
    int deleteParamType(@Param("ids") String ids);

    /**
     * 添加参数信息
     * @param commParamType
     * @return
     */
    int insertParamType(CommParamType commParamType);
    /**
     * 
     * @param pager 分页信息
     * @param commParamType 参数类型信息
     * @return
     */
    List<CommParamTypeDTO> selectParamTypeByColumnPage(@Param("page") PageParameter pager,@Param("commParamType") CommParamType commParamType);

    /**
     * 更新参数信息
     * @param commParamType
     * @return
     */
    int updateParamTypeByPrimaryKey(CommParamType commParamType);
    /**
     * 查询信息是否存在
     * @param commParamType
     * @return
     */
    int queryByParamTypeInfoIsExist(CommParamType commParamType);
    
    /**
     * 根据参数id查看参数信息
     * @param id
     * @return
     */
    CommParamTypeDTO selectParamTypeById(Integer id);
    
    /**
     * 根据一组ids查看参数信息
     * @param selList
     * @return
     */
    List<CommParamTypeDTO> selDataListByIds(@Param("selList") String selList);
    
    /**
     * 根据code查询数据
     */
    List<CommParamTypeDTO> selDatasByCodes(@Param("selList") String selList);
}