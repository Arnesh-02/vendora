package com.vendora.VendorManagementSystem.exception;

public class BusinessNotFoundException extends RuntimeException {
    public  BusinessNotFoundException(){
        super("No such business exists");
    }
    public BusinessNotFoundException(String message) {
        super(message);
    }
}
