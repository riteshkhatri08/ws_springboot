package com.ritesh.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.springboot.demo.json.Greeting;

@RestController
public class HelloRestController {

    @GetMapping(value = "/greet")
    public Greeting greet(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        return new Greeting("Hello, " +  name + " !");
    }
    

}
