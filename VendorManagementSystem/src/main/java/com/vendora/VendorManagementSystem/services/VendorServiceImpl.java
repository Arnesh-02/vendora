package com.vendora.VendorManagementSystem.services;


import com.vendora.VendorManagementSystem.exception.UserNotFoundException;
import com.vendora.VendorManagementSystem.exception.VendorNotFoundException;
import com.vendora.VendorManagementSystem.model.Vendor;
import com.vendora.VendorManagementSystem.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import  com.vendora.VendorManagementSystem.model.Vendor;

@Service
public class VendorServiceImpl implements  VendorService{

    @Autowired
    VendorRepository vendorRepository;

    public Optional<Vendor> getVendorById(String id) throws VendorNotFoundException {
        Optional<Vendor> vendor=vendorRepository.findById(id);
        if(vendor.isPresent()){
            return  vendor;
        }
        else{
            throw  new VendorNotFoundException("No such vendor exists");
        }
    }

    public List<Vendor> getVendorByBusiness(String businessId) {
        return vendorRepository.findByBusinessId(businessId);
    }

    public Optional<Vendor> updateVendor(String vendorId, Vendor updatedVendor) {
        Optional<Vendor> oldDetailsVendor=vendorRepository.findById(vendorId);
        if(oldDetailsVendor.isPresent()){
            Vendor vendor=oldDetailsVendor.get();
            vendor.setVendorName(updatedVendor.getVendorName());
            vendor.setAddress(updatedVendor.getAddress());
            vendor.setCategory(updatedVendor.getCategory());
            vendor.setEmail(updatedVendor.getEmail());
            vendor.setContactNo(updatedVendor.getContactNo());
            vendor.setGstNumber(updatedVendor.getGstNumber());
           return Optional.of(vendorRepository.save(vendor));
        }
        else{
            throw  new VendorNotFoundException("No such vendor exists");
        }
    }

}
