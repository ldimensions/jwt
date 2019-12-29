package com.ld.jwt.model;

import java.util.Date;

public class AgencyModel {
	
	private Integer id;
    private String agencyName;
    private Integer status;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String state;
    private String zip;
    private String phone1;
    private String phone2;
    private Date updatedAt;
    private Integer lastModifiedBy;
	
    public AgencyModel() {}

	public AgencyModel(Integer id, String agencyName, Integer status, String address1, String address2, String city,
			String country, String state, String zip, String phone1, String phone2, Date updatedAt,
			Integer lastModifiedBy) {
		super();
		this.id = id;
		this.agencyName = agencyName;
		this.status = status;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.country = country;
		this.state = state;
		this.zip = zip;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.updatedAt = updatedAt;
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date date) {
		this.updatedAt = date;
	}

	public Integer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
