package com.example.demo.service;

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
	

	public Emprestimo realizarEmprestimo(EmprestimoDTO emprestimoDTO) {
		
		Emprestimo emprestimo = new Emprestimo();
		
		emprestimo.setUsuarioId(emprestimoDTO.getUsuarioId());
		emprestimo.setLivroId(emprestimoDTO.getLivroId());
		emprestimo.setDataDevolucao(emprestimoDTO.getDateEmprestimo().plusWeeks(2));
		emprestimo.setDataEmprestimo(emprestimoDTO.getDateEmprestimo());
		
		Livro livro = livroRepository.findById(emprestimoDTO.getLivroId()).orElseThrow(()-> new RuntimeException("Livro não encontrado!"));
		livro.setQuantidade(livro.getQuantidade() -1);
		livroRepository.save(livro);
		
		return emprestimoRepository.save(emprestimo);
	}

	
}
