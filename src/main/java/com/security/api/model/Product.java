package com.security.api.model;

import com.security.api.model.enums.DefaultStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Where;
import java.io.Serial;

@Entity
@Getter
@Setter
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted_at is null")
public class Product extends ApiModel {
	@Serial
	private static final long serialVersionUID = -2597349941671664319L;

	private String name;
	private Float price;
	private DefaultStatusEnum status;
}
