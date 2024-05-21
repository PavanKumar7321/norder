package com.ensar.norder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "address")
@Data
@EqualsAndHashCode(callSuper = true)
public class Address extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String name;

	private String company;

	@Column(name = "is_primary")
	private Boolean primary;

	@Column(name = "full_address")
	private String fullAddress;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "address_type")
	private String addressType;

}
