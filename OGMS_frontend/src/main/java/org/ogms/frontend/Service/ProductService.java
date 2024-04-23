package org.ogms.frontend.Service;

import org.ogms.frontend.Model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ProductService {
    private final RestClient restClient;

    @Value("${ogms.gateway.url}")
    private String gateway_endpoint;

    public ProductService() {
        this.restClient = RestClient.create();
    }

    public List<Product> getProducts() {
        ResponseEntity<List<Product>> response = restClient.get()
                .uri(gateway_endpoint+"/api/v1/product/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<Product>>() {});

        return response.getBody();
    }

    public Product getProduct(String id) {
        ResponseEntity<Product> response = restClient.get()
                .uri(gateway_endpoint+"/api/v1/product/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<Product>() {});

        return response.getBody();
    }
}
