package com.security.api.controller.auth;

import com.security.api.constants.HttpStatusCodeConstants;
import com.security.api.form.RegisterForm;
import com.security.api.model.User;
import com.security.api.model.enums.UserRoleEnum;
import com.security.api.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.security.api.constants.PathRestConstants.*;

@RestController
@RequestMapping(AUTH)
public class RegisterAuthenticationController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(REGISTER)
	public ResponseEntity<Object> handle(@RequestBody @Valid RegisterForm request) {
		try {
			if (this.userRepository.findByLogin(request.getLogin()) != null) {
				return ResponseEntity.badRequest().build();
			}

			String encryptedPassword = new BCryptPasswordEncoder().encode(request.getPassword());
			User newUser = new User(request.getLogin(), encryptedPassword, UserRoleEnum.fromInitials(request.getRole()));

			this.userRepository.save(newUser);

			return ResponseEntity.status(HttpStatusCodeConstants.CREATED).build();
		} catch (AuthenticationException authenticationException) {
			authenticationException.printStackTrace();
			return ResponseEntity.status(HttpStatusCodeConstants.FORBIDDEN).build();
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatusCodeConstants.BAD_REQUEST).build();
		}
	}
}
