package org.ogms.frontend.Service;

import org.ogms.frontend.Model.Cart;
import org.ogms.frontend.Model.Credentials;
import org.ogms.frontend.Model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

import java.util.Map;
import java.util.Objects;

@Service
public class CartService {
    private final RestClient restClient;
    private final Credentials credentials;
    private final Cart cart;

    @Value("${ogms.gateway.url}")
    private String gateway_endpoint;

    public CartService(Credentials credentials, Cart cart) {
        this.credentials = credentials;
        this.cart = cart;
        this.restClient = RestClient.create();
    }

    public void getCart() {
        ResponseEntity<Cart> response = restClient.get()
                .uri(gateway_endpoint+"/api/v1/cart/get")
                .header("Authorization", "Basic " + credentials.getEncodedAuth())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<Cart>() {});

        this.cart.setCart(Objects.requireNonNull(response.getBody()));
    }

    public void addProduct(Product product) {
        Map<String, Integer> cartItems = cart.getItems();
        String productId = String.valueOf(product.getId());
        cartItems.putIfAbsent(productId, 0);

        Integer quantity = cartItems.get(productId);
        cartItems.put(productId, ++quantity);
        cart.setItems(cartItems);

        if (credentials.isAuthenticated()) {
            updateUpstream();
        }
    }

    public void removeProduct(String productId) {
        Map<String, Integer> cartItems = cart.getItems();

        Integer quantity = cartItems.get(productId);

        if (quantity.equals(1)){
            cartItems.remove(productId);
        }
        else {
            cartItems.put(productId, --quantity);
        }
        cart.setItems(cartItems);

        if (credentials.isAuthenticated()) {
            updateUpstream();
        }
    }

    public void updateUpstream() {
        try {
            ResponseEntity<Cart> response = restClient.put()
                    .uri(gateway_endpoint+"/api/v1/cart/update")
                    .header("Authorization", "Basic " + credentials.getEncodedAuth())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(cart)
                    .retrieve()
                    .toEntity(new ParameterizedTypeReference<Cart>() {});

            if (response.getStatusCode().is2xxSuccessful()) {
                // Success! Cart updated on the server.
            } else {
                // Handle error, e.g., log the error or display an error message to the user.
                System.out.println("Error updating cart on server: " + response.getStatusCode());
            }
        } catch (RestClientResponseException e) {
            // Handle potential exceptions during the request execution.
            System.out.println("Error communicating with server: " + e.getMessage());
        }
    }
}
