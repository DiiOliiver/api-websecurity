package com.security.api.controller.auth;

import com.security.api.constants.HttpStatusCodeConstants;
import com.security.api.dto.LoginResponseDTO;
import com.security.api.form.AuthenticationForm;
import com.security.api.model.User;
import com.security.api.service.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.security.api.constants.PathRestConstants.*;

@RestController
@RequestMapping(AUTH)
public class LoginAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping(LOGIN)
	public ResponseEntity<Object> handle(@RequestBody @Valid AuthenticationForm request) {
		try {
			var usernamePassword = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword());
			var auth = authenticationManager.authenticate(usernamePassword);
			var token = tokenService.generateToken((User) auth.getPrincipal());
			
			return ResponseEntity.status(HttpStatusCodeConstants.OK).body(new LoginResponseDTO(token));
		} catch (AuthenticationException authenticationException) {
			authenticationException.printStackTrace();
			return ResponseEntity.status(HttpStatusCodeConstants.FORBIDDEN).build();
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatusCodeConstants.BAD_REQUEST).build();
		}
	}
}
