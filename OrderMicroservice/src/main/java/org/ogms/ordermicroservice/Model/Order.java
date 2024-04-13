package org.ogms.ordermicroservice.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('orders_orderid_seq'")
    @Column(name = "orderid", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "items", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> items;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "time_of_order", nullable = false)
    private Instant timeOfOrder;

    @Column(name = "price", nullable = false)
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