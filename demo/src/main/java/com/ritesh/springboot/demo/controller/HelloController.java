package com.ritesh.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// ? Spring uses a RequestMappingHandlerMapping to map requests to methods
// ? Spring uses ThymeLeafViewResolver to maped returned string to actual view files
// ? Spring takes all attributes from the Model Object,
// ?    adds them to current HTTP Request
// ?    and forward the request to view

@Controller
public class HelloController {

    @GetMapping("/hello") // * accessible at - http://localhost:8080/hello?name=Ritesh
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
            Model model) {
                System.out.println(model.getClass().getName());
        model.addAttribute("user", name);
        return "welcome"; // ! Spring will snap that to /src/main/resources/templates/welcome.html
    }

}
