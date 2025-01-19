package com.carewell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.carewell")
// @EnableJpaRepositories
public class CareWellApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareWellApplication.class, args);
	}

}
