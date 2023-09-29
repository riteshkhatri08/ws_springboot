package com.ritesh.springaction.tacocloud.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ritesh.springaction.tacocloud.security.dao.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class SecurityConfig {
    // ? Commenting out this bena as we now have a custom bean that can fetch users
    // from db
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

    // ? Commenting out this bena as we now have a custom bean that can fetch users
    // from db
    // @Bean
    // public UserDetailsService userDetailsService(PasswordEncoder encoder) {

    // // Adding this config to add users to this default bean
    // List<UserDetails> usersList = new ArrayList<>();
    // // Add users
    // usersList.add(new User("dj_bobby_deol", encoder.encode("strongpassword"),
    // Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
    // usersList.add(new User("selmon_bhai", encoder.encode("footpath"),
    // Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));

    // // Return a manager that stores these users in memory
    // // Below class implements UserDetailsService
    // // InMemoryUserDetailsManager doesn't allow editing of users
    // return new InMemoryUserDetailsManager(usersList);
    // }

    @Bean
    public com.ritesh.springaction.tacocloud.security.service.UserDetailsService userDetailsService(
            UserRepository userRepository) {

        return username -> {
            
            log.info("******* PRINTING ALL USERS ************");
            userRepository.findAll().forEach(System.out::println);
            
            com.ritesh.springaction.tacocloud.security.entity.User user = userRepository.findByUsername(username);
            if (user != null)
                return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    // ! Customizing SecurityFilterChain Bean so that no authenitcation is required
    // ! for registering users
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity

                .authorizeRequests()
                .antMatchers("/design", "/orders") // DO authoirzation for /design and /orders page
                .hasRole("USER") // users must have role // user
                .antMatchers("/", "/**").permitAll() // Allow access to remaining uris to all users
                .and()
                .formLogin() // ? map lpgin form to a different uri
                .loginPage("/login")
                .defaultSuccessUrl("/design", true) // ? if user logged in successfully then redirect to this url
                .and()
                .csrf().disable().build();
        // .and().build(); // build the securityfilter change

        /*
         * The following are among the many things you can configure with HttpSecurity:
         * Requiring that certain security conditions be met before allowing a request
         * to be served
         * Configuring a custom login page
         * Enabling users to log out of the application
         * Configuring cross-site request forgery protection
         */
    }

}
