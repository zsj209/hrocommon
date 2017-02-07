package com.hrocloud.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hrocloud.common.model.CommCityInvalid;
import com.hrocloud.common.page.PageParameter;

public interface CommCityInvalidMapper {
	/**
	 * 查询开通城市信息，用于设置开通城市
	 * 
	 * @param root_company_id
	 *            Integer 标准城市所属公司
	 * @param cur_company_id
	 *            Integer 当前城市
	 * @return
	 */
	List<CommCityInvalid> selectInvalidCityForSet(Map<String, Integer> map);

	int saveInvalidCity(Map<String, Object> map);

	int deleteNotExistInvalidCity(Map<String, Object> map);

	List<CommCityInvalid> selectInvalCityListPage(@Param("page") PageParameter pageInfo,@Param("cityname") String cityname, @Param("companyid") int companyid);
}