package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer>{

	List<Emprestimo> findByUsuarioId (Integer id);

}
