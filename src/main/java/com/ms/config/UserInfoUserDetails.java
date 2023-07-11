package com.ms.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ms.entity.UserInfo;

public class UserInfoUserDetails implements UserDetails{
	
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities=new ArrayList<>();

	public UserInfoUserDetails(UserInfo userInfo) {
		this.userName=userInfo.getUserName();
		this.password=userInfo.getPassword();
		String roles[]=userInfo.getRoles().split(",");
		for(String role:roles) {
			SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role);
			authorities.add(authority);
		}
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
