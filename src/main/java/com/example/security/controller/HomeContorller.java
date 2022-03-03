package com.example.security.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.security.entity.User;

@Controller
public class HomeContorller {
	@GetMapping("/")
	public String Home(@AuthenticationPrincipal User user) {
		if(user != null) {
			System.out.println(user.getName());
			System.out.println(user.getId());
		}
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
	
//	@GetMapping("/error")
//	public void error() {}
}
