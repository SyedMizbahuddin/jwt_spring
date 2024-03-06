package com.mizbah.dto;

import com.mizbah.entity.RoleType;

import lombok.Data;

@Data
public class SignupRequest {

	private String name;
	private String email;
	private String password;
	private RoleType role;
}
