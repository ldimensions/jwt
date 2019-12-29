package com.ld.jwt.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ld.jwt.entity.Agency;
import com.ld.jwt.model.AgencyModel;

public interface AgencyRepository extends JpaRepository<Agency, Integer> {
	

	@Query(value = "Select * from agency a join user u on u.agency_id = a.id where u.id=?", nativeQuery = true)
	Optional<Agency> findUserAgency(Long userId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE agency a SET a.country = :#{#agencyModel.country}, "
			+ "a.agency_name = :#{#agencyModel.agencyName}, a.address1 = :#{#agencyModel.address1}, "
			+ "a.address2 = :#{#agencyModel.address2}, a.city = :#{#agencyModel.city}, "
			+ "a.state = :#{#agencyModel.state}, a.zip = :#{#agencyModel.zip}, "
			+ "a.phone1 = :#{#agencyModel.phone1}, a.phone2 = :#{#agencyModel.phone2}, "
			+ "a.updated_at =:#{#agencyModel.updatedAt}, a.last_modified_by =:#{#agencyModel.lastModifiedBy} "
			+ "where id = :#{#agencyId}", nativeQuery = true)
	Integer updateAgency(@Param("agencyModel") AgencyModel agencyModel, Integer agencyId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE agency a SET a.country = :#{#agencyModel.country}, a.status = :#{#agencyModel.status}, "
			+ "a.agency_name = :#{#agencyModel.agencyName}, a.address1 = :#{#agencyModel.address1}, "
			+ "a.address2 = :#{#agencyModel.address2}, a.city = :#{#agencyModel.city}, "
			+ "a.state = :#{#agencyModel.state}, a.zip = :#{#agencyModel.zip}, "
			+ "a.phone1 = :#{#agencyModel.phone1}, a.phone2 = :#{#agencyModel.phone2}, "
			+ "a.updated_at =:#{#agencyModel.updatedAt}, a.last_modified_by =:#{#agencyModel.lastModifiedBy} "
			+ "where id = :#{#agencyModel.id}", nativeQuery = true)
	Integer updateAgencyByAdmin(@Param("agencyModel") AgencyModel agencyModel);	
	
	
	


		
}
