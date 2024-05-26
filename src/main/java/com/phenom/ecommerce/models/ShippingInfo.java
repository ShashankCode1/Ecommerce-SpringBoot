package com.phenom.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

// ShippingInfo model class holds user info & address
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class ShippingInfo {
    private String userId;
    private String userName;
    private String email;
    private String phoneNo;
    private Address shippingAddress;
}
