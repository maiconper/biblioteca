package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<EmprestimoDTO> realizarEmprestimo(@RequestBody Emprestimo emprestimo){
		Emprestimo novoEmprestimo = emprestimo;
		EmprestimoDTO retornoEmprestimo = new EmprestimoDTO (emprestimoService.realizarEmprestimo(novoEmprestimo));
		
		if(emprestimo!=null) {
			return ResponseEntity.ok(retornoEmprestimo);
		} else {
			return ResponseEntity.badRequest().body(null);
		}
		
	}
	@GetMapping("/listar/usuario/{id}")
	public List<Emprestimo> listarEmprestimos(@PathVariable Integer id){
		
		return emprestimoService.listarEmprestimos(id);
	}
		
	
	
}
