package com.vendora.VendorManagementSystem.repository;

import com.vendora.VendorManagementSystem.model.PurchaseOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends MongoRepository<PurchaseOrder,String>{
}
