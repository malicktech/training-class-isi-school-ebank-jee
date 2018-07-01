package com.examen.GestionBanque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GestionBanqueApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =(ApplicationContext) SpringApplication.run(GestionBanqueApplication.class, args);
	}
}
