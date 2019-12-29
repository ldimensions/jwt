package com.ld.jwt.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ld.jwt.model.PhoneModel;
import com.ld.jwt.model.ProfileModel;
import com.ld.jwt.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

	@EntityGraph(attributePaths = "authorities")
	Optional<User> findOneWithAuthoritiesByUserName(String username);

   	@EntityGraph(attributePaths = "authorities")
   	Optional<User> findOneWithAuthoritiesByEmailIgnoreCase(String email);

   	boolean existsByUserName(String email);
	boolean existsByEmail(String email);
	
	User findByUserName(String userName);
	
	@Query(value = "SELECT agency_id from user WHERE user_name = ?1", nativeQuery = true)
	Integer findAgencyId(String userName);
	
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.firstName = :#{#profileModel.firstName}, u.middleName = :#{#profileModel.middleName}, " +
            "u.lastName = :#{#profileModel.lastName}, u.email = :#{#profileModel.email}, u.updatedAt =:#{#profileModel.updatedAt}, " +
    		"u.lastModifiedBy =:#{#profileModel.lastModifiedBy} "+
            "WHERE u.id = :#{#userId}")
    int updateProfile(@Param("profileModel") ProfileModel profileModel, Long userId);
	
	@Modifying
    @Transactional
    @Query("UPDATE User SET password = ?1 WHERE id = ?2")
    int updatePassword(String password, Long userId);
	    
//    @Query("select u.firstName, a.name as authority_name, p.permission_name from User u " +
//            "left join user_authority ua on ua.user_id = u.id " +
//            "left join authority a on a.id = ua.authority_id " +
//            "left join role_permissions rp on rp.authority_id = a.id " +
//            "left join permission p on p.id = rp.permission_id " +
//            "where u.id = ?1")
//    int getRolesPermission(@Param("id") Long id);
    
}