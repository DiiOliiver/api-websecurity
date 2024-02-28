package com.security.api.controller;

import com.security.api.dto.ProductDto;
import com.security.api.form.ProductForm;
import com.security.api.model.Product;
import com.security.api.model.enums.DefaultStatusEnum;
import com.security.api.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping
	public ResponseEntity<Object> postProduct(@RequestBody @Valid ProductForm productForm) {
		try {
			Product newProduct = new Product();
			newProduct.setName(productForm.getName());
			newProduct.setPrice(productForm.getPrice());
			newProduct.setStatus(DefaultStatusEnum.ACTIVE);
			Product saveProduct = productRepository.save(newProduct);
			ProductDto productDto = ProductDto.from(saveProduct);
			return ResponseEntity.ok(productDto);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping
	public ResponseEntity<Object> getAllProducts() {
		try {
			List<ProductDto> productDtos = productRepository.findAll().stream().map(ProductDto::from).toList();
			return ResponseEntity.ok(productDtos);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
}
