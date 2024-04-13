package org.ogms.ogms_apigateway.Controller;

import org.ogms.ogms_apigateway.Model.UserPass;
import org.ogms.ogms_apigateway.Service.UserPassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@RestController
public class UserController {
    private final UserPassService userPassService;

    public UserController(UserPassService userPassService) {
        this.userPassService = userPassService;
    }

    @GetMapping("/login")
    public Mono<HashMap<String, Boolean>> login(@RequestBody UserPass userPass) {
        HashMap<String, Boolean> map = new HashMap<>();
        Mono<Boolean> cond = userPassService.exists(userPass);
        cond.subscribe(value -> map.put("isValid", value));

        return Mono.create(monoSink -> monoSink.success(map));
    }

    @GetMapping("/login2")
    public ResponseEntity<Boolean> login2() {
        return ResponseEntity.ok(true);
    }

    @GetMapping("/user")
    public Mono<String> user(){
        return ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getName);
    }

    @GetMapping("/all")
    public Flux<UserPass> allusers(){
        return userPassService.getAllUsers();
    }

    @GetMapping("/user/{username}")
    public Mono<UserPass> getuser(@PathVariable String username){
        return userPassService.getUser(username);
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<String>> register(@RequestBody UserPass userPass){
        return userPassService.saveUser(userPass)
                .map(savedUser -> new ResponseEntity<>("Registered", HttpStatus.CREATED));
    }
}
