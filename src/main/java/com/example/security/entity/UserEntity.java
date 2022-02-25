package com.example.security.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	private String id;
	private String password;
	private String name;
	private String role;
	
	@Builder
	public UserEntity(String id, String password, String name, String role) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.role = role;
	}
}
