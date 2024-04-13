package org.ogms.frontend.Model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cart {
    private String username;

    private Map<String, Integer> items = new HashMap<>();

    public Cart() {
        this.username = null;
    }

    public void setCart(Cart cart) {
        this.username = cart.getUsername();
        this.items = cart.getItems();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }
}