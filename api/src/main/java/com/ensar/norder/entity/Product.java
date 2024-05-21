package com.ensar.norder.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "product")
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String gender;

	private String publish;

	private String category;

	private int available;

	@Column(name = "price_sale")
	private double priceSale;

	private int taxes;

	private int quantity;

	@Column(name = "inventory_type")
	private String inventoryType;

	@ElementCollection
	@CollectionTable(name = "size", joinColumns = @JoinColumn(name = "product_id"))
	private List<String> sizes;
	
	@ElementCollection
	@CollectionTable(name = "tags", joinColumns = @JoinColumn(name = "product_id"))
	private List<String> tags;

	@ElementCollection
	@CollectionTable(name = "image", joinColumns = @JoinColumn(name = "product_id"))
	private List<String> images;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Rating> ratings;

	@JsonManagedReference
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews;
	
	

	private String description;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "enabled", column = @Column(name = "new_label_enabled")),
			@AttributeOverride(name = "content", column = @Column(name = "new_label_content")) })
	private Label newLabel;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "enabled", column = @Column(name = "saleLabel_enabled")),
			@AttributeOverride(name = "content", column = @Column(name = "saleLabel_content")) })
	private Label saleLabel;

	private String sku;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	private String name;
	
	private String code;

	private double price;

	@Column(name = "cover_url")
	private String coverUrl;

	@Column(name = "total_ratings")
	private double totalRatings;

	@Column(name = "total_sold")
	private int totalSold;

	@Column(name = "total_reviews")
	private int totalReviews;

	@Column(name = "sub_description")
	private String subDescription;

	@ElementCollection
	@CollectionTable(name = "color", joinColumns = @JoinColumn(name = "product_id"))
	private List<String> colors;

}
