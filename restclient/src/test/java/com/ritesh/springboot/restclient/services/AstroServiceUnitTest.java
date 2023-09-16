package com.ritesh.springboot.restclient.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class AstroServiceUnitTest {

    @Autowired
    private AstroService astroService;

    private final Logger logger = LoggerFactory.getLogger(AstroServiceUnitTest.class);

    @Test
    void testgetAstrosRT() {
        var astroResponse = astroService.getAstrosRT();
        logger.info(astroResponse.toString());
        assertEquals("success", astroResponse.getMessage());

    }

    @Test
    void testGetAstros() {

        String json = astroService.getAstros();
        logger.info(json);

        assertTrue(json.contains("success"));

    }

    @Test
    void testGetAstroResponse() {

        var response = astroService.getAstrosResponse();
        logger.info(response.toString());

        assertEquals("success", response.getMessage());

    }

    @Test
    void testGetAstroResponseEntity() {

        var responseEntity = astroService.getAstrosResponseEntity();
        logger.info(responseEntity.toString());
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("success", responseEntity.getBody().getMessage());

    }
}
