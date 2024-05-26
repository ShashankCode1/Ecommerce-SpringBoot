package com.phenom.ecommerce.repositories;

import com.phenom.ecommerce.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Query(value = "{}", count = true)
    int findProductsCount();
}
