package com.example.ProjectBibliotheque;

import com.example.ProjectBibliotheque.model.Person;
import com.example.ProjectBibliotheque.model.Role;
import com.example.ProjectBibliotheque.repository.PersonRepository;
import com.example.ProjectBibliotheque.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class ProjectBibliothequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectBibliothequeApplication.class, args);
	}


	@Bean
	public CommandLineRunner test(PersonService personService, PersonRepository personRepository) {
		return (args) -> {

			//CREATION DE ROLE
			Role admin = personService.save(new Role("ADMIN"));
			Role user = personService.save(new Role("USER"));

		};
	}

	@Bean
	BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
}
