package com.ld.jwt.model;

import java.util.Date;

public class AddressModel {
	
	private Long id;
	private Integer isPrimary;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String state;
    private String zip;
    private Date updatedAt;
    private Date createdAt;
    private Integer lastModifiedBy;
    
    public AddressModel() { }

	public AddressModel(Long id, Integer isPrimary, String address1, String address2, String city, String country,
			String state, String zip, Date updatedAt, Integer lastModifiedBy, Date createdAt) {
		super();
		this.id = id;
		this.isPrimary = isPrimary;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.country = country;
		this.state = state;
		this.zip = zip;
		this.updatedAt = updatedAt;
		this.lastModifiedBy = lastModifiedBy;
		this.createdAt = createdAt;
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
	

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "AddressModel [id=" + id + ", isPrimary=" + isPrimary + ", address1=" + address1 + ", address2="
				+ address2 + ", city=" + city + ", country=" + country + ", state=" + state + ", zip=" + zip
				+ ", updatedAt=" + updatedAt + ", lastModifiedBy=" + lastModifiedBy + "]";
	}
	
	
    
}
