package com.api.products.service;


import com.api.products.model.Product;
import com.api.products.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public Optional<Product> getProductById(Long id) {
        try {
            return productRepository.findById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Product createProduct(Product request){
        try {
            return productRepository.save(request);
        } catch (Exception e) {
            return null;
        }
     }

    public Optional<Product> updateProductById(Product request, Long id){
        try {
            return productRepository.findById(id).map(product -> {
                product.setName(request.getName());
                product.setDescription(request.getDescription());
                product.setPrice(request.getPrice());
                product.setCategory(request.getCategory());
                return productRepository.save(product);
            });
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Product> deleteProductById(Long id){
        return productRepository.findById(id).map(product -> {
            productRepository.delete(product);
            return product;
        });
    }
}
