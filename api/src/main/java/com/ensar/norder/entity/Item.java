package com.ensar.norder.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "item")
@Data
@EqualsAndHashCode(callSuper = true)
public class Item extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "orders_id")
	private Order order;

	private String sku;

	private int quantity;

	private String name;

	private String coverUrl;

	private double price;

}
