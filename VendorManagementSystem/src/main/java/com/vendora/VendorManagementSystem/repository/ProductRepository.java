package com.vendora.VendorManagementSystem.repository;

import com.vendora.VendorManagementSystem.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
}
