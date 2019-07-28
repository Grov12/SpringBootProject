package com.example.demo.dao;

import com.example.demo.com.example.demo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface Productrepo extends JpaRepository<Product,Integer> {
    List<Product> findByCategory(String name);

    Optional<Product> findByNameOfProduct(String name);




}
