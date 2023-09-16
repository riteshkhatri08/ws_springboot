package com.ritesh.springboot.restclient.services;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.ritesh.springboot.restclient.json.AstroResponse;

@Service
public class AstroService

{

    private final WebClient webClient = WebClient.create("http://api.open-notify.org/");
    private final RestTemplate template;

    public AstroService(RestTemplateBuilder restTemplateBuilder) {
        this.template = restTemplateBuilder.build();
    }

    public AstroResponse getAstrosRT() {
        return template.getForObject("http://api.open-notify.org/astros.json", AstroResponse.class);
    }

    public String getAstros() {

        return webClient.get().uri("astros.json")
                .retrieve()
                .bodyToMono(String.class)
                .block(Duration.ofSeconds(2));

    }

    public AstroResponse getAstrosResponse() {

        return webClient.get().uri("astros.json")
                .retrieve()
                .bodyToMono(AstroResponse.class)
                .log()
                .block(Duration.ofSeconds(2));

    }

    public ResponseEntity<AstroResponse> getAstrosResponseEntity() {

        return webClient.get().uri("astros.json")
                .retrieve()
                .toEntity(AstroResponse.class)
                .block(Duration.ofSeconds(2));

    }
}