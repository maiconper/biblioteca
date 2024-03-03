package com.example.demo.entityDTO;

public class LivroDTO {

	private String titulo;
	
	private String autor;
	
	private String categoria;
	
	private int quantidade;

	
	
	public LivroDTO(String titulo, String autor, String categoria, int quantidade) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.quantidade = quantidade;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
