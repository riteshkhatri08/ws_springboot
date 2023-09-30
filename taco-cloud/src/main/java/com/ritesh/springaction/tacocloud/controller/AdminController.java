package com.ritesh.springaction.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ritesh.springaction.tacocloud.dao.TacoOrderJPARepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    private final TacoOrderJPARepository tacoOrderJPARepository;

    public AdminController(TacoOrderJPARepository tacoOrderJPARepository) {
        this.tacoOrderJPARepository = tacoOrderJPARepository;
    }

    @PostMapping("/deleteAllOrders")
    public String deleteAllOrders() {
        log.info("Deleting All Orders");
        this.tacoOrderJPARepository.deleteAll();
        return "redirect:/admin";
    }
}
