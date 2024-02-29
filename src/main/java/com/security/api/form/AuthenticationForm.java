package com.security.api.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationForm {
	private String login;
	private String password;
}
