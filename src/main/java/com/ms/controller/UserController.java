package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.UserInfo;
import com.ms.service.UserService;

@RestController
@RequestMapping("/users/")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/new")
	public UserInfo addUser(@RequestBody UserInfo userInfo) {
		service.addUser(userInfo);
		return userInfo;
	}
}
