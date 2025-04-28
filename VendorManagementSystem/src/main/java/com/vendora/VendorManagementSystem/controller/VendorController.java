package com.vendora.VendorManagementSystem.controller;


import com.vendora.VendorManagementSystem.exception.UserNotFoundException;
import com.vendora.VendorManagementSystem.model.Vendor;
import com.vendora.VendorManagementSystem.services.VendorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    VendorServiceImpl vendorService;

    @GetMapping("/{id}")
    public Optional<Vendor> getVendorById(@PathVariable String id) throws UserNotFoundException {
        return vendorService.getVendorById(id);
    }

    @GetMapping("/{business}/{businessId}")
    public List<Vendor> getVendorByBusiness(@PathVariable String businessId){
        return  vendorService.getVendorByBusiness(businessId);
    }

    @PostMapping("/update/{id}")
    public Optional<Vendor> updateVendor(@PathVariable String vendorId,@RequestBody Vendor updatedVendor){
        return vendorService.updateVendor(vendorId,updatedVendor);
    }
}
