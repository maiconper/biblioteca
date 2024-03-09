package com.example.demo.entity;

import java.time.LocalDate;

import com.example.demo.entityDTO.EmprestimoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer usuarioId;
	
	private Integer livroId;
	
	private LocalDate dataEmprestimo;
	
	private LocalDate dataDevolucao;
	
	public Emprestimo() {
		
	}

	public Emprestimo(Integer id, Integer usuarioId, Integer livroId, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		this.id = id;
		this.usuarioId = usuarioId;
		this.livroId = livroId;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}
	
	public Emprestimo(EmprestimoDTO emprestimo) {
		this.usuarioId = emprestimo.getUsuarioId();
		this.livroId = emprestimo.getLivroId();
		this.dataEmprestimo = emprestimo.getDateEmprestimo();
		this.dataDevolucao = emprestimo.getDataDevolucao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}
	
	

}
