package org.ogms.frontend.DTO;

import com.nimbusds.jose.shaded.gson.Gson;

public class ItemDTO {
    private final String key;
    private final int value;
    private final String productName;

    public ItemDTO(String key, int value, String productName) {
        this.key = key;
        this.value = value;
        this.productName = productName;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public String getProductName() {
        return productName;
    }
}