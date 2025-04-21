package com.sk.eadmin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

@SpringBootApplication
public class AdminEamDddApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminEamDddApplication.class, args);
	}
	
    @Bean(destroyMethod = "stop")
    @Profile("localstub")
    WireMockServer wireMockServer() {
        WireMockConfiguration config = WireMockConfiguration.options()
                .port(8085)
                .usingFilesUnderDirectory("src/main/resources/stubs"); 

        WireMockServer server = new WireMockServer(config);
        server.start();
        return server;
    }

    @Bean
    @Profile("localstub")
    CommandLineRunner printStubInfo(WireMockServer server) {
        return args -> System.out.println("✅ WireMock Stub running at: http://localhost:" + server.port());
    }
}
