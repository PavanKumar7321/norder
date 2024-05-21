package com.ensar.norder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity(name = "roles")
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {
	
	public enum ERole {
		  ROLE_USER,
		  ROLE_MODERATOR,
		  ROLE_ADMIN
		}
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

}
