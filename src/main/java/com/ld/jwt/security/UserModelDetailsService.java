package com.ld.jwt.security;

import com.ld.jwt.entity.Agency;
import com.ld.jwt.entity.User;
import com.ld.jwt.repository.AgencyRepository;
import com.ld.jwt.repository.UserRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserModelDetailsService implements UserDetailsService {

   private final Logger log = LoggerFactory.getLogger(UserModelDetailsService.class);

//   private final UserRepository userRepository;
//   public UserModelDetailsService(UserRepository userRepository) {
//      this.userRepository = userRepository;
//   }
   
   @Autowired
   private UserRepository userRepository;
//   @Autowired
//   private UserAgencyRepository userAgencyRepository;
   @Autowired
   private AgencyRepository agencyRepository;


   @Override
   @Transactional
   public UserDetails loadUserByUsername(final String login) {
      log.debug("Authenticating user '{}'", login);

      if (new EmailValidator().isValid(login, null)) {
         return userRepository.findOneWithAuthoritiesByEmailIgnoreCase(login)
            .map(user -> createSpringSecurityUser(login, user))
            .orElseThrow(() -> new UsernameNotFoundException("User with email " + login + " was not found in the database"));
      }

      String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
      return userRepository.findOneWithAuthoritiesByUserName(lowercaseLogin)
         .map(user -> createSpringSecurityUser(lowercaseLogin, user))
         .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));

   }

   private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
      if (user.getIsActivated() == 0) {
         throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
      }
      if (user.getStatus() == 0) {
         throw new UserNotActivatedException("User " + lowercaseLogin + " is disabled. Please check with admin");
      }
      
      Optional<Agency> agencyInfo = agencyRepository.findUserAgency(user.getId());
      if(!agencyInfo.isEmpty() && agencyInfo.get().getStatus() == 0) {
    	  throw new UserNotActivatedException(agencyInfo.get().getAgency_name() + " is disabled. Please check with admin");
      }
      
      List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
    		  										.map(authority -> new SimpleGrantedAuthority(authority.getName()))
    		  										.collect(Collectors.toList());
      return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
   }
}

