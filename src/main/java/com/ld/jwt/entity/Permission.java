package com.ld.jwt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@SQLDelete(sql="update permission set status = 0 where id=?")
@Where(clause = "status !=0")
public class Permission {

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "PERMISSION_NAME", length = 50)
    @NotNull
    private String permissionName;
    
    @ManyToMany(mappedBy="permissions")
    private List<Authority> authority = new ArrayList<>();
    
    @Column(name = "description", length = 200)
    private String description;
    
    @Column(name = "status", columnDefinition="INT(1) COMMENT '0 - Deleted, 1 - Active'")
    private Integer status;
    
    @Column(name="created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
    @CreatedDate
    private Date createdAt;

    @Column(name="updated_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
    @LastModifiedDate
    private Date updatedAt;
    
    @LastModifiedBy
    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;

	public Permission() {}

	public Permission(Long id, @NotNull String permissionName, List<Authority> authority, String description,
			Integer status, Date createdAt, Date updatedAt, Integer lastModifiedBy) {
		super();
		this.id = id;
		this.permissionName = permissionName;
		this.authority = authority;
		this.description = description;
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

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public String toString() {
		return "Permission [id=" + id + ", permissionName=" + permissionName + "]";
	}
	
	


}
