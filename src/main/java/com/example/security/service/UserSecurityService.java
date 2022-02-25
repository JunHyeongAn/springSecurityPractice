package com.example.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.entity.UserEntity;
import com.example.security.repository.UserRepositoty;

@Service
public class UserSecurityService implements UserDetailsService {
	@Autowired
	UserRepositoty userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(username);
		UserEntity entity = userRepository.findByUserId(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new User(entity.getId(), entity.getPassword(), authorities);
	}
	
	public void save(UserEntity entity) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		entity.setPassword(encoder.encode(entity.getPassword()));
		userRepository.save(entity);
	}
}
