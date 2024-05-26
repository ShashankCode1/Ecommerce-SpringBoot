package com.phenom.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

// Order model class
// holds the cart items, total cart quantity, total cart price and shipping information
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Order {
    @Id
    private String orderId;
    private List<Cart> cartItems;
    private int totalCartQuantity;
    private int totalCartPrice;
    private ShippingInfo shippingInfo;
}
