package com.example.demo;

import com.example.demo.Service.Imp.ShoppingCartServiceImp;
import com.example.demo.com.example.demo.Product;
import com.example.demo.dao.Productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class Homecontroller {

    Productrepo repo;

    String previousPage;
    private final ShoppingCartServiceImp shoppingCartService;


    @Autowired
    public Homecontroller(Productrepo repo, ShoppingCartServiceImp shoppingCartService) {
        this.repo = repo;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/")
    public ModelAndView firstPage() {
        ModelAndView mv = new ModelAndView("/index");
        return mv;
    }

    @GetMapping("/products/{name}")
    public ModelAndView productView(@PathVariable("name") String name) {
            ModelAndView mv = new ModelAndView("/products");
            System.out.println(name);
            List<Product> list = repo.findByCategory(name);
            previousPage = name;

            mv.addObject("products",list);


            return mv;
    }


    @GetMapping("/products/buy/{name}")

    public String addProduct(@PathVariable("name") String name, HttpServletRequest request) {
         repo.findByNameOfProduct(name).ifPresent(shoppingCartService::addToList);


        return "redirect:/products/" + previousPage;


    }
    @GetMapping("/shoppingcarttest")
    public ModelAndView getProducts() {
        ModelAndView mv = new ModelAndView("/shoppingcarttest");
        Map<Product,Integer> list = shoppingCartService.getAllFromList();

        mv.addObject("products",list);

        return mv;
    }


    @RequestMapping("/addProduct")
    public String addProduct(Product product) {
        System.out.println("HELLO");
        repo.save(product);
        return "home";
    }



    @GetMapping("/login")
    public String login() {

        System.out.println("Wow.");
        return "/login";
    }






}
