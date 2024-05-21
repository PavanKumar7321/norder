package com.ensar.norder.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "rating")
@Data
@EqualsAndHashCode(callSuper = true)
public class Rating extends BaseEntity {

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "name")
	private String name;

	@Column(name = "star_count")
	private int starCount;

	@Column(name = "review_count")
	private int reviewCount;

}
