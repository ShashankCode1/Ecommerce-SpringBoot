package com.phenom.ecommerce.repositories;

import com.phenom.ecommerce.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

// Order Repository interface
@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    // Custom query to find orders count
    @Query(value = "{}", count = true)
    int findOrdersCount();
}
