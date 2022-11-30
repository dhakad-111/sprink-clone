package com.sprink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScans({ @ComponentScan("com.sprink.controller"), @ComponentScan("com.sprink.services"),
	@ComponentScan("com.sprink.dto") , @ComponentScan("com.sprink.exception")})
@EntityScan("com.sprink.model")
@EnableJpaRepositories("com.sprink.repository")
public class SprinkRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinkRegistrationApplication.class, args);
	}

}
