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

@Entity(name = "invoice_item")
@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceItem extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;

	private String title;

	private Double price;

	private Double total;

	private String service;

	private Integer quantity;

	private String description;

}
