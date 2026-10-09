package com.example.products.service;

import com.example.products.entity.Product;
import com.example.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void replaceProduct(Long id, Product product) {
        Product product1 = productRepository.findById(id).orElse(null);
        if(product1 != null){
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
        }
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
