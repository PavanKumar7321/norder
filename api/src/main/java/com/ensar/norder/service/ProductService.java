package com.ensar.norder.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensar.norder.entity.Product;
import com.ensar.norder.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setSubDescription(productDetails.getSubDescription());
        product.setImages(productDetails.getImages());
        product.setCode(productDetails.getCode());
        product.setSku(productDetails.getSku());
        product.setImages(productDetails.getImages());
        product.setQuantity(productDetails.getQuantity());
        product.setPriceSale(productDetails.getPriceSale());
        product.setTags(productDetails.getTags());
        product.setTaxes(productDetails.getTaxes());
        product.setGender(productDetails.getGender());
        product.setCategory(productDetails.getCategory());
        product.setColors(productDetails.getColors());
        product.setSizes(productDetails.getSizes());
        product.setNewLabel(productDetails.getNewLabel());
        product.setSaleLabel(productDetails.getSaleLabel());
        product.setInventoryType(productDetails.getInventoryType());
        product.setPublish(productDetails.getPublish());
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}

