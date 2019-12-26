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
@SQLDelete(sql="update phone set status = 0 where id=?")
@Where(clause = "status !=0")
public class Phone {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	private User user;

	@Column(name = "is_primary", columnDefinition="INT(1) COMMENT '0 - Secondary, 1 - Primary'")
	private Integer isPrimary;

	@Column(name = "type", columnDefinition="INT(1) COMMENT '0 - Personel, 1 - Home, 2 - Office'")
	private Integer type;
	
    @Column(name = "phone", length = 20)
    private String phone;
  
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

	public Phone() {}

	public Phone(Long id, User user, Integer isPrimary, Integer type, String phone, Integer status, Date createdAt,
			Date updatedAt, Integer lastModifiedBy) {
		super();
		this.id = id;
		this.user = user;
		this.isPrimary = isPrimary;
		this.type = type;
		this.phone = phone;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.lastModifiedBy = lastModifiedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
}
