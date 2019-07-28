package com.example.demo;


import com.example.demo.Service.UserService;
import com.example.demo.com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registerPage() {
        ModelAndView mv = new ModelAndView();
        User user = new User();
        mv.addObject("user",user);

        mv.setViewName("/registration");

        return mv;

    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createUser(User user) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/registration");
        userService.saveUser(user);

        return mv;


    }




}
