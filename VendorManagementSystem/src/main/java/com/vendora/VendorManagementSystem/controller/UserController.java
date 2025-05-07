package com.vendora.VendorManagementSystem.controller;

import com.vendora.VendorManagementSystem.exception.UserNotFoundException;
import com.vendora.VendorManagementSystem.model.User;
import com.vendora.VendorManagementSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) throws UserNotFoundException {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/business/{businessId}")
    public ResponseEntity<List<User>> getUsersByBusinessId(@PathVariable String businessId) throws UserNotFoundException {
        List<User> users = userService.getUsersByBusinessId(businessId);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User updatedUser) throws UserNotFoundException {
        User updated = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{userId}/deactivate")
    public ResponseEntity<Void> deactivateUser(@PathVariable String userId) throws UserNotFoundException {
        userService.deactivateUser(userId);
        return ResponseEntity.noContent().build();
    }

//    // Login user
//    @PostMapping("/login")
//    public ResponseEntity<User> loginUser(@RequestParam String email, @RequestParam String password) throws UserNotFoundException {
//        User user = userService.loginUser(email, password)
//                .orElseThrow(() -> new UserNotFoundException("Invalid email or password"));
//        return ResponseEntity.ok(user);
//    }
}
