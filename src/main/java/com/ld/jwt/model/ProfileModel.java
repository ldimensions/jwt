package com.ld.jwt.model;

import java.util.Date;

public class ProfileModel {
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private Date updatedAt;
	private Integer lastModifiedBy;
	
	public ProfileModel() {}

	public ProfileModel(String firstName, String middleName, String lastName, String email, Date updatedAt,
			Integer lastModifiedBy) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.updatedAt = updatedAt;
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
}
