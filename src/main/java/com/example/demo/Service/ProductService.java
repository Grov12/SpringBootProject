package com.example.demo.Service;

import com.example.demo.com.example.demo.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findByName(String name);

    List<Product> findBySubCategory(String name);
}
