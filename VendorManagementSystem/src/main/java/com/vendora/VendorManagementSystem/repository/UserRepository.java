package com.vendora.VendorManagementSystem.repository;

import com.vendora.VendorManagementSystem.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    List<User> findByBusinessId(String businessId);
}
