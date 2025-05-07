package com.vendora.VendorManagementSystem.services;

import com.vendora.VendorManagementSystem.exception.VendorNotFoundException;
import com.vendora.VendorManagementSystem.model.Vendor;

import java.util.List;
import java.util.Optional;


public interface VendorService {
    Vendor createVendor(Vendor vendor);
    Optional<Vendor> getVendorById(String id) throws VendorNotFoundException;
    List<Vendor> getVendorByBusiness(String businessId);
    Optional<Vendor> updateVendor(String vendorId, Vendor updatedVendor) throws VendorNotFoundException;
    void deleteVendor(String vendorId) throws VendorNotFoundException;
    List<Vendor> getAllVendors();
}