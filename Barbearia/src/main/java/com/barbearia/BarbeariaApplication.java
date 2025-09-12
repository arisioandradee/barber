package com.barbearia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.barbearia"})
public class BarbeariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbeariaApplication.class, args);
        
        System.out.println("**********************************************");
        System.out.println("*                                            *");
        System.out.println("*  APLICAÇÃO BARBEARIA INICIADA COM SUCESSO! *");
        System.out.println("*                                            *");
        System.out.println("**********************************************");
	}

}
