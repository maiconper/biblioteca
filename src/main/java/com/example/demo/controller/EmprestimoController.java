package com.example.demo.controller;

import java.util.ArrayList;
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
	public ResponseEntity<EmprestimoDTO> realizarEmprestimo(@RequestBody Integer livroId){
		
		EmprestimoDTO novoEmprestimo = new EmprestimoDTO(emprestimoService.realizarEmprestimo(new EmprestimoDTO(livroId)));
		return ResponseEntity.ok(novoEmprestimo);
	}
	
	
	@GetMapping("/listar/usuario/{id}")
	public List<EmprestimoDTO> listarEmprestimos(@PathVariable Integer id){
		
		List<EmprestimoDTO> dto = new ArrayList();
		emprestimoService.listarEmprestimos(id).forEach(e -> dto.add(new EmprestimoDTO(e)));
		
		return dto;
	}
	
	@PostMapping("/devolver/{usuarioId}/{livroId}")
	public ResponseEntity<String> devolverEmprestimo(@PathVariable Integer usuarioId, @PathVariable Integer livroId){
		
		emprestimoService.devolver(usuarioId, livroId);
		return ResponseEntity.ok("Livro devolvido!");
	}
	
		
	
	
}
