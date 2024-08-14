package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Usuario;
import com.example.demo.user.Role;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	List<Usuario> findByRole(Role role);

	Optional<Usuario> findById (Long id);

	Optional<Usuario> findByNome(String nome);
	
}
