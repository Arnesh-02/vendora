package com.vendora.VendorManagementSystem.services;


import com.vendora.VendorManagementSystem.exception.BusinessNotFoundException;
import com.vendora.VendorManagementSystem.model.Business;
import com.vendora.VendorManagementSystem.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
