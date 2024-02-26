package com.kbtg.bootcamp.posttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class PosttestApplication {

	public static void main(String[] args) {
		System.out.println("text");
		SpringApplication.run(PosttestApplication.class, args);
	}

}
