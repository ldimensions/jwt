package com.ld.jwt.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ld.jwt.controller.AgencyController;
import com.ld.jwt.entity.Agency;
import com.ld.jwt.model.AgencyModel;
import com.ld.jwt.repository.AgencyRepository;

@Service
public class AgencyService {

	private final Logger log = LoggerFactory.getLogger(AgencyController.class);
	
	@Autowired
	private AgencyRepository agencyRepository;
	
	public List<Agency> getAllAgency() {
		List<Agency> agency = agencyRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
		return agency;		
	}
	
	public Agency getAgency(Integer id) {
		Agency agency = agencyRepository.findById(id).orElse(null);
		if(agency == null) {
			return null;
		}
		return agency;
	}
	
	public Integer updateAgency(AgencyModel agencyModel, Long userId, Integer agencyId) {
		
		agencyModel.setLastModifiedBy((int) (long) userId);
		agencyModel.setUpdatedAt(new Date());
		log.info("--------- {}",agencyModel.toString());
		return agencyRepository.updateAgency(agencyModel, agencyId);
	}
	
	public Integer updateAgencyByAdmin(AgencyModel agencyModel, Long userId) {
		
		agencyModel.setLastModifiedBy((int) (long) userId);
		agencyModel.setUpdatedAt(new Date());
		return agencyRepository.updateAgencyByAdmin(agencyModel);
	}
	
}
