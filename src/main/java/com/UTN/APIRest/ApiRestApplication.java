package com.UTN.APIRest;

import com.UTN.APIRest.repositories.LocalidadRepository;
import com.UTN.APIRest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiRestApplication {
	@Autowired
	LocalidadRepository localidadRepository;
	@Autowired
	PersonaRepository personaRepository;
	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
		System.out.println("Estoy funcionando ...");

	}

}
