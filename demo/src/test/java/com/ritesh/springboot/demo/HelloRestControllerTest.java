package com.ritesh.springboot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.ritesh.springboot.demo.json.Greeting;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    void greetTest() {
        Greeting response = template.getForObject("/greet?name=Ritesh", Greeting.class, "Ritesh");
        assertEquals("Hello, Ritesh !", response.getMessage());
    }

    @Test
    void greetForEntity() {

        ResponseEntity<Greeting> responseEntity = template.getForEntity("/greet", Greeting.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Status is OK");
        assertNotNull(responseEntity.getBody());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        Greeting response = responseEntity.getBody();
        assertEquals("Hello, World !", response.getMessage());

    }
}
