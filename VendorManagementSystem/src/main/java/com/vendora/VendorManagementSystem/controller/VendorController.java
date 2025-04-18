package com.vendora.VendorManagementSystem.controller;


import com.vendora.VendorManagementSystem.exception.UserNotFoundException;
import com.vendora.VendorManagementSystem.model.Vendor;
import com.vendora.VendorManagementSystem.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @GetMapping("/{id}")
    public Optional<Vendor> getVendorById(@PathVariable String id) throws UserNotFoundException {
        return vendorService.getVendorById(id);
    }
}
