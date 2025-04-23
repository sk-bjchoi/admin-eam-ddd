package com.sk.eadmin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

@SpringBootApplication
@EnableFeignClients
public class AdminEamDddApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminEamDddApplication.class, args);
	}
	
}
