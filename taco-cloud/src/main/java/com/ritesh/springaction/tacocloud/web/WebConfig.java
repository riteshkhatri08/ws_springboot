package com.ritesh.springaction.tacocloud.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ritesh.springaction.tacocloud.bootstrap")
public class WebConfig implements WebMvcConfigurer {

    // ? WebMvcConfigurer defines several methods for configuring Spring MVC
    // ? We will override only the methods we need. In this case, it is only
    // ? addViewControllers().

    @Bean
    public String testingBean() {
        log.error("testing bean initialized");
        return new String("test");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        log.info("configured view controller- home to path root -/");
        registry.addViewController("/").setViewName("home");

    }

}
