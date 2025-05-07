package com.vendora.VendorManagementSystem.controller;

import com.vendora.VendorManagementSystem.exception.VendorNotFoundException;
import com.vendora.VendorManagementSystem.model.Vendor;
import com.vendora.VendorManagementSystem.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping("/{id}")
    public Optional<Vendor> getVendorById(@PathVariable String id) throws VendorNotFoundException {
        return vendorService.getVendorById(id);
    }

    @GetMapping("/business/{businessId}")
    public List<Vendor> getVendorByBusiness(@PathVariable String businessId) {
        return vendorService.getVendorByBusiness(businessId);
    }

    @PostMapping("/create")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @PatchMapping("/update/{vendorId}")
    public Optional<Vendor> updateVendor(@PathVariable String vendorId, @RequestBody Vendor updatedVendor) throws VendorNotFoundException {
        return vendorService.updateVendor(vendorId, updatedVendor);
    }

    @DeleteMapping("/delete/{vendorId}")
    public String deleteVendor(@PathVariable String vendorId) throws VendorNotFoundException {
        vendorService.deleteVendor(vendorId);
        return "Vendor deleted successfully!";
    }

    @GetMapping("/all")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }
}
