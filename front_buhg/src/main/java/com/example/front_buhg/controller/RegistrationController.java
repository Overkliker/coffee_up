package com.example.front_buhg.controller;


import com.example.front_buhg.model.RoleEnum;
import com.example.front_buhg.model.UserModel;
import com.example.front_buhg.repository.JpaUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private JpaUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registrationView() {
        return "regis";
    }

    @PostMapping("/registration")
    public String registrationUser(
            UserModel user,
            Model model,
            HttpServletRequest request
    ){
        if (userRepository.existsByUsername(user.getUsername())) {
            model.addAttribute("message", "Пользователь уже существует");
            return "regis";
        }
        user.setRole(Collections.singleton(RoleEnum.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }

}
