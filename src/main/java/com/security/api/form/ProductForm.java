package com.security.api.form;

import com.security.api.model.enums.DefaultStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
	private String name;
	private Float price;
	private DefaultStatusEnum status;
}
