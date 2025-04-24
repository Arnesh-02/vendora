package com.vendora.VendorManagementSystem.controller;

import com.vendora.VendorManagementSystem.model.Business;
import com.vendora.VendorManagementSystem.services.BusinessService;
import com.vendora.VendorManagementSystem.services.BusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("/business")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @GetMapping("/{id}")
    public Optional<Business> getBusinessById(@PathVariable String id){
        return businessService.getById(id);
    }



}
