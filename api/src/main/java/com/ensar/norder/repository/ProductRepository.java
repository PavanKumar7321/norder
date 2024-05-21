package com.ensar.norder.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ensar.norder.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}

