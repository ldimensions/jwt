package com.ld.jwt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ld.jwt.controller.AgencyController;
import com.ld.jwt.entity.User;
import com.ld.jwt.model.RolePermissionModel;
import com.ld.jwt.repository.AuthorityRepository;
import com.ld.jwt.repository.UserRepository;
import com.ld.jwt.security.SecurityUtils;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	private final Logger log = LoggerFactory.getLogger(UserService.class);

   	@Transactional(readOnly = true)
   	public Optional<User> getUserWithAuthorities() {
      return SecurityUtils.getCurrentUserName().flatMap(userRepository::findOneWithAuthoritiesByUserName);
   	}
	
	public boolean isUserNameExist(String userName) {
		return userRepository.existsByUserName(userName);
	}
	
	public boolean userNameExistService(String userName) {
		return userRepository.existsByEmail(userName);
	}
	
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    public Long getUserId(String userName) {
    	User user =  userRepository.findByUserName(userName);
    	return user.getId();
    }
    
    public Integer getAgencyId(String userName) {
    	Integer agencyId =  userRepository.findAgencyId(userName);
    	return agencyId;
    }
    
    public User getUserDetails(String userName) {
    	User user =  userRepository.findByUserName(userName);
    	return user;
    }
    
    public void rolePermission(Long userId) {
    	authorityRepository.getRolePermission(userId);
    }

}