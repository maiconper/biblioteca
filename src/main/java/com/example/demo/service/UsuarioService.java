package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.entityDTO.UsuarioCadastroDTO;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.user.Role;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 * 
	 * public Usuario cadastrar(UsuarioCadastroDTO usuarioDTO) {
	 * 
	 * Usuario usuario = new Usuario();
	 * 
	 * usuario.setNome(usuarioDTO.getName());
	 * usuario.setEmail(usuarioDTO.getEmail());
	 * usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
	 * 
	 * return usuarioRepository.save(usuario); }
	 */

	public boolean autenticar(Object email, String senha) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void assignRoleTouser(Long userId, Role role) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(userId);
		Usuario usuario = usuarioOpt.orElseThrow(()-> new RuntimeException("Usuario nao encontrado !" + userId));
		usuarioRepository.save(usuario);
		
	}
	
	public void salvarUsuario(UsuarioCadastroDTO usuarioDTO) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		usuarioDTO.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
		Usuario usuario = new Usuario(usuarioDTO);
		
		usuarioRepository.save(usuario);
		
	}
	
	public Optional<Usuario> findByName(String name) {
		
		return usuarioRepository.findByNome(name);
	}

}
