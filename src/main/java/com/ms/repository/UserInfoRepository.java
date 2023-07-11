package com.ms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
	public Optional<UserInfo> findByUserName(String userName);
}
