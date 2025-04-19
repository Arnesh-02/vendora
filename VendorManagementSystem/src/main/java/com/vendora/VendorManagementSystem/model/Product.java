package com.vendora.VendorManagementSystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product {
    private String id;
    private String name;
    private double price;
    private String category;//led bulbs
    private String description;
    private int stock;
    private String unit;//measurement litres,..
    private  ProductStatus status; // product deleted or deactivated
    private String businessId;
    private String vendorId;
}
