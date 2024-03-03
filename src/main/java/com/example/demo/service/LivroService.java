package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Livro;
import com.example.demo.entityDTO.LivroDTO;
import com.example.demo.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	//lista todos os livros
	public List<Livro> listarTodos() {	
		return livroRepository.findAll();
	}
	
	//adiciona um livro
	public Livro adicionar(Livro livro) {
		return livroRepository.save(livro);
	}
	
	//atualiza o livro
	public LivroDTO atualizarLivro(Integer id, Livro livro) {
		
		Optional<Livro> newLivro = livroRepository.findById(id);
		
		//verifica os valores passados
		if(newLivro.isPresent()) {
			Livro livroExistente = newLivro.get();
			if(livro.getAutor() != null && !livro.getAutor().equalsIgnoreCase("")) {
				livroExistente.setAutor(livro.getAutor());
			}

			if(livro.getTitulo() != null && !livro.getTitulo().equalsIgnoreCase("")) {
				livroExistente.setTitulo(livro.getTitulo());
			}
			
			if(livro.getCategoria() != null && !livro.getCategoria().equalsIgnoreCase("")) {
				livroExistente.setCategoria(livro.getCategoria());
			}

			if(livro.getQuantidade() != null) {
				livroExistente.setQuantidade(livro.getQuantidade());	
			}
			
			livroRepository.save(newLivro.get());
			
		}
		
		LivroDTO dto = new LivroDTO(newLivro.get().getTitulo(),newLivro.get().getAutor(),newLivro.get().getCategoria(),newLivro.get().getQuantidade());
		
		
		return dto;
	
	}

	public void remover(Integer id) {
		livroRepository.deleteById(id);
	}
}
