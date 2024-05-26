package com.phenom.ecommerce.repositories;

import com.phenom.ecommerce.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    @Query(value = "{}", count = true)
    int findOrdersCount();
}
