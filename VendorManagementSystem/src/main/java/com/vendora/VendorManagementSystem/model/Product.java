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
    private int quantity;
    private String unit;//measurement litres,..

    private String businessId;
    private String vendorId;

}
