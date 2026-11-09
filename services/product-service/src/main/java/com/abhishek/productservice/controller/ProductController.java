package com.abhishek.productservice.controller;

import com.abhishek.productservice.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final List<Product> products = List.of(
        new Product(1, "Laptop", 55000),
        new Product(2, "Mobile", 25000),
        new Product(3, "Headphones", 3000)
    );

    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }
}
