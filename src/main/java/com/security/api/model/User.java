package com.security.api.model;

import com.security.api.model.enums.DefaultStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.io.Serial;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@Where(clause = "deleted_at is null")
public class User extends ApiModel implements UserDetails {

	@Serial
	private static final long serialVersionUID = 3608769421735290585L;

	private String name;

	@Column(nullable = false)
	private String email;

	private String cpf;

	private String password;

	private boolean temporaryPassword = true;

	private Date updatedPasswordAt;

	@Enumerated
	private DefaultStatusEnum status;

	public void setPasswordCrypt(String password) {
		this.password = new BCryptPasswordEncoder().encode(password);
		this.updatedPasswordAt = new Date();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
