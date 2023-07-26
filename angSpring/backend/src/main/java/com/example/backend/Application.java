package com.example.backend;

import com.example.backend.entities.Utente;
import com.example.backend.repositories.UserRepository;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				Utente utente = new Utente(name, name.toLowerCase() + "@domain.com");
				userRepository.save(utente);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}

}
