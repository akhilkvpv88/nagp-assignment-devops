package com.nagp.assignment.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NagpAssignementDevopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NagpAssignementDevopsApplication.class, args);
	}

}
