package com.ritesh.springaction.tacocloud.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching // Enable Caching Feature
public class CacheConfig {

    // @Bean
    // public CacheManager cacheManager() {
    // return new ConcurrentMapCacheManager();
    // }
}