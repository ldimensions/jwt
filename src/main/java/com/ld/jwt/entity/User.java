package com.ld.jwt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ld.jwt.entity.Address;
import com.ld.jwt.entity.Agency;
import com.ld.jwt.entity.Phone;
import com.ld.jwt.entity.Authority;

@Entity
@SQLDelete(sql="update user set status = 0 where id=?")
@Where(clause = "status !=0")
public class User {
	
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
   @Column(name = "userName", length = 50, unique = true, updatable = false)
   @NotNull
   @Size(min = 4, max = 50)
   private String userName;

   @Column(name = "password", length = 100)
   @Size(min = 4, max = 100)
   private String password;

   @Column(name = "firstName", length = 50)
   @NotNull
   @Size(min = 4, max = 50)
   private String firstName;
   
   @Column(name = "middleName", length = 50)
   private String middleName;

   @Column(name = "lastName", length = 50)
   @NotNull
   @Size(min = 4, max = 50)
   private String lastName;

   @Column(name = "email", length = 50)
   @NotNull
   @Size(min = 4, max = 50)
   private String email;

   @Column(name = "isActivated")
   @NotNull
   private Integer isActivated;
   
   @Column(name = "status", columnDefinition="INT(1) COMMENT '0 - Deleted, 1 - Active, 2 - Pending, 3 - In-active'")
   private Integer status;
	
   @Column(name="createdAt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
   private Date createdAt;

   @Column(name="updatedAt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
   private Date updatedAt;
   
   @Column(name = "lastModifiedBy")
   private Integer lastModifiedBy;
	
   @ManyToOne(fetch=FetchType.LAZY)
   private Agency agency;
   
   @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
   @JsonManagedReference
   private List<Address> address = new ArrayList<>();
   
   @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
   @JsonManagedReference
   private List<Phone> phone = new ArrayList<>();
   
   @ManyToMany
   @JoinTable(
      name = "USER_AUTHORITY",
      joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
      inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")}
   )
   
   @BatchSize(size = 20)
   private Set<Authority> authorities = new HashSet<>();
	
   public User() {}

public User(Long id, @NotNull @Size(min = 4, max = 50) String userName, @Size(min = 4, max = 100) String password,
		@NotNull @Size(min = 4, max = 50) String firstName, String middleName,
		@NotNull @Size(min = 4, max = 50) String lastName, @NotNull @Size(min = 4, max = 50) String email,
		@NotNull Integer isActivated, Integer status, Date createdAt, Date updatedAt, Integer lastModifiedBy,
		Agency agency, List<Address> address, List<Phone> phone, Set<Authority> authorities) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.email = email;
	this.isActivated = isActivated;
	this.status = status;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.lastModifiedBy = lastModifiedBy;
	this.agency = agency;
	this.address = address;
	this.phone = phone;
	this.authorities = authorities;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
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

public Integer getIsActivated() {
	return isActivated;
}

public void setIsActivated(Integer isActivated) {
	this.isActivated = isActivated;
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

public Agency getAgency() {
	return agency;
}

public void setAgency(Agency agency) {
	this.agency = agency;
}

public List<Address> getAddress() {
	return address;
}

public void setAddress(List<Address> address) {
	this.address = address;
}

public List<Phone> getPhone() {
	return phone;
}

public void setPhone(List<Phone> phone) {
	this.phone = phone;
}

public Set<Authority> getAuthorities() {
	return authorities;
}

public void setAuthorities(Set<Authority> authorities) {
	this.authorities = authorities;
}

   
	

}
