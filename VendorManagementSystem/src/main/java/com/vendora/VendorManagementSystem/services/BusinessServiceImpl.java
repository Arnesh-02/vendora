package com.vendora.VendorManagementSystem.services;


import com.vendora.VendorManagementSystem.exception.BusinessNotFoundException;
import com.vendora.VendorManagementSystem.model.Business;
import com.vendora.VendorManagementSystem.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessRepository businessRepo;
    @Override
    public Optional<Business> getById(String id) {
        Optional<Business> business=businessRepo.findById(id);
        if(business.isPresent()){
            return business;
        }
        throw  new BusinessNotFoundException();
    }

    @Override
    public Business updatebusiness(String bId, Business updatedBusiness) {
        Optional<Business> old=businessRepo.findById(bId);
        if(old.isPresent()){
//            old.se
            return null;
        }
        return updatedBusiness;
    }

    @Override
    public String assignBusinessToUser(String bId, String userid) {
        return "";
    }

    @Override
    public List<Business> getAllBusiness() {
        return List.of();
    }

    @Override
    public ResponseEntity<String> deactivateBusiness(String id) {
        return null;
    }

    @Override
    public List<Business> getBusinessesByUserId(String userId) {
        return List.of();
    }
}
