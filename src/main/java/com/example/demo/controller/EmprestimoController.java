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
	
	
	@PostMapping("/realizar/{livroId}/{userId}")
	public ResponseEntity<EmprestimoDTO> realizarEmprestimo(@PathVariable Integer livroId, @PathVariable Integer userId){
		
		EmprestimoDTO novoEmprestimo = new EmprestimoDTO(emprestimoService.realizarEmprestimo(new EmprestimoDTO(livroId), userId));
		return ResponseEntity.ok(novoEmprestimo);
	}
	
	@GetMapping("/listarTodos")
	public ResponseEntity<List<EmprestimoDTO>> listarEmprestimos(){
		
		List<Emprestimo> emprestimos = emprestimoService.listarEmprestimos();		
		List<EmprestimoDTO> dto = new ArrayList();
		
		for (Emprestimo e : emprestimos){
			
			dto.add(new EmprestimoDTO(e));
		}
		
		
		return ResponseEntity.ok(dto);
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
	
	@PostMapping("/cancelarEmprestimo/{emprestimoId}")
	public ResponseEntity<String> cancelarEmprestimo(@PathVariable Integer emprestimoId){
		
		emprestimoService.cancelar(emprestimoId);
		return ResponseEntity.ok("Emprestimo cancelado.");
	}
	
	@PostMapping("/renovarEmprestimo/{emprestimoId}")
	public ResponseEntity<String> renovarEmprestimo(@PathVariable Integer emprestimoId){
		
		emprestimoService.renovar(emprestimoId);
		return ResponseEntity.ok("Emprestimo renovado.");
	}
	
	
}
