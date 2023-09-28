package com.ritesh.springaction.tacocloud.security.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ritesh.springaction.tacocloud.security.dao.UserRepository;
import com.ritesh.springaction.tacocloud.security.model.RegistrationForm;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(
            UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ? Return a thyme leaf template for registration
    @GetMapping
    public String registerForm() {
        return "registration";
    }

    // ? Accept model from Thyme leaf form and enter it in db
    @PostMapping
    public String processRegistration(RegistrationForm registerationForm) {
        userRepository.save(registerationForm.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
