package com.ld.jwt.model;

import java.util.Date;

public class PhoneModel {

	private Long id;
	private Integer isPrimary;
	private Integer type;
    private String phone;
    private Date updatedAt;
    private Date createdAt;
    private Integer lastModifiedBy;
	
    public PhoneModel() {}

	public PhoneModel(Long id, Integer isPrimary, Integer type, String phone, Date updatedAt, Date createdAt,
			Integer lastModifiedBy) {
		super();
		this.id = id;
		this.isPrimary = isPrimary;
		this.type = type;
		this.phone = phone;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.lastModifiedBy = lastModifiedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Integer isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

}
