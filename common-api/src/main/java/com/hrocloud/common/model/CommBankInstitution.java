package com.hrocloud.common.model;

import java.io.Serializable;
import java.util.Date;

import com.hrocloud.common.api.model.BaseObj;

public class CommBankInstitution extends BaseObj implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8116900316460203203L;

	private Integer id;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    private Byte deleteFlag;

    private Integer importFlag;

    private Integer companyId;

    private String bankName;

    private String bankCname;

    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getImportFlag() {
        return importFlag;
    }

    public void setImportFlag(Integer importFlag) {
        this.importFlag = importFlag;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCname() {
        return bankCname;
    }

    public void setBankCname(String bankCname) {
        this.bankCname = bankCname == null ? null : bankCname.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}