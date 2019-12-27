package com.ld.jwt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ld.jwt.entity.Address;
import com.ld.jwt.model.AddressModel;


public interface AddressRepository extends JpaRepository<Address, Long> {
	
	@Query(value = "select * from Address a where a.user_id = ?1", nativeQuery = true)
	List<Address> findAddressByUserId(Long userId);
	
	@Modifying
    @Transactional
    @Query("UPDATE Address u SET u.address1 = :#{#addressModel.address1}, u.address2 = :#{#addressModel.address2}, " +
            //"u.isPrimary = :#{#addressModel.isPrimary}, " +
            "u.city = :#{#addressModel.city}," +
            "u.state = :#{#addressModel.state}, u.zip = :#{#addressModel.zip}," +
            "u.country = :#{#addressModel.country}," +
            " u.updatedAt =:#{#addressModel.updatedAt}, " +
    		"u.lastModifiedBy =:#{#addressModel.lastModifiedBy} "+
            "WHERE u.id = :#{#addressModel.id}")
    int updateAddress(@Param("addressModel") AddressModel addressModel);
	
//	@Modifying
//    @Transactional
//    @Query("INSERT INTO Address (address1, address2, isPrimary, city, state, zip, country, updatedAt, lastModifiedBy, createdAt, createdAt) " +
//    		"Values (:#{#addressModel.address1}, :#{#addressModel.address2}, :#{#addressModel.isPrimary}, "
//    		+ ":#{#addressModel.city}, :#{#addressModel.state}, :#{#addressModel.zip}"
//    		+ ":#{#addressModel.country}, :#{#addressModel.updatedAt}, :#{#addressModel.lastModifiedBy}"
//    		+ ":#{#addressModel.createdAt}, :#{#addressModel.createdAt})")
//	int addAddress(@Param("addressModel") AddressModel addressModel, Long userId);
}
