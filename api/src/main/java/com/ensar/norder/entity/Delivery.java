package com.ensar.norder.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Embeddable
public class Delivery {
	
	private String shipBy;
    
	private String speedy;
    
	private String trackingNumber;

}
