package org.ogms.cartmicroservice.Controller;

import org.ogms.cartmicroservice.Model.Usercart;
import org.ogms.cartmicroservice.Service.UsercartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/api/v1/cart/")
public class CartController {
    private final UsercartService usercartService;

    public CartController(UsercartService usercartService) {
        this.usercartService = usercartService;
    }

    @GetMapping("/get")
    ResponseEntity<Usercart> getByUsername(@RequestHeader("Authorization") String token){
        return usercartService.getByUsername(auth2username(token));
    }

    @PutMapping("/update")
    ResponseEntity<Usercart> updateCart(@RequestHeader("Authorization") String token, @RequestBody Usercart usercart){
        Usercart cart = new Usercart();
        cart.setUsername(auth2username(token));
        cart.setItems(usercart.getItems());
        return usercartService.updateCart(cart);
    }

    private String auth2username(String base64){
        String encoded = base64.split(" ")[1];
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        String decodedString = new String(decodedBytes);
        String username = decodedString.split(":")[0];
        return username;
    }
}
