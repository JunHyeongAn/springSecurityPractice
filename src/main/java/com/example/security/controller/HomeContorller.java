package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContorller {
	@GetMapping("/")
	public String Home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loginGET() {
		return "login";
	}
	
	@GetMapping("/loginSuccess")
	public void loginSuccess() {}
	
	@GetMapping("/admin")
	public void admin() {}
	
	@GetMapping("/error")
	public void error() {}
}
