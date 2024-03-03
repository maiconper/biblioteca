package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Livro;
import com.example.demo.entityDTO.LivroDTO;
import com.example.demo.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	@GetMapping("/listarTodos")
	public List<Livro> listarTodos(){
		
		return livroService.listarTodos();
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<LivroDTO> adicionarLivro(@RequestBody Livro livro){
		
		LivroDTO dto = new LivroDTO(livro.getTitulo(),livro.getAutor(),livro.getCategoria(),livro.getQuantidade());
		livroService.adicionar(livro);
		return ResponseEntity.ok(dto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LivroDTO> atualizarLivro(@PathVariable Integer id, @RequestBody Livro livroDetalhes){
		LivroDTO livro = livroService.atualizarLivro(id,livroDetalhes);
		return ResponseEntity.ok(livro);	
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<String> removerLivro(@PathVariable Integer id){		
		livroService.remover(id);
		return new ResponseEntity<>("Livro removido com sucesso", HttpStatus.CREATED);
	}
	
}

