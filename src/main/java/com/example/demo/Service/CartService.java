package com.example.demo.Service;

import com.example.demo.com.example.demo.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CartService{


     void addToList(Product product);

    void removeFromList(Product product);


    Map<Product,Integer> getAllFromList();
}
