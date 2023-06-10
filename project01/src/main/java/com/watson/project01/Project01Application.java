package com.watson.project01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class Project01Application {

	public static void main(String[] args) {
		SpringApplication.run(Project01Application.class, args);
	}



}
