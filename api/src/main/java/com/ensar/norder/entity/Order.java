package com.ensar.norder.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "`order`")
@Table(name = "orders")
@Data
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	public enum OrderStatus {
		pending, completed, cancelled, refunded
	}

	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	private double taxes;

	@Column(name = "sub_total")
	private double subTotal;

	private double shipping;

	private double discount;

	@Column(name = "total_amount")
	private double totalAmount;

	@Column(name = "total_quantity")
	private int totalQuantity;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('pending', 'completed', 'refunded', 'cancelled') default 'pending'")
	private OrderStatus status;

	@JsonManagedReference
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> items;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "customer_id")),
			@AttributeOverride(name = "name", column = @Column(name = "customer_name")),
			@AttributeOverride(name = "email", column = @Column(name = "customer_email")),
			@AttributeOverride(name = "avatarUrl", column = @Column(name = "customer_avatarUrl")),
			@AttributeOverride(name = "ipAddress", column = @Column(name = "customer_ip_address")) })
	private Customer customer;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "shipBy", column = @Column(name = "delivery_ship_by")),
			@AttributeOverride(name = "speedy", column = @Column(name = "delivery_speedy")),
			@AttributeOverride(name = "trackingNumber", column = @Column(name = "delivery_tracking_number")) })
	private Delivery delivery;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "fullAddress", column = @Column(name = "shipping_full_address")),
			@AttributeOverride(name = "phoneNumber", column = @Column(name = "shipping_phone_number")) })
	private ShippingAddress shippingAddress;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "cardType", column = @Column(name = "payment_card_type")),
			@AttributeOverride(name = "cardNumber", column = @Column(name = "payment_card_number")) })
	private Payment payment;

	@JsonManagedReference
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<History> history;

}
