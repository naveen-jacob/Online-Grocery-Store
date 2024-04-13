package org.ogms.frontend.DTO;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

public class CredentialsDTO {
    private String username;
    private String password;
    private final RestClient restClient;

    public CredentialsDTO(String username, String password) {
        this.username = username;
        this.password = password;
        String Auth = username + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(Auth.getBytes(StandardCharsets.UTF_8));
        restClient = RestClient.builder()
                .defaultHeader("Authorization", "Basic " + encodedAuth)
                .build();
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

    public boolean isValid(){
        ResponseEntity<Boolean> response = restClient.get()
                .uri("http://localhost:9000/login2")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<Boolean>() {});
        return Boolean.TRUE.equals(response.getBody());

    }

    public boolean signUp(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username", this.username);
        hashMap.put("password", this.password);
        ResponseEntity<Boolean> response = restClient.post()
                .uri("http://localhost:9000/register")
                .contentType(MediaType.APPLICATION_JSON)
                .body(hashMap)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<Boolean>() {});
        return Boolean.TRUE.equals(response.getBody());
    }
}
