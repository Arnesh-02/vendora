package com.vendora.VendorManagementSystem.services;


import com.vendora.VendorManagementSystem.model.Business;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BusinessService {
    public Optional<Business> getById(String id);
    public  Business updatebusiness(String bId,Business updatedBusiness);
    public String assignBusinessToUser(String bId,String userid);
    public List<Business> getAllBusiness();
    public ResponseEntity<String> deactivateBusiness(String id);
    public List<Business> getBusinessesByUserId(String userId);

}
