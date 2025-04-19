package com.vendora.VendorManagementSystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder{
    private  String orderId;
    private String businessId;
    private  String vendorId;
    private List<OrderItem> orderItemList;
    private double totalPrice;
    private Status status;


    private LocalDateTime createdAt;
    private  LocalDateTime modifiedAt;

}
