package com.vendora.VendorManagementSystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orderItem")
public class OrderItem {//details that BUSINESS give to order a item indiviually
   private String productId;
   private String productName;
   private double price;
   private  int quantity;

}
