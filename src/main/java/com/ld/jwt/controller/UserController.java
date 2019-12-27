package com.ld.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ld.jwt.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@GetMapping("/userNameExist/{userName}")
	public boolean userNameExist(@PathVariable String userName) {
		boolean exist = userService.isUserNameExist(userName);
		return exist;
	}

}
