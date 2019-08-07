package com.example.demo;

import com.example.demo.Service.Imp.ShoppingCartServiceImp;
import com.example.demo.Service.Imp.UserServiceImp;
import com.example.demo.Service.UserService;
import com.example.demo.com.example.demo.Product;
import com.example.demo.com.example.demo.Role;
import com.example.demo.com.example.demo.User;
import com.example.demo.dao.Productrepo;
import com.example.demo.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;

@Controller
public class Homecontroller {

    Productrepo repo;

    UserServiceImp userServiceImp;


    String previousPage;
    private final ShoppingCartServiceImp shoppingCartService;


    @Autowired
    public Homecontroller(Productrepo repo, ShoppingCartServiceImp shoppingCartService, UserServiceImp userServiceImp) {
        this.repo = repo;
        this.shoppingCartService = shoppingCartService;
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/")
    public ModelAndView firstPage() {
        ModelAndView mv = new ModelAndView("/index");
        return mv;
    }

    @GetMapping("/products/{name}")
    public ModelAndView productView(@PathVariable("name") String name) {
            ModelAndView mv = new ModelAndView("/products");
            List<Product> list = repo.findByCategory(name);
            previousPage = name;

            mv.addObject("products",list);


            return mv;
    }





    @GetMapping("/login")
    public ModelAndView loginPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login");
       return mv;
    }


    @GetMapping("/profilepage")
    public ModelAndView profilePage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Optional<User> optionalUser = userServiceImp.findByUsername(name);
        Collection<Role> m = optionalUser.get().getRoles();
        m.forEach(item -> {
            System.out.println(item.getRole());
        });
        ModelAndView mv = new ModelAndView("/profilepage");

        mv.addObject("user",optionalUser);
        return mv;
    }

}
