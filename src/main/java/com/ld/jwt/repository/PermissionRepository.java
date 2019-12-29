package com.ld.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ld.jwt.entity.Permission;


public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
