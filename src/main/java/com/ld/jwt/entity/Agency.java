package com.ld.jwt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@SQLDelete(sql="update agency set status = 0 where id=?")
@Where(clause = "status !=0")
public class Agency {

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "AGENCY_NAME", length = 50)
    @NotNull
    private String agency_name;
    
	@OneToMany(mappedBy="agency", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<User> user = new ArrayList<>();
	
	@OneToMany(mappedBy="agency", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Authority> role = new ArrayList<>();
    
    @Column(name = "status", columnDefinition="INT(1) COMMENT '0 - Deleted, 1 - Active, 2 - Pending, 3 - In-active'")
    private Integer status;
    
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
    
    @Column(name = "phone1", length = 10)
    private String phone1;
    
    @Column(name = "phone2", length = 10)
    private String phone2;
    
    @Column(name="created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
    @CreatedDate
    private Date createdAt;

    @Column(name="updated_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
    @LastModifiedDate
    private Date updatedAt;
    
    @LastModifiedBy
    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;

	public Agency() {}

	public Agency(Integer id, @NotNull String agency_name, List<User> user, List<Authority> role, Integer status,
			String address1, String address2, String city, String country, String state, String zip, String phone1,
			String phone2, Date createdAt, Date updatedAt, Integer lastModifiedBy) {
		super();
		this.id = id;
		this.agency_name = agency_name;
		this.user = user;
		this.role = role;
		this.status = status;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.country = country;
		this.state = state;
		this.zip = zip;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.lastModifiedBy = lastModifiedBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgency_name() {
		return agency_name;
	}

	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Authority> getRole() {
		return role;
	}

	public void setRole(List<Authority> role) {
		this.role = role;
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

	@Override
	public String toString() {
		return "Agency [id=" + id + ", agency_name=" + agency_name + ", status="
				+ status + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", country="
				+ country + ", state=" + state + ", zip=" + zip + ", phone1=" + phone1 + ", phone2=" + phone2
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", lastModifiedBy=" + lastModifiedBy + "]";
	}

}
