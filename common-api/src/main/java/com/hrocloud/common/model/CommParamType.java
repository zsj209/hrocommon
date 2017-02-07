package com.hrocloud.common.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.hrocloud.apigw.client.annoation.Description;
import com.hrocloud.common.api.model.BaseObj;
/**
 * 
 * Created by zfy on 2016/12/7.
 * 公共参数类型表
 */

public class CommParamType implements Serializable {
	    /**
		 * 序列化
		 */
		private static final long serialVersionUID = -2336497969920659378L;

		private String typeCode;
		
		private String typeName;

	    private String typeIsupdate;

	    private String comment;

	    private int companyId;

		private Integer id;

	    private Integer createBy;

	    private Date createTime;

	    private Integer updateBy;

	    private Date updateTime;

		public String getTypeCode() {
			return typeCode;
		}

		public void setTypeCode(String typeCode) {
			this.typeCode = typeCode;
		}

		public String getTypeName() {
			return typeName;
		}

		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}

		public String getTypeIsupdate() {
			return typeIsupdate;
		}

		public void setTypeIsupdate(String typeIsupdate) {
			this.typeIsupdate = typeIsupdate;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public int getCompanyId() {
			return companyId;
		}

		public void setCompanyId(int companyId) {
			this.companyId = companyId;
		}
		
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
	    
}