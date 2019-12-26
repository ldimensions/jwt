package com.ld.jwt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity 
@SQLDelete(sql="update address set status = 0 where id=?")
@Where(clause = "status !=0")
public class Address {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	@Column(name = "is_primary", columnDefinition="INT(1) COMMENT '0 - Secondary, 1 - Primary'")
	private Integer isPrimary;
	
    @Column(name = "address1", length = 50)
    private String address1;
    
    @Column(name = "address2", length = 50)
    private String address2;
    
    @Column(name = "city", length = 25)
    private String city;
    
    @Column(name = "country", length = 25)
    private String country;
    
    @Column(name = "state", length = 20)
    private String state;
    
    @Column(name = "zip", length = 10)
    private String zip;
    
    @Column(name = "status", columnDefinition="INT(1) COMMENT '0 - Deleted, 1 - Active'")
	@JsonIgnore
    private Integer status;
    
    @Column(name="created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	@JsonIgnore
    @CreatedDate
    private Date createdAt;

    @Column(name="updated_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	@JsonIgnore
    @LastModifiedDate
    private Date updatedAt;
    
    @LastModifiedBy
    @Column(name = "last_modified_by")
	@JsonIgnore
    private Integer lastModifiedBy;
    
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	private User user;

	public Address() {}

	public Address(Integer id, Integer isPrimary, String address1, String address2, String city, String country,
			String state, String zip, Integer status, Date createdAt, Date updatedAt, Integer lastModifiedBy,
			User user) {
		super();
		this.id = id;
		this.isPrimary = isPrimary;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.country = country;
		this.state = state;
		this.zip = zip;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.lastModifiedBy = lastModifiedBy;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
