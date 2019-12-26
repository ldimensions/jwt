package com.ld.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ld.jwt.entity.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Long> {

	@Query(value = "Select * from agency a join user u on u.agency_id = a.id where u.id=?", nativeQuery = true)
	Optional<Agency> findUserAgency(Long userId);
}
