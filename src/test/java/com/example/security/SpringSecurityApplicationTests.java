package com.example.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.security.entity.User;
import com.example.security.model.Role;
import com.example.security.service.UserService;

@SpringBootTest
class SpringSecurityApplicationTests {
	@Autowired
	UserService userService;
	
	@Test
	public void saveUser() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();

		User user = User.builder()
				.id("test2")
				.name("test2")
				.password(encoder.encode("1234"))
				.role(Role.ADMIN).build();
		
		userService.saveUser(user);
	}
}
