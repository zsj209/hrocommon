package com.hrocloud.common.api;

import java.util.ArrayList;
import java.util.List;








import org.apache.ibatis.annotations.Param;

import com.hrocloud.common.dto.CommParamTypeDTO;
import com.hrocloud.common.dto.CommParamTypePageDTO;
import com.hrocloud.common.model.CommParamType;
import com.hrocloud.common.page.PageParameter;

/**
 * 
 * Created by zfy on 2016/12/7.
 * 公共系统参数类型接口
 */
public interface CommParamTypeService {
	/**
	 * 根据id 删除公共参数类型表
	 * @param id
	 * @return
	 */
	int deleteParamType(String ids);
	
	/**
	 * 添加公共参数类型表
	 * @param commParamType
	 * @return
	 */
	
    int insertParamType(int userId,String data);
    /**
     * 根据id 返回公共参数类型表信息
     * @param id
     * @return
     */
    
    CommParamTypePageDTO selectParamTypeByColumn(PageParameter pager,CommParamType commParamType);
  
    /**
     *更新共参数类型信息
     * @param commParamType
     * @return
     */
    
    int updateParamTypeByPrimaryKey(int userId,String data);
    
    /**
     * 查询信息是否存在
     * @param commParamType
     * @return
     */
    int queryByParamTypeInfoIsExist(CommParamType commParamType);
    /**
     * 根据id查询对象
     */
    CommParamTypeDTO selectParamTypeById(Integer id);
    
    public List<String> getTableHead(int userId,int funId,int stype);
    
    /**
     * 根据一组参数id参考信息
     * @param selList
     * @return
     */
    List<CommParamTypeDTO> selDataListByIds(String selList);
    
    List<CommParamTypeDTO> selDatasByCodes(@Param("selList") String selList);
   
}
