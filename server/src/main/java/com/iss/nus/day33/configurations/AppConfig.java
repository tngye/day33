package com.iss.nus.day33.configurations;

import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

    private Logger logger = Logger.getLogger(AppConfig.class.getName());

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        logger.info("CORS: pathMapping=/api, origins=*");
        return new CORSConfiguration("/api/*", "*");
    }
}
