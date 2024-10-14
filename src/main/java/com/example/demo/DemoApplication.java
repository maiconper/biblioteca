package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		String springSecurityVersion = org.springframework.security.core.SpringSecurityCoreVersion.getVersion();
		System.out.println("Versão do Spring Security: " + springSecurityVersion);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pass = "maicongado";
		String passEncoded  = passwordEncoder.encode(pass);
		
		System.out.println("PassEncoded: " + passEncoded);


	}

}
