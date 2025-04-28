package com.vendora.VendorManagementSystem.repository;


import com.vendora.VendorManagementSystem.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends MongoRepository<Vendor,String> {
    List<Vendor> findByBusinessId(String businessId);
}
