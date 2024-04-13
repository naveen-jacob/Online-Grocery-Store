package org.ogms.productsmicroservice.Service;

import org.ogms.productsmicroservice.Model.Product;
import org.ogms.productsmicroservice.Repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    public ResponseEntity<Product> getProductById(Long id) {
        return ResponseEntity.ok(productRepository.findById(id).orElse(null));
    }
}
