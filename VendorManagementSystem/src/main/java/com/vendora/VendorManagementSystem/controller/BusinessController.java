package com.vendora.VendorManagementSystem.controller;

import com.vendora.VendorManagementSystem.model.Business;
import com.vendora.VendorManagementSystem.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping("/create")
    public ResponseEntity<String> createBusiness(@RequestBody Business business) {
        Business createdBusiness = businessService.createBusiness(business);
        return ResponseEntity.ok("Business created with ID: " + createdBusiness.getBId());
    }

    @GetMapping("/{id}")
    public Optional<Business> getBusinessById(@PathVariable String id) {
        return businessService.getById(id);
    }

    @PutMapping("/{bId}")
    public Business updateBusiness(@PathVariable String bId, @RequestBody Business updatedBusiness) {
        return businessService.updatebusiness(bId, updatedBusiness);
    }

    @PostMapping("/assign/{bId}/{userId}")
    public String assignBusinessToUser(@PathVariable String bId, @PathVariable String userId) {
        return businessService.assignBusinessToUser(bId, userId);
    }

    @GetMapping("/all")
    public List<Business> getAllBusiness() {
        return businessService.getAllBusiness();
    }

    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateBusiness(@PathVariable String id) {
        return businessService.deactivateBusiness(id);
    }

//    @GetMapping("/user/{userId}")
//    public List<Business> getBusinessesByUserId(@PathVariable String userId) {
//        return businessService.getBusinessesByUserId(userId);
//    }
}
