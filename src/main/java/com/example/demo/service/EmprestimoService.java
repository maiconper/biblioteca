package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Emprestimo;
import com.example.demo.entity.Livro;
import com.example.demo.repository.EmprestimoRepository;
import com.example.demo.repository.LivroRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	

	public Emprestimo realizarEmprestimo(Emprestimo emprestimo) {
		
		Emprestimo novoEmprestimo = emprestimo;
		
		novoEmprestimo.setUsuarioId(emprestimo.getUsuarioId());
		novoEmprestimo.setLivroId(emprestimo.getLivroId());
		novoEmprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusWeeks(2));
		novoEmprestimo.setDataEmprestimo(emprestimo.getDataEmprestimo());
		
		Livro livro = livroRepository.findById(emprestimo.getLivroId()).orElseThrow(()-> new RuntimeException("Livro não encontrado!"));
		livro.setQuantidade(livro.getQuantidade() -1);
		livroRepository.save(livro);
		
		return emprestimoRepository.save(novoEmprestimo);
	}
	
	public List<Emprestimo> listarEmprestimos(Integer id){
		return emprestimoRepository.findByUsuarioId(id);
	}

	
}
