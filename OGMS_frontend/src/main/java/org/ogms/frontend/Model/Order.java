package org.ogms.frontend.Model;

import java.time.Instant;
import java.util.Map;

public class Order {
    private Integer id;

    private String username;

    private Map<String, Object> items;

    private String address;

    private Instant timeOfOrder;

    private Long price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, Object> getItems() {
        return items;
    }

    public void setItems(Map<String, Object> items) {
        this.items = items;
    }

    public Instant getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder(Instant timeOfOrder) {
        this.timeOfOrder = timeOfOrder;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}