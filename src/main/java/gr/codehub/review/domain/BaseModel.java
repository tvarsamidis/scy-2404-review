package gr.codehub.review.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass

// MappedSuperclass allows mapping inheritance, where the super class is not treated as an
// entity, and where polymorphic queries that fetch objects by the base class are not supported.

// By default, properties of the superclass are ignored and not persistent!
// You have to annotate the superclass with @MappedSuperclass to enable embedding of its
// properties in the concrete subclass tables.

public class BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;
}
