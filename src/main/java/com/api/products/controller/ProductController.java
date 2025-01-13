package com.api.products.controller;


import com.api.products.model.Product;
import com.api.products.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return this.productService.createProduct(product);
    }

    @PutMapping(path = "/{id}")
    public Optional<Product> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        return this.productService.updateProductById(product, id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> getById(@PathVariable Long id) {
        return this.productService.getProductById(id);
    }

    @DeleteMapping(path = "/{id}")
    public Optional<Product> deleteProductById(@PathVariable Long id){
        return this.productService.deleteProductById(id);
    }

}
