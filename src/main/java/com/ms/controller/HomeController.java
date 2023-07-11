package com.ms.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/hello")
	public String helloAPI() {
		return "HELLO USER...!";
	}
	@GetMapping("/welcome")
	public String welcomeAPI() {
		return "WELCOME USER...!";
	}
	
	@GetMapping("products/single")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String getSingleProduct() {
		return "Single Product....";
	}
	
	@GetMapping("/products/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String getAllProduct() {
		return "All Products...";
	}
}
