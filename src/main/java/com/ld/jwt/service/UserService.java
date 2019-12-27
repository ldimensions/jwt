package com.ld.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ld.jwt.entity.User;
import com.ld.jwt.repository.UserRepository;
import com.ld.jwt.security.SecurityUtils;
import java.util.Optional;

@Service
@Transactional
public class UserService {

	@Autowired 
	private UserRepository userRepository;

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

}