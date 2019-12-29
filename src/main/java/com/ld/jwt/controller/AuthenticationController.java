package com.ld.jwt.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ld.jwt.entity.Authority;
import com.ld.jwt.entity.User;
import com.ld.jwt.jwt.JWTFilter;
import com.ld.jwt.jwt.TokenProvider;
import com.ld.jwt.model.Login;
import com.ld.jwt.model.RolePermissionModel;
import com.ld.jwt.service.UserService;
import com.ld.jwt.service.ValidationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

/**
 * Controller to authenticate users.
 */
@RestController
@RequestMapping("/api")
public class AuthenticationController {

   private final TokenProvider tokenProvider;
   private final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

   private final UserService userService;

   private final AuthenticationManagerBuilder authenticationManagerBuilder;

   public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserService userService) {
      this.tokenProvider = tokenProvider;
      this.authenticationManagerBuilder = authenticationManagerBuilder;
      this.userService = userService;
   }

   @PostMapping("/authenticate")
   public ResponseEntity<JWTToken> authorize(@Valid @RequestBody Login loginDto) {

      UsernamePasswordAuthenticationToken authenticationToken =
         new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

      Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
      SecurityContextHolder.getContext().setAuthentication(authentication);
     
      User user = userService.getUserDetails(loginDto.getUsername());
      
      Set<Authority> authority = user.getAuthorities();
      
      ArrayList<String> permission = new ArrayList<String>();
      for(Integer i = 0; i< authority.iterator().next().getPermissions().size(); i++) {
    	  permission.add(authority.iterator().next().getPermissions().get(i).getPermissionName().toString());
      }
      
      boolean rememberMe = (loginDto.isRememberMe() == null) ? false : loginDto.isRememberMe();
      String jwt = tokenProvider.createToken(authentication, rememberMe, permission);
      
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

      return new ResponseEntity<>(new JWTToken(jwt), httpHeaders, HttpStatus.OK);
   }
   
   @GetMapping("/isLoggedIn")
   public ResponseEntity<?> getActualUser() {
      return ResponseEntity.ok(userService.getUserWithAuthorities().isPresent());
   }

   /**
    * Object to return as body in JWT Authentication.
    */
   static class JWTToken {

      private String idToken;

      JWTToken(String idToken) {
         this.idToken = idToken;
      }

      @JsonProperty("id_token")
      String getIdToken() {
         return idToken;
      }

      void setIdToken(String idToken) {
         this.idToken = idToken;
      }
   }
}
