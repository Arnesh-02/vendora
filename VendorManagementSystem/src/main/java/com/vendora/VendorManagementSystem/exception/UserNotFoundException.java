package com.vendora.VendorManagementSystem.exception;



public class UserNotFoundException  extends Exception{

    public  UserNotFoundException(){
        super("User is not found");
    }

    public  UserNotFoundException(String message){
        super(message);
    }
}
