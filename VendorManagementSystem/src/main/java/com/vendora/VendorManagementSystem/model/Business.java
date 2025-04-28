package com.vendora.VendorManagementSystem.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
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
    private List<String> userIds;
    private boolean active;
}
