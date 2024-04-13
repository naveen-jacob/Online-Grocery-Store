package org.ogms.cartmicroservice.Service;

import org.ogms.cartmicroservice.Model.Usercart;
import org.ogms.cartmicroservice.Repository.UsercartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsercartService {
    private final UsercartRepository usercartRepository;

    public UsercartService(UsercartRepository usercartRepository) {
        this.usercartRepository = usercartRepository;
    }

    public ResponseEntity<Usercart> getByUsername(String username) {
        Usercart cart = usercartRepository.findByUsername(username);
        if (cart == null) {
            cart = new Usercart();
            cart.setUsername(username);
            usercartRepository.save(cart);
        }
        return ResponseEntity.ok(cart);
    }

    public ResponseEntity<Usercart> updateCart(Usercart cart) {
        return ResponseEntity.ok(usercartRepository.save(cart));
    }
}
