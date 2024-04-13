package org.ogms.cartmicroservice.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "usercart")
public class Usercart {
    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "items", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> items = new HashMap<String, Object>();

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

}