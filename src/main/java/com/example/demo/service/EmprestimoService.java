package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Emprestimo;
import com.example.demo.entity.Livro;
import com.example.demo.entityDTO.EmprestimoDTO;
import com.example.demo.repository.EmprestimoRepository;
import com.example.demo.repository.LivroRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	

	public Emprestimo realizarEmprestimo(EmprestimoDTO emprestimo) {
		
		Random rdm  = new Random();
		LocalDate now = LocalDate.now();
		
		Emprestimo novoEmprestimo = new Emprestimo();
		novoEmprestimo.setDataEmprestimo(now);
		novoEmprestimo.setLivroId(emprestimo.getLivroId());
		novoEmprestimo.setDataDevolucao(now.plusWeeks(2));
		novoEmprestimo.setUsuarioId(1 + rdm.nextInt(999));
		
		Livro livro = livroRepository.findById(emprestimo.getLivroId()).orElseThrow(()-> new RuntimeException("Livro não encontrado!"));
		livro.setQuantidade(livro.getQuantidade() -1);
		livroRepository.save(livro);
		
		return emprestimoRepository.save(novoEmprestimo);
		
	}
	
	public List<Emprestimo> listarEmprestimos(Integer id){
				
		return emprestimoRepository.findByUsuarioId(id);
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
