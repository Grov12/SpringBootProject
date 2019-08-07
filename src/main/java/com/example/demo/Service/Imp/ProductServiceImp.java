package com.example.demo.Service.Imp;

import com.example.demo.Service.ProductService;
import com.example.demo.com.example.demo.Product;
import com.example.demo.dao.Productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    private final Productrepo productrepo;

    @Autowired
    public ProductServiceImp(Productrepo productrepo) {
        this.productrepo = productrepo;
    }


    @Override
    public Optional<Product> findByName(String name) {
        Optional<Product> find = productrepo.findByNameOfProduct(name);

        return find;
    }

    @Override
    public List<Product> findBySubCategory(String name) {
        List<Product> list = productrepo.findBySubCategory(name);

        return list;
    }
}
