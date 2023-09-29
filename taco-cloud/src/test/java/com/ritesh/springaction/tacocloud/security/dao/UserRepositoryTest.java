package com.ritesh.springaction.tacocloud.security.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ritesh.springaction.tacocloud.security.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired 
    PasswordEncoder passwordEncoder;

    @Test
    public void givenValidInitData_whenCallingFindAll_thenReturnData() {

        
        userRepository.save(new User("ritesh", passwordEncoder.encode("password"), "riteshkhatri", "street", "city", "state", "452001", "89658479999"));
        userRepository.save(new User("rites2", passwordEncoder.encode("password"), "riteshkhatri", "street", "city", "state", "452001", "89658479999"));
        List<User> users = userRepository.findAll();
        log.info("USERS  - " + users);
        assertTrue(users.size()>=2);
    }

}
