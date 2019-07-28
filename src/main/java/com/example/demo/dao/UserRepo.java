package com.example.demo.dao;

import com.example.demo.com.example.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
        Optional<User> findByUsername(@Param("username")String name);
}
