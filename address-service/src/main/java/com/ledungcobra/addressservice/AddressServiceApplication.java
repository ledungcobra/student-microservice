package com.ledungcobra.addressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({
		"com.ledungcobra.addressservice.controller",
		"com.ledungcobra.addressservice.service",
})
@EntityScan("com.ledungcobra.addressservice.entity")
@EnableJpaRepositories("com.ledungcobra.addressservice.repository")
@EnableEurekaClient
public class AddressServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AddressServiceApplication.class, args);
	}

}
