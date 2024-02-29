package com.security.api.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public abstract class ApiDTO {
	private Long proId;
	protected Date createdAt;
}
