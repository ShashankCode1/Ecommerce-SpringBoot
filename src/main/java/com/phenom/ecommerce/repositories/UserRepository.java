package com.phenom.ecommerce.repositories;

import com.phenom.ecommerce.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query(value = "{}", count = true)
    int findUsersCount();
}
