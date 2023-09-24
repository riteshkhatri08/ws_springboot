package com.ritesh.springaction.tacocloud.bootstrap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ritesh.springaction.tacocloud.schedule.CacheRefesher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BootstrapInitiailzingBean implements InitializingBean {

    @Autowired
    CacheRefesher cacheFiller;

    @Override
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        log.debug("Inside BootstrapInitiailzingBean: Entry");
        try {

            popoulateAllCaches();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        log.debug("Inside BootstrapInitiailzingBean: Exit");

    }

    void popoulateAllCaches() {
        cacheFiller.fillIngredientsCache();
    }

}
