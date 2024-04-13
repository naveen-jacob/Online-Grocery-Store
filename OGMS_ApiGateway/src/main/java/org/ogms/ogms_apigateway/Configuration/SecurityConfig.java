package org.ogms.ogms_apigateway.Configuration;

import org.ogms.ogms_apigateway.Service.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    private final AuthService authService;

    public SecurityConfig(AuthService authService) {
        this.authService = authService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrfSpec -> csrfSpec.disable());

        http.authorizeExchange(c -> c
                .pathMatchers("/login").permitAll()
                .pathMatchers("/register").permitAll()
                .pathMatchers("/api/v1/product/**").permitAll()
                .anyExchange().authenticated()
        );
        return http.build();
    }
}
