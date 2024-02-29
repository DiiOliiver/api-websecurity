package com.security.api.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {
	private String login;
	private String password;
	private String role;
}
