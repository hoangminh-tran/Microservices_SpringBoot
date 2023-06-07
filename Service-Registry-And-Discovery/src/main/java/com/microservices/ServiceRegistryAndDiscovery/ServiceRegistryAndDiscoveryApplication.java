package com.microservices.ServiceRegistryAndDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryAndDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryAndDiscoveryApplication.class, args);
	}

}
