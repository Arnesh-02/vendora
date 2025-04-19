package com.vendora.VendorManagementSystem.exception;

public class ProductNotFoundException extends  Exception{
    public ProductNotFoundException(){
        super("Product is not available");
    }

    public ProductNotFoundException(String message){
        super(message);
    }
}
