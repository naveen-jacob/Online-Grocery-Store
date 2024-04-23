package org.ogms.frontend.Service;

import org.ogms.frontend.Model.Order;
import org.ogms.frontend.Model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OrderService {
    private final RestClient restClient;

    @Value("${ogms.gateway.url}")
    private String gateway_endpoint;

    public OrderService() {
        this.restClient = RestClient.create();
    }

    public List<Order> getOrders() {
        ResponseEntity<List<Order>> response = restClient.get()
                .uri(gateway_endpoint+"/api/v1/cart/get")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<Order>>() {});

        return response.getBody();
    }
}
