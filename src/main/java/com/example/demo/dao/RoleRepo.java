package com.example.demo.dao;

import com.example.demo.com.example.demo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepo extends JpaRepository<Role,Integer> {
    Role findByRole(@Param("role") String role);
}
