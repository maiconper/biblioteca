package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Emprestimo;
import com.example.demo.entity.Livro;
import com.example.demo.entity.Usuario;
import com.example.demo.entityDTO.EmprestimoDTO;
import com.example.demo.repository.EmprestimoRepository;
import com.example.demo.repository.LivroRepository;
import com.example.demo.repository.UsuarioRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	

	public Emprestimo realizarEmprestimo(EmprestimoDTO emprestimo, Integer userId) {
		
		LocalDate now = LocalDate.now();
		
		Emprestimo novoEmprestimo = new Emprestimo();
		novoEmprestimo.setDataEmprestimo(now);
		novoEmprestimo.setLivroId(emprestimo.getLivroId());
		novoEmprestimo.setDataDevolucao(now.plusWeeks(2));
		
			Optional<Usuario> teste = usuarioRepository.findById(userId);
			if(!teste.isPresent()) {
				throw new RuntimeException("Usuario n'ao encontrado.");
			}
			
		
		novoEmprestimo.setUsuarioId(userId);
		
		Livro livro = livroRepository.findById(emprestimo.getLivroId()).orElseThrow(()-> new RuntimeException("Livro não encontrado!"));
		
		if(livro.getQuantidade() < 1 ) {
			
			throw new RuntimeException("Titulo indisponivel no momento.");
		}
		
		livro.setQuantidade(livro.getQuantidade() -1);
		livroRepository.save(livro);
		
		return emprestimoRepository.save(novoEmprestimo);
		
	}
	
	public List<Emprestimo> listarEmprestimos(Integer id){
				
		return emprestimoRepository.findByUsuarioId(id);
	}
	
	public List<Emprestimo> listarEmprestimos(){
		
		return emprestimoRepository.findAll();
	}

	public void devolver(Integer usuarioId, Integer livroId) {
		
		List<Emprestimo> emprestimo = emprestimoRepository.findByUsuarioId(usuarioId);
		Livro livro = livroRepository.findById(livroId).orElseThrow(()-> new RuntimeException("Livro não encontrado!"));
		
		livro.setQuantidade(livro.getQuantidade()+1);
		
		livroRepository.save(livro);
		
		
	}
	
	public void devolverLivro(Integer livroId) {
		
		Livro livro = livroRepository.findById(livroId).orElseThrow(()-> new RuntimeException("Livro não encontrado!"));
		livro.setQuantidade(livro.getQuantidade()+1);
		System.out.println("Testeeeee" + livro.getQuantidade());
		livroRepository.save(livro);
		
	}
	
	

	
}
