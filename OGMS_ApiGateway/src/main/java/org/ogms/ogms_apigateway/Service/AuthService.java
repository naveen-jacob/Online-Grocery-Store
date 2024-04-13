package org.ogms.ogms_apigateway.Service;

import org.ogms.ogms_apigateway.Model.UserPass;
import org.ogms.ogms_apigateway.Repository.UserPassRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthService implements ReactiveUserDetailsService {
    private final UserPassRepository repository;

    public AuthService(UserPassRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        Mono<UserPass> user = repository.findByUsername(username);
        return user.cast(UserDetails.class);
    }
}
