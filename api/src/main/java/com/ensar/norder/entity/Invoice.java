package com.ensar.norder.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "invoice")
@Data
@EqualsAndHashCode(callSuper = true)
public class Invoice extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	public enum InvoiceStatus {
		paid, pending, overdue, draft
	}

	private Long sent;

	private LocalDateTime dueDate;

	private Double taxes;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('paid', 'pending', 'overdue', 'draft')")
	private InvoiceStatus status;

	private Double subTotal;

	private LocalDateTime createDate;

	private Double discount;

	private Double shipping;

	private Double totalAmount;

	private String invoiceNumber;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id")
	private List<InvoiceItem> items;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_from_id", referencedColumnName = "id")
    private Address invoiceFrom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_to_id", referencedColumnName = "id")
    private Address invoiceTo;


}
