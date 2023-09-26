package com.ritesh.springaction.tacocloud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

  
}
