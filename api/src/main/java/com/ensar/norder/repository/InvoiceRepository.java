package com.ensar.norder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensar.norder.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
	
}
