package com.hrocloud.common.model;

import java.io.Serializable;
import java.util.Date;

import com.hrocloud.common.api.model.BaseObj;
/**
 * 
 * Created by zfy on 2016/12/7.
 * 公共日历表
 */
public class CommCalendar extends BaseObj implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -514205633648083500L;

	private Integer id;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    private Byte deleteFlag;

    private Integer importFlag;

    private Integer companyId;

    private String calCode;

    private String calDate;

    private String calType;

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

    public String getCalCode() {
        return calCode;
    }

    public void setCalCode(String calCode) {
        this.calCode = calCode == null ? null : calCode.trim();
    }

    public String getCalDate() {
        return calDate;
    }

    public void setCalDate(String calDate) {
        this.calDate = calDate;
    }

    public String getCalType() {
        return calType;
    }

    public void setCalType(String calType) {
        this.calType = calType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}