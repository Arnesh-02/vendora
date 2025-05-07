package com.vendora.VendorManagementSystem.controller;


import com.vendora.VendorManagementSystem.dto.ProductUpdateRequest;
import com.vendora.VendorManagementSystem.exception.BusinessNotFoundException;
import com.vendora.VendorManagementSystem.exception.ProductNotFoundException;
import com.vendora.VendorManagementSystem.model.Product;
import com.vendora.VendorManagementSystem.services.ProductService;
import com.vendora.VendorManagementSystem.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/{productId}")
    public Product getProductById(String productId) throws ProductNotFoundException {
        return productService.getProductById(productId);
    }

    @PostMapping("/add")
    public String addProduct(Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable String productId,
                                                 @RequestBody ProductUpdateRequest request) throws ProductNotFoundException {
        return productService.updateProduct(productId, request);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable String productId) throws  ProductNotFoundException{
        return  productService.deleteProduct(productId);
    }


    @GetMapping("/business/{businessId}")
    public List<Product> getProductsByBusiness(String businessId) throws BusinessNotFoundException {
        return  productService.getProductsByBusiness(businessId);
    }

    @PatchMapping("/{productId}/deactivate")
    public  Product deactivateProduct(@PathVariable String productId) throws ProductNotFoundException {
        return  productService.deactivateProduct(productId);
    }


//    @PostMapping("/{productId}/vendors")
//    public Product assignVendors(@PathVariable String productId,@RequestParam String )


}
