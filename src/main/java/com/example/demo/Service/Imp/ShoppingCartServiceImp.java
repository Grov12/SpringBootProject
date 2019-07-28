package com.example.demo.Service.Imp;

import com.example.demo.Service.CartService;
import com.example.demo.com.example.demo.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImp implements CartService {
        Map<Product,Integer> products = new HashMap<>();


    @Override
    public void addToList(Product product) {
        if(products.containsKey(product)) {
            products.replace(product,products.get(product) +1);

        }
        else {
            products.put(product,1);
        }
    }

    @Override
    public void removeFromList(Product product) {
        if(products.get(product) > 1) {
            products.replace(product,products.get(product) -1);
        }
        else {
            products.remove(product);
        }

    }

    @Override
    public Map<Product, Integer> getAllFromList() {
        return Collections.unmodifiableMap(products);
    }
}
