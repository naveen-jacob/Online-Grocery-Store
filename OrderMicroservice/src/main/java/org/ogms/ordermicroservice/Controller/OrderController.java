package org.ogms.ordermicroservice.Controller;

import org.ogms.ordermicroservice.Model.Order;
import org.ogms.ordermicroservice.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order/")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/get")
    ResponseEntity<List<Order>> getOrders(@RequestHeader("Authorization") String token){
        return orderService.getByUsername(auth2username(token));
    }

    @PostMapping("/add")
    ResponseEntity<String> addOrder(@RequestHeader("Authorization") String token, @RequestBody Order order){
        Order newOrder = new Order();
        newOrder.setUsername(auth2username(token));
        newOrder.setAddress(order.getAddress());
        newOrder.setTimeOfOrder(order.getTimeOfOrder());
        newOrder.setItems(order.getItems());
        newOrder.setPrice(order.getPrice());
        return orderService.addOrder(newOrder);
    }

    private String auth2username(String base64){
        String encoded = base64.split(" ")[1];
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        String decodedString = new String(decodedBytes);
        String username = decodedString.split(":")[0];
        return username;
    }
}
