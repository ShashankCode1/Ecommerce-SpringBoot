package com.phenom.ecommerce.services;

import com.phenom.ecommerce.models.Order;
import com.phenom.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Order Service
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    // Place Order => based on react code
    public String placeOrder(Order order) {
        Order newOrder = new Order();
        newOrder.setCartItems(order.getCartItems());
        newOrder.setTotalCartQuantity(order.getTotalCartQuantity());
        newOrder.setTotalCartPrice(order.getTotalCartPrice());
        newOrder.setShippingInfo(order.getShippingInfo());
        orderRepository.save(newOrder);
        return "Order placed successfully";
    }

    // Get all orders
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    // Delete order by Id
    public String deleteOrderById(String orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            orderRepository.delete(order);
            return "Order deleted successfully";
        } else {
            return "Order Id not found";
        }
    }

    // Get orders count
    public int getOrdersCount() {
        return orderRepository.findOrdersCount();
    }

}
