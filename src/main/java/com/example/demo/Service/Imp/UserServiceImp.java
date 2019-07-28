package com.example.demo.Service.Imp;


import com.example.demo.Service.UserService;
import com.example.demo.com.example.demo.User;
import com.example.demo.dao.RoleRepo;
import com.example.demo.dao.UserRepo;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    private static String USER_ROLE = "ROLE_USER";


    @Autowired
    public UserServiceImp(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);

        user.setRoles(Collections.singleton(roleRepo.findByRole(USER_ROLE)));

        return userRepo.saveAndFlush(user);
    }


}
