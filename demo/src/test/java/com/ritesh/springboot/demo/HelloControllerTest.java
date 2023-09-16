package com.ritesh.springboot.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import com.ritesh.springboot.demo.controller.HelloController;

public class HelloControllerTest {

    @Test
    void sayHelloTest() {
        HelloController helloController = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = helloController.hello("ritesh", model);

        assertAll(
                () -> assertEquals("ritesh", model.getAttribute("user")),
                () -> assertEquals("welcome", result)

        );

    }
}
