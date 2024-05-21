package com.ensar.norder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensar.norder.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
}
