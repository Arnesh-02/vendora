package com.vendora.VendorManagementSystem.repository;

import com.vendora.VendorManagementSystem.model.Business;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BusinessRepository extends MongoRepository<Business,String> {
}
