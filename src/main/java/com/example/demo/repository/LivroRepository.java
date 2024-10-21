package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
	
	  @Query("SELECT l FROM Livro l WHERE l.quantidade > 0")
	    List<Livro> findLivrosDisponiveis();

}
