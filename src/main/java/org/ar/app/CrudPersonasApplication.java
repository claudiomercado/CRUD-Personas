package org.ar.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CrudPersonasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudPersonasApplication.class, args);
	}

}
