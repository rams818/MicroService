package com.ramkumar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}
