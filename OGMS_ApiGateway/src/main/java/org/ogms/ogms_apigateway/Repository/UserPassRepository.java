package org.ogms.ogms_apigateway.Repository;

import org.ogms.ogms_apigateway.Model.UserPass;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserPassRepository extends ReactiveCrudRepository<UserPass, String> {
    Mono<UserPass> findByUsername(String username);
    Flux<UserPass> findAll();
}