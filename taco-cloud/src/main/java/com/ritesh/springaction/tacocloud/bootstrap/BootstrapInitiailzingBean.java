package com.ritesh.springaction.tacocloud.bootstrap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BootstrapInitiailzingBean implements InitializingBean {

    @Override
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        log.debug("Inside BootstrapInitiailzingBean: Sleeping for 0.15 Seconds");
        try {
            Thread.sleep(15);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
         log.debug("Inside BootstrapInitiailzingBean: WOKE UP after 0.15 Seconds");

    }

}
