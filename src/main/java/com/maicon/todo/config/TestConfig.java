package com.maicon.todo.config;

import com.maicon.todo.services.DBServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    
    @Autowired
    private DBServices dbService;

    @Bean
    public boolean instance() {
        this.dbService.dataBaseInstance();
        return true;
    }
}
