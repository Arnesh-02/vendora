package com.vendora.VendorManagementSystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Vendor {
    private  String id;
    private String vendorName;
    private String address;
    private String gstNumber;
    private String email;
    private String contactNo;
    private String category;// what product they sell
    private  String businessId;
    private LocalDateTime createdAt;

}
