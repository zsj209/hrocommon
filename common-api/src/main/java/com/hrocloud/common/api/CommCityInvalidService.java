package com.hrocloud.common.api;

import java.util.List;

import com.hrocloud.common.exception.BusinessException;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.model.CommCityInvalid;

/**
 * 
 * Created by darren on 2017/1/12. 开通城市接口
 */
public interface CommCityInvalidService {

	/**
	 * 获取城市用于设置开通城市
	 * 
	 * @param rootcompanyid
	 *            Integer 标准城市所属公司
	 * @param curcompanyid
	 *            Integer 当前城市
	 * @return
	 */

	List<CommCityInvalid> getInvalidCityForSet(Integer rootcompanyid,
			Integer curcompanyid) throws ErrorCodeException, BusinessException;

	/**
	 * 保存开通城市
	 * 
	 * @param userId
	 *            Integer 用户ID
	 * @param rootcompanyid
	 *            Integer 标准城市所属公司
	 * @param curcompanyid
	 *            Integer 当前城市
	 * @param cityids
	 *            String 城市IDs, 多个逗号隔开
	 * @return
	 */
	boolean saveInvalidCity(Integer userId, Integer rootcompanyid,
			Integer curcompanyid, String cityids) throws ErrorCodeException,
			BusinessException;

}
