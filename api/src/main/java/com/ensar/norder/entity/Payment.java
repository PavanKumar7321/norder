package com.ensar.norder.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Embeddable
public class Payment {
	
	private String cardType;
    
	private String cardNumber;

}
