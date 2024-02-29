package com.security.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"createdAt", "updatedAt", "deletedAt"})
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class ApiModel implements Serializable {
	@Serial
	private static final long serialVersionUID = -6295399500090324857L;

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@CreationTimestamp
	@Column(name = "created_at")
	protected Date createdAt;

	@JsonIgnore
	@UpdateTimestamp
	@Column(name = "updated_at")
	protected Date updatedAt;

	@JsonIgnore
	protected Date deletedAt;
}
