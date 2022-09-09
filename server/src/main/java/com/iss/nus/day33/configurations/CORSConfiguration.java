package com.iss.nus.day33.configurations;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CORSConfiguration implements WebMvcConfigurer{
    
    private String path;
    private String origins;

    public CORSConfiguration(String p, String o){
        path = p;
        origins = o;
    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry
        .addMapping(path)
        .allowedOrigins(origins);
    }
}
