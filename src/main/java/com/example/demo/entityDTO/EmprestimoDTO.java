package com.example.demo.entityDTO;

import java.time.LocalDate;

import com.example.demo.entity.Emprestimo;

public class EmprestimoDTO {

	private Integer usuarioId;
	
	private Integer livroId;
	
	private LocalDate dateEmprestimo;
	
	private LocalDate dataDevolucao;
	
	
	public EmprestimoDTO() {
		
	}
	
	
	public EmprestimoDTO(Integer usuarioId, Integer livroId, LocalDate dateEmprestimo, LocalDate dataDevolucao) {
		super();
		this.usuarioId = usuarioId;
		this.livroId = livroId;
		this.dateEmprestimo = dateEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}
	
	public EmprestimoDTO(Integer livroId) {
		this.livroId = livroId;
		
	}


	public EmprestimoDTO(Emprestimo emprestimo) {
		this.usuarioId = emprestimo.getUsuarioId();
		this.livroId = emprestimo.getLivroId();
		this.dateEmprestimo = emprestimo.getDataEmprestimo();
		this.dataDevolucao = emprestimo.getDataDevolucao();
		this.usuarioId = emprestimo.getUsuarioId();
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

	public LocalDate getDateEmprestimo() {
		return dateEmprestimo;
	}

	public void setDateEmprestimo(LocalDate dateEmprestimo) {
		this.dateEmprestimo = dateEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}


	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	
}
