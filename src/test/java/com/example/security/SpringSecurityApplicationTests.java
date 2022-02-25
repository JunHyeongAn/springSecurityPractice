package com.example.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.security.entity.UserEntity;
import com.example.security.model.Role;
import com.example.security.service.UserSecurityService;

@SpringBootTest
class SpringSecurityApplicationTests {
	@Autowired
	UserSecurityService service;

	@Test
	void contextLoads() {
		System.out.println(Role.valueOf("ADMIN"));
	}
	
	@Test
	void saveTest() {
		UserEntity e = UserEntity.builder()
				.id("test2")
				.password("1234")
				.name("test2name")
				.role("ADMIN").build();
		
		service.save(e);
	}
}
