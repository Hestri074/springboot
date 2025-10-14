package com.app.inventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // buat bean
    @Bean
    public String appPesan() {
        return "Apilkasi springboot Depedensi....";
    }
}
