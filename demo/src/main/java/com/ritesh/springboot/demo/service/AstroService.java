package com.ritesh.springboot.demo.service;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ritesh.springboot.demo.records.AstroResponse;

// ? Services are for business logic
@Service
public class AstroService {

    private final RestTemplate template;

    public AstroService(RestTemplateBuilder builder) {
        this.template = builder.setReadTimeout(Duration.ofSeconds(100)).build();
    }

    public AstroResponse getAstroResponse() {

        return template.getForObject("http://api.open-notify.org/astros.json", AstroResponse.class);

    }

}
