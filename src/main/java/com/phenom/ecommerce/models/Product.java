package com.phenom.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Product model class
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Product {
    @Id
    private String prodId;
    private String prodName;
    private String category;
    private String description;
    private double price;
    private String imageURL;
}
