package com.ms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ms.config.UserInfoUserDetails;
import com.ms.entity.UserInfo;
import com.ms.repository.UserInfoRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> optional=repo.findByUserName(username);
		UserInfo userInfo=optional.get();
		return optional.map(UserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("username is not valid"));
		//return new UserInfoUserDetails(userInfo);
	}

}
