package com.ritesh.springaction.tacocloud.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import  org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // ? This passwordEncoder bean can be used to
        // ? Add new user
        // ? Authenticate users during login
        return new BCryptPasswordEncoder();
        // ? Other encoders
        /*
         * BCryptPasswordEncoder—Applies bcrypt strong hashing encryption
         * NoOpPasswordEncoder—Applies no encoding
         * Pbkdf2PasswordEncoder—Applies PBKDF2 encryption
         * SCryptPasswordEncoder—Applies Scrypt hashing encryption
         * StandardPasswordEncoder—Applies SHA-256 hashing encryption
         */
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {

        // Adding this config to add users to this default bean
        List<UserDetails> usersList = new ArrayList<>();
        // Add users
        usersList.add(new User("dj_bobby_deol", encoder.encode("strongpassword"),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
        usersList.add(new User("selmon_bhai", encoder.encode("footpath"),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));

        // Return a manager that stores these users in memory
        // Below class implements UserDetailsService
        return new InMemoryUserDetailsManager(usersList);
    }

}
