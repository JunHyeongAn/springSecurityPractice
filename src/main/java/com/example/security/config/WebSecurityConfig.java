package com.example.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.security.service.UserSecurityService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserSecurityService userService;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeHttpRequests()
		.antMatchers("/loginSuccess").authenticated()
		.antMatchers("/admin").authenticated()
		.antMatchers("/post/login").permitAll()
		.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/post/login")
			.defaultSuccessUrl("/loginSuccess")
		.and()
			.logout()
			.logoutSuccessUrl("/")
		.and()
			.exceptionHandling()
			.accessDeniedPage("/error");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
}
