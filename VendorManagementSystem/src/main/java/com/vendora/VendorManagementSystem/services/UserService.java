package com.vendora.VendorManagementSystem.services;

import com.vendora.VendorManagementSystem.exception.UserNotFoundException;
import com.vendora.VendorManagementSystem.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> getUserById(String userId) throws UserNotFoundException;
    List<User> getUsersByBusinessId(String businessId) throws UserNotFoundException;
    User updateUser(String userId, User updatedUser) throws UserNotFoundException;
    void deactivateUser(String userId) throws UserNotFoundException;
    Optional<User> loginUser(String email, String password);
}
