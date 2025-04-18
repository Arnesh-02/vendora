package com.vendora.VendorManagementSystem.repository;

import com.vendora.VendorManagementSystem.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
