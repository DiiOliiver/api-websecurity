package com.security.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
	private String login;
	private String password;
	private String role;
}
