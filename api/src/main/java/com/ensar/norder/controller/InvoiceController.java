package com.ensar.norder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensar.norder.entity.Invoice;
import com.ensar.norder.service.InvoiceService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@GetMapping
	public List<Invoice> getAllInvoices() {
		return invoiceService.getAllInvoices();
	}

	@GetMapping("/{id}")
	public Optional<Invoice> getInvoiceById(@PathVariable String id) {
		return invoiceService.getInvoiceById(id);
	}

	@PostMapping
	public Invoice createInvoice(@RequestBody Invoice invoice) {
		return invoiceService.createInvoice(invoice);
	}

//	@PutMapping("/{id}")
//	public Invoice updateInvoice(@PathVariable String id, @RequestBody Invoice invoiceDetails) {
//		return invoiceService.updateInvoice(id, invoiceDetails);
//	}
//
	@DeleteMapping("/{id}")
	public void deleteInvoice(@PathVariable String id) {
		invoiceService.deleteInvoice(id);
	}
}
