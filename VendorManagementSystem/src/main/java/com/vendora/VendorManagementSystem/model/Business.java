package com.vendora.VendorManagementSystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business")
public class Business {
    private String bId;
    private String businessName;
    private String ownerName;
    private String email;
    private String password;
    private String contactNumber;
    private String address;
    private LocalDateTime createdAt;
    private  String gstNumber;

}
