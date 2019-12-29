package com.ld.jwt.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ld.jwt.entity.Agency;
import com.ld.jwt.model.AgencyModel;
import com.ld.jwt.model.ProfileModel;
import com.ld.jwt.service.AgencyService;
import com.ld.jwt.service.UserService;

@RestController
@RequestMapping("/api")
public class AgencyController {

	private final Logger log = LoggerFactory.getLogger(AgencyController.class);
	
	@Autowired
	private AgencyService agencyService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/agency")
	@PreAuthorize("hasAuthority('[SAdmin]')")
	public ResponseEntity<?> getAllAgency() {
		
		List<Agency> agencyList = agencyService.getAllAgency();
		
		return new ResponseEntity<List<Agency>>(agencyList, HttpStatus.OK);
	}
	
	@GetMapping("/agencyDetails")
	@PreAuthorize("hasAuthority('[SAdmin]') or hasAuthority('[Admin]')")
	public ResponseEntity<?> useragencyDetails(Principal principal) {
				
		Integer agencyId = userService.getAgencyId(principal.getName());		
		Agency agency = agencyService.getAgency(agencyId);				
		
		return new ResponseEntity<Agency>(agency, HttpStatus.OK);
	}
	
	@GetMapping("/agencyDetails/{agencyId}")
	@PreAuthorize("hasAuthority('[SAdmin]')")
	public ResponseEntity<?> useragencyDetailsById(@PathVariable Integer agencyId) {
				
		Agency agency = agencyService.getAgency(agencyId);				
		
		return new ResponseEntity<Agency>(agency, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/agencyUpdate", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('[SAdmin]') or hasAuthority('[Admin]')")
	public ResponseEntity<?> agencyUpdate(Principal principal, @RequestBody AgencyModel agencyeModel) {
		
		Long userId = userService.getUserId(principal.getName());
		Integer agencyId = userService.getAgencyId(principal.getName());
		
		if(agencyService.updateAgency(agencyeModel, userId, agencyId) == 1) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/agencyUpdateById", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('[SAdmin]')")
	public ResponseEntity<?> agencyUpdateByAdmin(Principal principal, @RequestBody AgencyModel agencyeModel) {
		
		Long userId = userService.getUserId(principal.getName());
		
		if(agencyService.updateAgencyByAdmin(agencyeModel, userId) == 1) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
}
