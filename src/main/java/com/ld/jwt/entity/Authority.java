package com.ld.jwt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.ld.jwt.entity.Agency;
import com.ld.jwt.entity.Authority;

@Entity
@Table(name = "AUTHORITY")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	   
   	@Column(name = "NAME", length = 50)
   	@NotNull
   	private String name;
   
    @Column(name = "description", length = 200)
    @NotNull
    private String description;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="agency_id")
	private Agency agency;
    
    @ManyToMany
    @JoinTable(name="role_permissions",
    joinColumns = @JoinColumn(name = "authority_id"),
    inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions = new ArrayList<>();
    
    @Column(name = "status", columnDefinition="INT(1) COMMENT '0 - Deleted, 1 - Active'")
    private Integer status;
    
    @Column(name="createdAt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
    private Date createdAt;

    @Column(name="updatedAt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
    private Date updatedAt;
    
    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;

   public Authority() {}
   

   public Authority(Integer id, @NotNull String name, @NotNull String description, Agency agency,
		List<Permission> permissions, Integer status, Date createdAt, Date updatedAt, Integer lastModifiedBy) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.agency = agency;
	this.permissions = permissions;
	this.status = status;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
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
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Authority authority = (Authority) o;
      return name == authority.name;
   }

   @Override
   public int hashCode() {
      return Objects.hash(name);
   }


@Override
public String toString() {
	return "Authority [id=" + id + ", name=" + name + ", description=" + description + ", agency=" + agency
			+ ", permissions=" + permissions + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt="
			+ updatedAt + ", lastModifiedBy=" + lastModifiedBy + "]";
}


}
