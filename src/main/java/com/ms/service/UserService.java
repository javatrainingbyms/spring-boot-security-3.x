package com.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ms.entity.UserInfo;
import com.ms.repository.UserInfoRepository;

@Service
public class UserService {
	@Autowired
	private UserInfoRepository repo;
	@Autowired
	private PasswordEncoder encoder;
	
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		repo.save(userInfo);
		return "user added to system";
	}
}
