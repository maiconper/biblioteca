package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Emprestimo;
import com.example.demo.entityDTO.EmprestimoDTO;
import com.example.demo.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	private EmprestimoService emprestimoService;
	
	
	@PostMapping("/realizar")
	public ResponseEntity<Emprestimo> realizarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO){
		
		Emprestimo emprestimo = emprestimoService.realizarEmprestimo(emprestimoDTO);
		
		if(emprestimo!=null) {
			return ResponseEntity.ok(emprestimo);
		} else {
			return ResponseEntity.badRequest().body(null);
		}
		
	}
}
