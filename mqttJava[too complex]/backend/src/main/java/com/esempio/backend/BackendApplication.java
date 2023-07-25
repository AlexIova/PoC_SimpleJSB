package com.esempio.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		GestioneMQTT gMqtt = new GestioneMQTT();
		System.out.println("********** eccoci prima");
		gMqtt.parti();
		System.out.println("********** eccoci prima");

		SpringApplication.run(BackendApplication.class, args);
	}

}
