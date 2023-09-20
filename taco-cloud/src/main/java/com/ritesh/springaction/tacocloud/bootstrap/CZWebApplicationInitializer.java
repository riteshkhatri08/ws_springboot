package com.ritesh.springaction.tacocloud.bootstrap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import lombok.extern.slf4j.Slf4j;


// ! DOESN't WORK 
@Slf4j
@Order(Integer.MIN_VALUE)
public class CZWebApplicationInitializer 
// implements WebApplicationInitializer 
{
    
    // ApplicationAvailability availabilityProvider;

    // @Override
    // public void onStartup(ServletContext servletContext) throws ServletException {
    //     log.error("**********************************************************************************");
    //     log.debug(
    //             "Inside CZWebApplicationInitializer : Application has been initilialized but MAY not ready to receive traffic");
    //     log.error("SLEEPING for 15 seconds , meanwhile you can check if application is accepting traffic");

    //     LivenessState livenessState = availabilityProvider.getLivenessState();
    //     ReadinessState readinessState = availabilityProvider.getReadinessState();
    //     log.error("liveness state =" + livenessState);
    //     log.error("Readiness State = " + readinessState);
    //     try {

    //         Thread.sleep(15000);

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }

    //     log.error("JUST WOKE UP FROM 15 second sleep..");
    //     log.error("**********************************************************************************");

    //     // log.debug("Creating Caches from DB for table - INGREDIENT");
    // }

}
