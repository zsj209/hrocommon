package com.hrocloud.common.api;

import java.util.List;

import com.hrocloud.common.dto.CommBankInstitutionDTO;
import com.hrocloud.common.model.CommBankInstitution;
import com.hrocloud.common.model.CommBankInstitutionResp;
import com.hrocloud.common.page.PageParameter;

public interface CommBankInstitutionService {
	/**
	 * 根据一组ids删除机构信息
	 * @param ids
	 * @return
	 */
    int deleteBatchByIds(String ids);

    /**
     * 添加机构信息
     * @param bankInstitution
     * @return
     */
    int insertBank(int userId,String data);

    /**
     * 根据id查询机构信息
     * @param id
     * @return
     */
    CommBankInstitutionDTO selectBanks(PageParameter pager,CommBankInstitution bankInstitution);

    /**
     * 根据一组id查询机构信息
     * @param id
     * @return
     */
    List<CommBankInstitutionResp> selectBanksByIds(String ids);

    /**
     * 查询机构信息
     * @param id
     * @return
     */
    CommBankInstitutionResp selectByBankId(Integer id);
    /**
     * 修改机构信息
     * @param bankInstitution
     * @return
     */
    int updateByBankId(int userId,String data);
    
}
