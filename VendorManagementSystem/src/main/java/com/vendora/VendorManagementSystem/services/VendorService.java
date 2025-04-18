package com.vendora.VendorManagementSystem.services;


import com.vendora.VendorManagementSystem.exception.UserNotFoundException;
import com.vendora.VendorManagementSystem.model.Vendor;
import com.vendora.VendorManagementSystem.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    public Optional<Vendor> getVendorById(String id) throws UserNotFoundException {
        return vendorRepository.findById(id);
    }
}
