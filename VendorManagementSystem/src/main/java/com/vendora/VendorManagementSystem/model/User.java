package com.vendora.VendorManagementSystem.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {
    private  String userId;
    private  String name;
    private String password;
    private String email;

    private  String phoneNo;

    private String shop_id;

    private String role; // manager finance and admin

    private LocalDateTime createdAt;

}
