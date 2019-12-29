package com.ld.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ld.jwt.entity.Authority;
import com.ld.jwt.model.RolePermissionModel;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	
	@Query(value = "select a.name, p.permission_name from Authority a "
			+ "left join user_authority ua on ua.authority_id = a.id "
			+ "left join role_permissions rp on rp.authority_id = a.id "
			+ "left join Permission p on p.id = rp.permission_id "
			+ "where ua.user_id = ?1 and a.status = 1 "
			+ "group by a.name, p.permission_name" + 
			"", nativeQuery = true)
	List<RolePermissionModel> getRolePermission(@Param("userId") Long userId);

}
