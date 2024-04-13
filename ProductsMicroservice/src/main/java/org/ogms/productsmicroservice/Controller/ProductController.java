package org.ogms.productsmicroservice.Controller;

import org.ogms.productsmicroservice.Model.Product;
import org.ogms.productsmicroservice.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    ResponseEntity<List<Product>> getAllProducts() {return productService.getAllProducts();}

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id) {return productService.getProductById(id);}

}
