package com.example.demo.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @RequestMapping("/app/teste")
    public Map<String, String> testeEndpoint() {
        return Collections.singletonMap("mensagem", "Esta é uma string de teste!");
    }
}