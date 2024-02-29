package com.security.api.dto;

import com.security.api.model.Product;
import com.security.api.model.enums.DefaultStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO extends ApiDTO {
	private String name;
	private Float price;
	private DefaultStatusEnum status;

	public ProductDTO(String name, Float price, DefaultStatusEnum status) {
		this.name = name;
		this.price = price;
		this.status = status;
	}

	public static ProductDTO from(Product product) {
		return new ProductDTO(product.getName(), product.getPrice(), product.getStatus());
	}
}
