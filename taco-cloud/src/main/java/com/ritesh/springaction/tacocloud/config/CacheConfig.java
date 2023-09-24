package com.ritesh.springaction.tacocloud.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableCaching // Enable Caching Feature
@EnableScheduling // Enable Scheduling to refill cache at intervals
public class CacheConfig {

    // @Bean
    // public CacheManager cacheManager() {
    // return new ConcurrentMapCacheManager();
    // }
}