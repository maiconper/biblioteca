package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		String springSecurityVersion = org.springframework.security.core.SpringSecurityCoreVersion.getVersion();
		System.out.println("Versão do Spring Security: " + springSecurityVersion);

	}

}
