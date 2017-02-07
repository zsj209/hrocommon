package com.hrocloud.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hrocloud.common.model.CommBankInstitution;
import com.hrocloud.common.model.CommBankInstitutionResp;
import com.hrocloud.common.page.PageParameter;

public interface CommBankInstitutionMapper {
	/**
	 * 根据一组ids删除机构信息
	 * @param ids
	 * @return
	 */
    int deleteBatchByIds(@Param("ids") String ids);

    /**
     * 添加机构信息
     * @param bankInstitution
     * @return
     */
    int insertBank(CommBankInstitution bankInstitution);

    /**
     * 根据id查询机构信息
     * @param id
     * @return
     */
    List<CommBankInstitutionResp> selectBanksPage(@Param("page") PageParameter pager,@Param("bankInstitution") CommBankInstitution bankInstitution);

    /**
     * 根据一组id查询机构信息
     * @param id
     * @return
     */
    List<CommBankInstitutionResp> selectBanksByIds(@Param("ids") String ids);

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
    int updateByBankId(CommBankInstitution bankInstitution);
    
    /**
     * 判断银行机构是否存在
     * @param bankInstitution
     * @return
     */
    int selectBankIsExist(CommBankInstitution bankInstitution);
}