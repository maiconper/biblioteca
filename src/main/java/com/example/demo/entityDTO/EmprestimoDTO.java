package com.example.demo.entityDTO;

import java.time.LocalDate;

import com.example.demo.entity.Emprestimo;

public class EmprestimoDTO {

	private Integer usuarioId;
	
	private Integer livroId;
	
	private LocalDate dateEmprestimo;
	
	
	public EmprestimoDTO() {
		
	}
	
	
	public EmprestimoDTO(Integer usuarioId, Integer livroId, LocalDate dateEmprestimo) {
		super();
		this.usuarioId = usuarioId;
		this.livroId = livroId;
		this.dateEmprestimo = dateEmprestimo;
	}


	public EmprestimoDTO(Emprestimo emprestimo) {
		this.usuarioId = emprestimo.getUsuarioId();
		this.livroId = emprestimo.getLivroId();
		this.dateEmprestimo = emprestimo.getDataEmprestimo();
		
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
	
	
}
