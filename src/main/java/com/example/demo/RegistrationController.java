package com.example.demo;


import com.example.demo.Service.UserService;
import com.example.demo.com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.xml.ws.BindingProvider;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registerPage() {
        System.out.println("Hello");
        ModelAndView mv = new ModelAndView();
        User user = new User();
        mv.addObject("user",user);

        mv.setViewName("/registration");

        return mv;

    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {


        if(userService.findByUsername(user.getUsername()).isPresent()) {
            bindingResult.rejectValue("username","error.user","This username has already been registered.");
        }

        ModelAndView mv = new ModelAndView();

        if(bindingResult.hasErrors()) {
            System.out.println("Yikes.");
            mv.setViewName("/registration");
        }


        else {
            userService.saveUser(user);
            mv.addObject("successMessage","You have been successfully registered.");
            mv.addObject("user",new User());
            mv.setViewName("/registration");
        }


        return mv;


    }




}
