package com.example.products.controller;


import com.example.products.entity.Product;
import com.example.products.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Tag(name = "products controller")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){productService.deleteProduct(id);}

    @GetMapping("{id}")
    public Product getById(@PathVariable Long id){return productService.getById(id);}

    @GetMapping()
    public Product getGetByName(@RequestParam("name") String name){return productService.findByName(name);}

    @PutMapping("{id}")
    public void replace(@PathVariable Long id,@RequestBody Product product){productService.replaceProduct(id, product);}

    @PostMapping()
    public void add(@RequestBody Product product){productService.addProduct(product);}
}
