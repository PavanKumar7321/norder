package com.ensar.norder.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "history")
@Data
@EqualsAndHashCode(callSuper = true)
public class History extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "orders_id")
	private Order order;

	@Column(name = "order_time")
	private LocalDateTime orderTime;

	@Column(name = "payment_time")
	private LocalDateTime paymentTime;

	@Column(name = "delivery_time")
	private LocalDateTime deliveryTime;

	@Column(name = "completion_time")
	private LocalDateTime completionTime;

	@JsonManagedReference
	@OneToMany(mappedBy = "history", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Timeline> timeline;

}
