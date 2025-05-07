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
    public Business createBusiness(Business business) {
        business.setCreatedAt(java.time.LocalDateTime.now());
        business.setActive(true); // Default to active
        return businessRepo.save(business);
    }

    @Override
    public Optional<Business> getById(String id) {
        Optional<Business> business = businessRepo.findById(id);
        if (business.isPresent()) {
            return business;
        }
        throw new BusinessNotFoundException("Business with ID " + id + " not found.");
    }

    @Override
    public Business updatebusiness(String bId, Business updatedBusiness) {
        Optional<Business> oldBusiness = businessRepo.findById(bId);
        if (oldBusiness.isPresent()) {
            Business existingBusiness = oldBusiness.get();
            existingBusiness.setBusinessName(updatedBusiness.getBusinessName());
            existingBusiness.setOwnerName(updatedBusiness.getOwnerName());
            existingBusiness.setEmail(updatedBusiness.getEmail());
            existingBusiness.setPassword(updatedBusiness.getPassword());
            existingBusiness.setContactNumber(updatedBusiness.getContactNumber());
            existingBusiness.setAddress(updatedBusiness.getAddress());
            existingBusiness.setGstNumber(updatedBusiness.getGstNumber());
            existingBusiness.setActive(updatedBusiness.isActive());
            existingBusiness.setUserIds(updatedBusiness.getUserIds());
            return businessRepo.save(existingBusiness);
        }
        throw new BusinessNotFoundException("Business with ID " + bId + " not found.");
    }

    @Override
    public String assignBusinessToUser(String bId, String userId) {
        Optional<Business> business = businessRepo.findById(bId);
        if (business.isPresent()) {
            Business existingBusiness = business.get();
            List<String> userIds = existingBusiness.getUserIds();
            if (!userIds.contains(userId)) {
                userIds.add(userId);
                existingBusiness.setUserIds(userIds);
                businessRepo.save(existingBusiness);
                return "User " + userId + " has been assigned to the business.";
            }
            return "User already assigned to the business.";
        }
        throw new BusinessNotFoundException("Business with ID " + bId + " not found.");
    }

    @Override
    public List<Business> getAllBusiness() {
        return businessRepo.findAll();
    }

    @Override
    public ResponseEntity<String> deactivateBusiness(String id) {
        Optional<Business> business = businessRepo.findById(id);
        if (business.isPresent()) {
            Business existingBusiness = business.get();
            existingBusiness.setActive(false);
            businessRepo.save(existingBusiness);
            return ResponseEntity.ok("Business with ID " + id + " has been deactivated.");
        }
        throw new BusinessNotFoundException("Business with ID " + id + " not found.");
    }

//    @Override
//    public List<Business> getBusinessesByUserId(String userId) {
//        return businessRepo.findByUserIdsContaining(userId);
//    }
}
