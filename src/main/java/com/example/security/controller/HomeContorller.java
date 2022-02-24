package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContorller {
	@GetMapping("/")
	public String Home() {
		System.out.println("in");
		return "home";
	}
	
	@GetMapping("/login")
	public String loginGET() {
		return "login";
	}
}
