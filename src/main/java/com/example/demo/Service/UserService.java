package com.example.demo.Service;

import com.example.demo.com.example.demo.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    User saveUser(User user);
}
