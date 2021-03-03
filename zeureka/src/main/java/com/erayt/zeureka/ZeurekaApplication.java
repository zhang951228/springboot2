package com.erayt.zeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ZeurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeurekaApplication.class, args);
	}

}
