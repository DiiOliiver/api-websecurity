package com.security.api.form;

import com.security.api.model.enums.DefaultStatusEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
	@NotEmpty(message = "campo não pode estar vazio")
	private String name;
	private Float price;
	private DefaultStatusEnum status;
}
