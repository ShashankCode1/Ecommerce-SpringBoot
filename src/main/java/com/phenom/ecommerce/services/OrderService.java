package com.phenom.ecommerce.services;

import com.phenom.ecommerce.models.Order;
import com.phenom.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public String placeOrder(Order order) {
        Order newOrder = new Order();
        newOrder.setCartItems(order.getCartItems());
        newOrder.setTotalCartQuantity(order.getTotalCartQuantity());
        newOrder.setTotalCartPrice(order.getTotalCartPrice());
        newOrder.setShippingInfo(order.getShippingInfo());
        orderRepository.save(newOrder);
        return "Order placed successfully";
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public int getOrdersCount() {
        return orderRepository.findOrdersCount();
    }
}
