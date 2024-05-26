package com.phenom.ecommerce.repositories;

import com.phenom.ecommerce.models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address, String> {

}
