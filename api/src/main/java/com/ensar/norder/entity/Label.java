package com.ensar.norder.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Label {

	private boolean enabled;

	private String content;

}
