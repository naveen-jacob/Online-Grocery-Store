package org.ogms.ordermicroservice.Repository;

import org.ogms.ordermicroservice.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUsername(String username);
}