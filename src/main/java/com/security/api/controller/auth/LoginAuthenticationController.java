package com.security.api.controller.auth;

import com.security.api.form.AuthenticationForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class LoginAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<Object> handle(@RequestBody @Valid AuthenticationForm request) {
		try {
			var usernamePassword = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword());
			var auth = authenticationManager.authenticate(usernamePassword);
			System.out.println(auth);
			return ResponseEntity.ok().build();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
}
