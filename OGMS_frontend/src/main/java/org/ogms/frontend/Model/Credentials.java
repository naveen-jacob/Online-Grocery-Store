package org.ogms.frontend.Model;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class Credentials {
    private String username;
    private String password;
    private String encodedAuth;

    public Credentials() {
        this.username = null;
        this.password = null;
        this.encodedAuth = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncodedAuth() {
        String Auth = username + ":" + password;
        this.encodedAuth = Base64.getEncoder().encodeToString(Auth.getBytes(StandardCharsets.UTF_8));
        return encodedAuth;
    }

    public void setEncodedAuth(String encodedAuth) {
        this.encodedAuth = encodedAuth;
    }

    public void reset(){
        this.username = null;
        this.password = null;
        this.encodedAuth = null;
    }

    public Boolean isAuthenticated() {
        return this.username != null && this.password != null;
    }
}
