package com.vendora.VendorManagementSystem.services;


import com.vendora.VendorManagementSystem.model.Business;

import java.util.Optional;

public interface BusinessService {
    public Optional<Business> getById(String id);
}
