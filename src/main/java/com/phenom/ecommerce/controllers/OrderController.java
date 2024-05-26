package com.phenom.ecommerce.controllers;

import com.phenom.ecommerce.models.Order;
import com.phenom.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Order Controller
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrderById(@PathVariable String orderId) {
        return orderService.deleteOrderById(orderId);
    }

    @GetMapping("/count")
    public int getOrdersCount() {
        return orderService.getOrdersCount();
    }
}
