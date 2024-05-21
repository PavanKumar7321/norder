package com.ensar.norder.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "review")
@Data
@EqualsAndHashCode(callSuper = true)
public class Review extends BaseEntity {

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "name")
	private String name;

	@Column(name = "posted_at")
	private LocalDateTime postedAt;

	@Column(name = "comment")
	private String comment;

	@Column(name = "is_purchased")
	private boolean isPurchased;

	@Column(name = "rating")
	private double rating;

	@Column(name = "avatar_url")
	private String avatarUrl;

	private int helpful;

	@ElementCollection
	@CollectionTable(name = "attachment", joinColumns = @JoinColumn(name = "review_id"))
	private List<String> attachments;

}