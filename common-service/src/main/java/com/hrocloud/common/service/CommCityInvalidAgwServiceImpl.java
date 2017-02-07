package com.hrocloud.common.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hrocloud.apigw.client.annoation.ApiParameter;
import com.hrocloud.apigw.client.dubboext.DubboExtProperty;
import com.hrocloud.common.api.CommCityInvalidAgwService;
import com.hrocloud.common.api.CommCityInvalidService;
import com.hrocloud.common.dao.CommCityInvalidMapper;
import com.hrocloud.common.dto.CommCityInvalidDTO;
import com.hrocloud.common.dto.CommCityInvalidPageDTO;
import com.hrocloud.common.exception.CommonServiceHttpCode;
import com.hrocloud.common.exception.ErrorCodeException;
import com.hrocloud.common.model.CommCityInvalid;
import com.hrocloud.common.page.PageParameter;

@Service("commCityInvalidAgwService")
public class CommCityInvalidAgwServiceImpl implements CommCityInvalidAgwService {
	private final static Logger logger = LoggerFactory
			.getLogger(CommCityInvalidAgwServiceImpl.class);

	@Resource
	private CommCityInvalidService commCityInvalidService;

	@Autowired
	private CommCityInvalidMapper commCityInvalidMapper;

	public List<CommCityInvalidDTO> getInvalidCityForSet(String rootcompanyid,
			String curcompanyid) {

		if (StringUtils.isEmpty(rootcompanyid)
				|| StringUtils.isEmpty(curcompanyid)) {
			logger.error("rootcompanyid or curcompanyid is null.");
			DubboExtProperty
					.setErrorCode(CommonServiceHttpCode.PARAMETER_ERROR);
			return null;
		}

		try {
			Integer.parseInt(rootcompanyid);
			Integer.parseInt(curcompanyid);
		} catch (Exception e) {
			logger.error("rootcompanyid or curcompanyid is not int.");
			DubboExtProperty
					.setErrorCode(CommonServiceHttpCode.PARAMETER_ERROR);
			return null;
		}

		try {

			List<CommCityInvalid> list = commCityInvalidService
					.getInvalidCityForSet(Integer.parseInt(rootcompanyid),
							Integer.parseInt(curcompanyid));
			if (list != null) {
				List<CommCityInvalidDTO> listdto = new ArrayList<CommCityInvalidDTO>();
				for (int i = 0; i < list.size(); i++) {
					CommCityInvalid ctinbean = list.get(i);
					CommCityInvalidDTO ctindto = new CommCityInvalidDTO();
					ctindto.id = ctinbean.getId();
					ctindto.companyId = ctinbean.getCompanyId();
					ctindto.cityId = ctinbean.getCityId();
					ctindto.cityCode = ctinbean.getCityCode();
					ctindto.CityName = ctinbean.getCityName();
					ctindto.cityPid = ctinbean.getCityPid();
					ctindto.cityPcode = ctinbean.getCityPcode();
					ctindto.sublist = ctinbean.getSublist();
					ctindto.setstyle = ctinbean.getSetstyle();
					listdto.add(ctindto);
				}
				return listdto;
			} else {
				return null;
			}
		} catch (ErrorCodeException e) {
			DubboExtProperty.setErrorCode(e.getAgwErrorCode());
			return null;
		} catch (Exception e) {
			logger.error("getInvalidCityForSet exception: " + e.getStackTrace());
			DubboExtProperty
					.setErrorCode(CommonServiceHttpCode.COMMON_EXCEPTION);
			return null;
		}
	};

	public boolean saveInvalidCity(String userId, String rootcompanyid,
			String curcompanyid, String cityids) {
		try {
			Integer.parseInt(rootcompanyid);
			Integer.parseInt(curcompanyid);
			Integer.parseInt(userId);
		} catch (Exception e) {
			logger.error("userId, rootcompanyid or curcompanyid is not int.");
			DubboExtProperty
					.setErrorCode(CommonServiceHttpCode.PARAMETER_ERROR);
			return false;
		}

		if (StringUtils.isEmpty(cityids)) {
			logger.error("cityids is null.");
			DubboExtProperty.setErrorCode(CommonServiceHttpCode.CITYIDS_ISNULL);
			return false;
		}

		try {
			return commCityInvalidService.saveInvalidCity(
					Integer.parseInt(userId), Integer.parseInt(rootcompanyid),
					Integer.parseInt(curcompanyid), cityids);
		} catch (ErrorCodeException e) {
			DubboExtProperty.setErrorCode(e.getAgwErrorCode());
			return false;
		} catch (Exception e) {
			logger.error("getInvalidCityForSet exception: " + e.getStackTrace());
			DubboExtProperty
					.setErrorCode(CommonServiceHttpCode.COMMON_EXCEPTION);
			return false;
		}
	}

	public CommCityInvalidPageDTO selectInvalCityList(String companyid,
			String cityname, int rows, int page) {

		try {
			Integer.parseInt(companyid);
		} catch (Exception e) {
			logger.error("companyid is not int.");
			DubboExtProperty
					.setErrorCode(CommonServiceHttpCode.PARAMETER_ERROR);
			return null;
		}
		try {
			PageParameter pager = new PageParameter();
			pager.setPageSize(rows);
			pager.setCurrentPage(page);

			List<CommCityInvalid> list = commCityInvalidMapper
					.selectInvalCityListPage(pager, cityname,
							Integer.valueOf(companyid));
			List<CommCityInvalidDTO> listdto = null;
			if (list != null) {
				listdto = new ArrayList<CommCityInvalidDTO>();
				for (int i = 0; i < list.size(); i++) {
					CommCityInvalid ctinbean = list.get(i);
					CommCityInvalidDTO ctindto = new CommCityInvalidDTO();
					ctindto.id = ctinbean.getId();
					ctindto.companyId = Integer.valueOf(companyid);
					ctindto.cityId = ctinbean.getCityId();
					ctindto.cityCode = ctinbean.getCityCode();
					ctindto.CityName = ctinbean.getCityName();
					listdto.add(ctindto);
				}
			}
			CommCityInvalidPageDTO cityinvalidpageDTO = new CommCityInvalidPageDTO();
			cityinvalidpageDTO.rows = listdto;
			cityinvalidpageDTO.page = pager.getCurrentPage();
			cityinvalidpageDTO.total = pager.getTotalPage();
			cityinvalidpageDTO.records = pager.getTotalCount();

			return cityinvalidpageDTO;
		} catch (Exception e) {
			logger.error("selectInvalCityList exception: " + e.getStackTrace());
			DubboExtProperty
					.setErrorCode(CommonServiceHttpCode.COMMON_EXCEPTION);
			return null;
		}
	}
}
