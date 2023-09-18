package com.ritesh.springaction.tacocloud.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    // ? WebMvcConfigurer defines several methods for configuring Spring MVC
    // ? We will override only the methods we need. In this case, it is only
    // ? addViewControllers().

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("home");

    }

}




