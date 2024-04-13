package org.ogms.cartmicroservice.Repository;

import org.ogms.cartmicroservice.Model.Usercart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsercartRepository extends JpaRepository<Usercart, String> {
    Usercart findByUsername(String username);
}