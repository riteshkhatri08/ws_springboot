package com.ritesh.springaction.tacocloud.controller;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ritesh.springaction.tacocloud.dao.TacoOrderJPARepository;
import com.ritesh.springaction.tacocloud.model.TacoOrder;
import com.ritesh.springaction.tacocloud.security.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    // private TacoOrderRepository tacoOrderRepository;

    // public OrderController(TacoOrderRepository tacoOrderRepository) {
    // this.tacoOrderRepository = tacoOrderRepository;
    // }

    private TacoOrderJPARepository tacoOrderRepository;

    public OrderController(TacoOrderJPARepository tacoOrderRepository) {
        this.tacoOrderRepository = tacoOrderRepository;
    }

    @GetMapping("/current")
    public String orderForm(@ModelAttribute TacoOrder tacoOrder, Authentication authentication) {
        // ! Get user object from authentication and link it with order
        User currentUser = (User) authentication.getPrincipal();
        tacoOrder.setUser(currentUser);
        // Put current user details in taco order model
        tacoOrder.setDeliveryName(currentUser.getFullname());
        tacoOrder.setDeliveryStreet(currentUser.getStreet());
        tacoOrder.setDeliveryCity(currentUser.getCity());
        tacoOrder.setDeliveryState(currentUser.getState());
        tacoOrder.setDeliveryZip(currentUser.getZip());

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
            SessionStatus sessionStatus) {

        if (errors.hasErrors()) {
            return "orderForm";
        }
        tacoOrderRepository.save(order);

        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
