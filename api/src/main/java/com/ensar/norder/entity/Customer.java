package com.ensar.norder.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Customer {

	private String id;

	private String name;

	private String email;

	private String avatarUrl;

	private String ipAddress;

}
