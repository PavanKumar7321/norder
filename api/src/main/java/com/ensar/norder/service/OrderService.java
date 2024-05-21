package com.ensar.norder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensar.norder.entity.Order;
import com.ensar.norder.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Optional<Order> getOrderById(String id) {
		return orderRepository.findById(id);
	}

//	public Order createProduct(Order product) {
//		return orderRepository.save(product);
//	}

//    public Order updateOrder(String id, Order productDetails) {
//    	Order product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
//    	Order.setName(productDetails.getName());
//    	Order.setDescription(productDetails.getDescription());
//        product.setPrice(productDetails.getPrice());
//        product.setSubDescription(productDetails.getSubDescription());
//        product.setImages(productDetails.getImages());
//        product.setCode(productDetails.getCode());
//        product.setSku(productDetails.getSku());
//        product.setImages(productDetails.getImages());
//        product.setQuantity(productDetails.getQuantity());
//        product.setPriceSale(productDetails.getPriceSale());
//        product.setTags(productDetails.getTags());
//        product.setTaxes(productDetails.getTaxes());
//        product.setGender(productDetails.getGender());
//        product.setCategory(productDetails.getCategory());
//        product.setColors(productDetails.getColors());
//        product.setSizes(productDetails.getSizes());
//        product.setNewLabel(productDetails.getNewLabel());
//        product.setSaleLabel(productDetails.getSaleLabel());
//        product.setInventoryType(productDetails.getInventoryType());
//        product.setPublish(productDetails.getPublish());
//        return productRepository.save(product);
//    }

	public void deleteOrder(String id) {
		orderRepository.deleteById(id);
	}
}
