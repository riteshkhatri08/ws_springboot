package com.ritesh.springaction.tacocloud.bootstrap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class CZApplicationRunner
        implements ApplicationRunner {

    @Autowired
    ApplicationAvailability availabilityProvider;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // ! THIS DOESN'T WORK Apllication starts aceepting traffic before we exit this
        // method
        // This method is called in a different thread and doesn't stop servlet from
        // being initilized

        // log.debug("Inside ApplicationRunner : Application has been initilialized is
        // ready to receive traffic");
        // log.error(Thread.currentThread()
        // + " ::::: SLEEPING for 20 SECOND , meanwhile you can check if application is
        // accepting traffic");

        // Thread.sleep(20000);

        // log.error(Thread.currentThread() + " ::::: JUST WOKE UP FROM 20 SECOND
        // sleep..");
        // log.debug("Creating Caches from DB for table - INGREDIENT");

        // do nothing
    }

    @PostConstruct
    public void init() {
        log.debug(Thread.currentThread() + " ::::: SLEEPING for 30 seconds ");
        try {
            // ?  we can use @PostConstruct on a method and that method will be called after a bean has been initialized .. s
            // ? here we can performDB based operation like populating a cache from DB
            log.debug("liveness state =" + availabilityProvider.getLivenessState());
            log.debug("Readiness State = " + availabilityProvider.getReadinessState());

            Thread.sleep(30000); // for testing purpose only
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        log.debug(Thread.currentThread() + " ::::: Woke up after a 30 second sleep ");

    }

}
