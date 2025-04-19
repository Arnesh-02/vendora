package com.vendora.VendorManagementSystem.repository;

import com.vendora.VendorManagementSystem.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    List<Product> findProductByBusinessIdAndActiveTrue(String businessId);
}
