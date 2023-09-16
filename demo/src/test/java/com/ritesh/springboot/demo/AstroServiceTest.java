package com.ritesh.springboot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ritesh.springboot.demo.service.AstroService;

@SpringBootTest
public class AstroServiceTest {

    @Autowired
    private AstroService service;

    @Test
    void getAstroResponse() {
        var response = service.getAstroResponse();
        assertNotNull(response);
        assertEquals("success", response.message());
        assertEquals(response.number(), response.people().size());

        System.out.println("There are  " + response.number() + " people in space");

        response.people().forEach((a) -> System.out.println(a.name() + " aboard " + a.craft()));

    }

}
