package com.ritesh.springboot.restclient.services;

import org.springframework.web.service.annotation.GetExchange;

import com.ritesh.springboot.restclient.json.AstroResponse;

public interface AstroInterface {

    @GetExchange("/astros.json")
    AstroResponse getAstroResponse();
}
