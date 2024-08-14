package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desabilitar CSRF para facilitar o desenvolvimento
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/adicionar").permitAll() // Permitir acesso ao endpoint /adicionar
                .anyRequest().authenticated() // Requer autenticação para qualquer outro endpoint
            )
            .httpBasic(); // Usar autenticação básica HTTP

        return http.build();
    }
}
