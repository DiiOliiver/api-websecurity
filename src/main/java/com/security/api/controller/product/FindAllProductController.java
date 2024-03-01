package com.security.api.controller.product;

import com.security.api.dto.ProductDTO;
import com.security.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static com.security.api.constants.PathRestConstants.*;

@RestController
@RequestMapping(PRODUCT)
public class FindAllProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public ResponseEntity<Object> getAllProducts() {
		try {
			List<ProductDTO> productDTOS = productRepository.findAll().stream().map(ProductDTO::from).toList();
			return ResponseEntity.ok(productDTOS);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
}
