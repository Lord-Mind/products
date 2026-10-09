package com.example.products.service;

import com.example.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductService{
    void addProduct(Product product);
    Product getById(Long id);
    void deleteProduct(Long id);
    void replaceProduct(Long id, Product product);
    Product findByName(String name);
}
