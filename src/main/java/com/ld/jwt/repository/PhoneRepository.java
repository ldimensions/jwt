package com.ld.jwt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ld.jwt.entity.Phone;
import com.ld.jwt.model.PhoneModel;


public interface PhoneRepository extends JpaRepository<Phone, Long> {

	@Query(value = "select * from Phone p where p.user_id = ?1", nativeQuery = true)
	List<Phone> findPhoneByUserId(Long userId);
	
	@Modifying
    @Transactional
    @Query("UPDATE Phone p SET p.type = :#{#phoneModel.type}, p.phone = :#{#phoneModel.phone}, " +
            //"p.isPrimary = :#{#phoneModel.isPrimary}, " +
            " p.updatedAt =:#{#phoneModel.updatedAt}, " +
    		"p.lastModifiedBy =:#{#phoneModel.lastModifiedBy} "+
            "WHERE p.id = :#{#phoneModel.id}")
    int updatePhone(@Param("phoneModel") PhoneModel phoneModel);
}
