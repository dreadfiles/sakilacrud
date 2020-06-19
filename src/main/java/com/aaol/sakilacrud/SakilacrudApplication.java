package com.aaol.sakilacrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = { "com.aaol.entity" })
@EnableJpaRepositories(basePackages = { "com.aaol.repository" })
@ComponentScan(basePackages = { "com.aaol.controller" })
@SpringBootApplication
public class SakilacrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakilacrudApplication.class, args);
	}

}
