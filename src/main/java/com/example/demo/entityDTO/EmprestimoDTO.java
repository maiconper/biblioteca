package com.example.demo.entityDTO;

import java.time.LocalDate;

public class EmprestimoDTO {

	private Integer usuarioId;
	
	private Integer livroId;
	
	private LocalDate dateEmprestimo;
	
	

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
