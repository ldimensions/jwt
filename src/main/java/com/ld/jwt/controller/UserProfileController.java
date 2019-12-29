package com.ld.jwt.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ld.jwt.model.AddressModel;
import com.ld.jwt.model.PasswordModel;
import com.ld.jwt.model.PhoneModel;
import com.ld.jwt.model.ProfileModel;
import com.ld.jwt.entity.Address;
import com.ld.jwt.entity.Phone;
import com.ld.jwt.model.UserProfileModel;
import com.ld.jwt.service.UserProfileService;
import com.ld.jwt.service.UserService;


@RestController
@RequestMapping("/api")
public class UserProfileController {
	
	private final Logger log = LoggerFactory.getLogger(UserProfileController.class);
	
	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/profile")
	@PreAuthorize("hasAuthority('[SAdmin]') or hasAuthority('[Admin]')")
	public ResponseEntity<?> userProfile(Principal principal) {
		
		UserProfileModel userProfile = userProfileService.getProfile(principal.getName());		
		
		return new ResponseEntity<UserProfileModel>(userProfile, HttpStatus.OK);
   }
	
	@GetMapping("/address")
	public ResponseEntity<?> address(Principal principal) {
		
		Long userId = userService.getUserId(principal.getName());
		List<Address> address = userProfileService.getAddress(userId);
		
		return new ResponseEntity<List<Address>>(address, HttpStatus.OK);
	}
	
	@GetMapping("/phone")
	public ResponseEntity<?> phone(Principal principal) {
		
		Long userId = userService.getUserId(principal.getName());
		List<Phone> phone = userProfileService.getPhone(userId);
		
		return new ResponseEntity<List<Phone>>(phone, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ResponseEntity<?> profileUpdate(Principal principal, @RequestBody ProfileModel profileModel) {
		
		Long userId = userService.getUserId(principal.getName());
		
		if(userProfileService.updateProfile(profileModel, userId) == 1) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/address", method = RequestMethod.POST)
	public ResponseEntity<?> addressUpdate(Principal principal, @RequestBody List<AddressModel> addressModel) {
		
		Long userId = userService.getUserId(principal.getName());
		
		if(userProfileService.updateAddress(addressModel, userId) == 1) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/phone", method = RequestMethod.POST)
	public ResponseEntity<?> phoneUpdate(Principal principal, @RequestBody List<PhoneModel> phoneModel) {
		
		Long userId = userService.getUserId(principal.getName());
		
		if(userProfileService.updatePhone(phoneModel, userId) == 1) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public ResponseEntity<?> passwordUpdate(Principal principal, @RequestBody PasswordModel password) {
		
		
		Long userId = userService.getUserId(principal.getName());
		
		log.info("----- {}",password);
		
		if(userProfileService.updatePassword(password, userId) == 1) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@GetMapping("/test")
	//@PreAuthorize("hasAuthority('SAdmin')")
	public boolean userProfile(Authentication authentication) {
		
		//String encodedPassword = bCryptPasswordEncoder.encode("admin");
		
//		String password = "admin";
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String hashedPassword = passwordEncoder.encode(password);
		
		
		System.out.println("-----------------"+passwordEncoder.encode("test"));
		
		boolean hasUserRole = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("[SAdmin]"));
		System.out.println("-----------------"+hasUserRole);
		System.out.println("-----------------"+authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
		return hasUserRole;
   }

}
