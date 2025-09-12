package com.barbearia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.barbearia.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
    public CommandLineRunner instanciaDB() {
        return args -> {
        	this.dbService.instanciaDB();
            System.out.println("Banco inicializado");
        };
    }
}