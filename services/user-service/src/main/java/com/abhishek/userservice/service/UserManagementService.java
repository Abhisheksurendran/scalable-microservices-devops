package com.abhishek.userservice.service;

import com.abhishek.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserManagementService {

    private final List<User> users = new ArrayList<>();

    public UserManagementService() {
        users.add(new User(1, "Abhishek", "abhishek@example.com"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public User addUser(User user) {

        if (getUserById(user.getId()).isPresent()) {
            throw new IllegalArgumentException("User ID already exists");
        }

        users.add(user);
        return user;
    }

    public Optional<User> updateUser(int id, User updatedUser) {

        Optional<User> existingUser = getUserById(id);

        if (existingUser.isPresent()) {
            User user = existingUser.get();

            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());

            return Optional.of(user);
        }

        return Optional.empty();
    }

    public boolean deleteUser(int id) {
        return users.removeIf(user -> user.getId() == id);
    }
}
