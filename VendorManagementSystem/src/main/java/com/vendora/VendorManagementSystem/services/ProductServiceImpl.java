package com.vendora.VendorManagementSystem.services;

import com.vendora.VendorManagementSystem.dto.ProductUpdateRequest;
import com.vendora.VendorManagementSystem.exception.BusinessNotFoundException;
import com.vendora.VendorManagementSystem.exception.ProductNotFoundException;
import com.vendora.VendorManagementSystem.model.Business;
import com.vendora.VendorManagementSystem.model.Product;
import com.vendora.VendorManagementSystem.model.ProductStatus;
import com.vendora.VendorManagementSystem.repository.BusinessRepository;
import com.vendora.VendorManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements  ProductService{

    @Autowired
    ProductRepository productRepo;

    @Autowired
    BusinessRepository businessRepo;
    @Override
    public String addProduct(Product product) {
        productRepo.save(product);
        return "Product Added successfully";
    }

    @Override
    public Product getProductById(String productId) throws ProductNotFoundException {
        Product product=productRepo.findById(productId).orElseThrow(()-> new ProductNotFoundException());
        return product;
    }

    @Override
    public Product updateProduct(String productId, ProductUpdateRequest request) throws ProductNotFoundException {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException());

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setStatus(request.getProductStatus());

        return productRepo.save(product);
    }

    @Override
    public String deleteProduct(String productId) throws ProductNotFoundException {
        Optional<Product> product= productRepo.findById(productId);
        if(!product.isPresent()){
            throw  new ProductNotFoundException();
        }
        productRepo.deleteById(productId);
        return "Product deleted successfully";
    }

    @Override
    public List<Product> getProductsByBusiness(String businessId)  throws  BusinessNotFoundException{
        Business business =businessRepo.findById(businessId).orElseThrow(()-> new BusinessNotFoundException());
        return  productRepo.findProductByBusinessIdAndActiveTrue(businessId);
    }

    @Override
    public Product deactivateProduct(String productId) throws ProductNotFoundException {
        Product product=productRepo.findById(productId).orElseThrow(()-> new ProductNotFoundException());
        product.setStatus(ProductStatus.Deactivated);
        return product;
    }
}
