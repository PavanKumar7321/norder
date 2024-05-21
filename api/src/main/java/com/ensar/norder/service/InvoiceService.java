package com.ensar.norder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensar.norder.entity.Invoice;
import com.ensar.norder.repository.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	public List<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}

	public Optional<Invoice> getInvoiceById(String id) {
		return invoiceRepository.findById(id);
	}

	public Invoice createInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

//    public Invoice updateInvoice(String id, Invoice invoiceDetails) {
//        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
//        invoice.setName(invoiceDetails.getName());
//        invoice.setDescription(invoiceDetails.getDescription());
//        invoice.setPrice(invoiceDetails.getPrice());
//        invoice.setSubDescription(invoiceDetails.getSubDescription());
//        invoice.setImages(invoiceDetails.getImages());
//        invoice.setCode(invoiceDetails.getCode());
//        invoice.setSku(invoiceDetails.getSku());
//        invoice.setImages(invoiceDetails.getImages());
//        invoice.setQuantity(invoiceDetails.getQuantity());
//        invoice.setPriceSale(invoiceDetails.getPriceSale());
//        invoice.setTags(invoiceDetails.getTags());
//        invoice.setTaxes(invoiceDetails.getTaxes());
//        invoice.setGender(invoiceDetails.getGender());
//        invoice.setCategory(invoiceDetails.getCategory());
//        invoice.setColors(invoiceDetails.getColors());
//        invoice.setSizes(invoiceDetails.getSizes());
//        invoice.setNewLabel(invoiceDetails.getNewLabel());
//        invoice.setSaleLabel(invoiceDetails.getSaleLabel());
//        invoice.setInventoryType(invoiceDetails.getInventoryType());
//        invoice.setPublish(invoiceDetails.getPublish());
//        return invoiceRepository.save(invoice);
//    }
//
    public void deleteInvoice(String id) {
        invoiceRepository.deleteById(id);
    }
}
