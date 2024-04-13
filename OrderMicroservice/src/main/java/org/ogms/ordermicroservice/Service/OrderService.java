package org.ogms.ordermicroservice.Service;

import org.aspectj.weaver.ast.Or;
import org.ogms.ordermicroservice.Model.Order;
import org.ogms.ordermicroservice.Repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public ResponseEntity<List<Order>> getByUsername(String username) {
        return ResponseEntity.ok(orderRepository.findByUsername(username));
    }
    public ResponseEntity<String> addOrder(Order order) {
        orderRepository.save(order);
        return ResponseEntity.ok("Added Order");
    }
}
