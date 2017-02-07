package com.hrocloud.common.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrocloud.common.api.CommCityInvalidService;
import com.hrocloud.common.dao.CommCityInvalidMapper;
import com.hrocloud.common.exception.BusinessException;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.BusinessException;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.model.CommCityInvalid;

@Service("commCityInvalidService")
public class CommCityInvalidServiceImpl implements CommCityInvalidService {
	private final static Logger logger = LoggerFactory
			.getLogger(CommCityInvalidServiceImpl.class);
	@Autowired
	private CommCityInvalidMapper commCityInvalidMapper;

	/**
	 * 获取城市用于设置开通城市
	 * 
	 * @param rootcompanyid
	 *            Integer 标准城市所属公司
	 * @param curcompanyid
	 *            Integer 当前城市
	 * @return
	 */

	public List<CommCityInvalid> getInvalidCityForSet(Integer rootcompanyid,
			Integer curcompanyid) throws ErrorCodeException, BusinessException {
		if (rootcompanyid == 0 || curcompanyid == 0) {
			logger.error("rootcompanyid or curcompanyid is null.");
			throw new ErrorCodeException(CommonServiceHttpCode.PARAMETER_ERROR);
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("root_company_id", rootcompanyid);
		map.put("cur_company_id", curcompanyid);
		try {
			List<CommCityInvalid> listcityInv = commCityInvalidMapper
					.selectInvalidCityForSet(map);
			if (listcityInv == null) {
				logger.error("root city is null.");
				throw new ErrorCodeException(CommonServiceHttpCode.CITY_ISNULL);
			}
			return listcityInv;
		} catch (Exception e) {
			logger.error("get city exception: " + e.getStackTrace());
			throw new BusinessException(
					CommonServiceHttpCode.C_COMMON_EXCEPTION, e.getStackTrace()
							.toString());
		}
	};

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
	public boolean saveInvalidCity(Integer userId, Integer rootcompanyid,
			Integer curcompanyid, String cityids) throws ErrorCodeException,
			BusinessException {
		String[] ctids = cityids.split(",");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userId);
		map.put("curdate", new Date());
		map.put("root_company_id", rootcompanyid);
		map.put("cur_company_id", curcompanyid);
		map.put("cityids", ctids);
		try {
			commCityInvalidMapper.saveInvalidCity(map);
			commCityInvalidMapper.deleteNotExistInvalidCity(map);
			return true;
		} catch (Exception e) {
			logger.error("saveInvalidCity exception: " + e.getStackTrace());
			throw new BusinessException(
					CommonServiceHttpCode.C_COMMON_EXCEPTION, e.getStackTrace()
							.toString());
		}
	};
}
