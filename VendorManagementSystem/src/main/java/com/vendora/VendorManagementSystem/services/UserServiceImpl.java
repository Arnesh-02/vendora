package com.vendora.VendorManagementSystem.services;

import com.vendora.VendorManagementSystem.exception.UserNotFoundException;
import com.vendora.VendorManagementSystem.model.User;
import com.vendora.VendorManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setActive(true);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(String userId) throws UserNotFoundException {
        return Optional.of(userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId)));
    }

    @Override
    public List<User> getUsersByBusinessId(String businessId) throws UserNotFoundException {
        List<User> users = userRepository.findByBusinessId(businessId);
        if (users.isEmpty()) {
            throw new UserNotFoundException("No users found for business ID: " + businessId);
        }
        return users;
    }

    @Override
    public User updateUser(String userId, User updatedUser) throws UserNotFoundException {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("Cannot update. User not found with ID: " + userId);
        }
        updatedUser.setUserId(userId);
        return userRepository.save(updatedUser);
    }

    @Override
    public void deactivateUser(String userId) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Cannot deactivate. User not found with ID: " + userId));
        user.setActive(false);
        userRepository.save(user);
    }
    @Override
    public Optional<User> loginUser(String email, String password) {
//        return userRepository.findByEmailAndPassword(email, password);
        return  null;
    }
}
