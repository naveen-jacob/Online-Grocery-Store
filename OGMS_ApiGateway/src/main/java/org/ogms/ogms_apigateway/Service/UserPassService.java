package org.ogms.ogms_apigateway.Service;

import org.ogms.ogms_apigateway.Model.UserPass;
import org.ogms.ogms_apigateway.Repository.UserPassRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Service
public class UserPassService {
    private final UserPassRepository UserPassRepository;
    private final PasswordEncoder passwordEncoder;
    String existingPassword;
    Logger logger;

    public UserPassService(org.ogms.ogms_apigateway.Repository.UserPassRepository userPassRepository, PasswordEncoder passwordEncoder) {
        this.UserPassRepository = userPassRepository;
        this.passwordEncoder = passwordEncoder;
        logger = Logger.getLogger(this.getClass().getName());
    }

    public Flux<UserPass> getAllUsers() {
        return UserPassRepository.findAll();
    }

    public Mono<UserPass> getUser(String username) {
        return UserPassRepository.findByUsername(username);
    }

    public Mono<Boolean> exists(UserPass userPass) {
        UserPass user = new UserPass(userPass.getUsername(), userPass.getPassword());
        Mono<UserPass> existingUser = UserPassRepository.findByUsername(user.getUsername());
        Mono<String> existingPasswordMono = existingUser.map(UserPass::getPassword);
        existingPasswordMono.subscribe(value -> {
                    existingPassword = value;
                    logger.info(existingPassword);
                }
        );
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (passwordEncoder.matches(userPass.getPassword(), existingPassword)) {
            return Mono.just(true);
        }
        else {
            return Mono.just(false);
        }
    }

    public Mono<UserPass> saveUser(UserPass userPass) {
        return UserPassRepository.save(userPass);
    }
}
