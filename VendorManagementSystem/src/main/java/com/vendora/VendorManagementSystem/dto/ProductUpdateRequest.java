package com.vendora.VendorManagementSystem.dto;

import com.vendora.VendorManagementSystem.model.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductUpdateRequest {
    private String name;
    private String description;
    private double price;
    private int stock;
    private ProductStatus productStatus;
}
