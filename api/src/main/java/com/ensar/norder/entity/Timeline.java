package com.ensar.norder.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "timeline")
@Data
@EqualsAndHashCode(callSuper = true)
public class Timeline extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "history_id")
	private History history;

	private String title;

	private LocalDateTime time;

}
