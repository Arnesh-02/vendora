package com.vendora.VendorManagementSystem.services;

import com.vendora.VendorManagementSystem.dto.ProductUpdateRequest;
import com.vendora.VendorManagementSystem.exception.BusinessNotFoundException;
import com.vendora.VendorManagementSystem.exception.ProductNotFoundException;
import com.vendora.VendorManagementSystem.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {

    String addProduct(Product product);

    Product getProductById(String productId) throws ProductNotFoundException;

    Product updateProduct(String productId, ProductUpdateRequest request) throws ProductNotFoundException;

    String deleteProduct(@PathVariable String productId)throws  ProductNotFoundException;

    List<Product> getProductsByBusiness(String businessId) throws BusinessNotFoundException;

    Product deactivateProduct(@PathVariable String productId) throws ProductNotFoundException;
}


