package com.example.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
	ADMIN("ADMIN_print", "admin"), USER("USER", "user");
	private String key;
	private String value;
}
