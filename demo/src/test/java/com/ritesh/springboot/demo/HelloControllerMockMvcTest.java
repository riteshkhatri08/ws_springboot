package com.ritesh.springboot.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.ritesh.springboot.demo.controller.HelloController;

@WebMvcTest(HelloController.class)
public class HelloControllerMockMvcTest{


    @Autowired
    MockMvc mvc;


    @Test
    void sayHello() throws Exception{
        mvc.perform(get("/hello").param("name", "Ritesh"))
        .andExpect(status().isOk())
        .andExpect(view().name("welcome"))
        .andExpect(model().attribute("user", "Ritesh"));
    }





}