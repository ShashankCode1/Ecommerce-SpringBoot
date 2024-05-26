package com.phenom.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

// Cart model class holds the product and its quantity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Cart {
    private Product product;
    private int quantity;
}
