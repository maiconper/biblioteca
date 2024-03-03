package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.entityDTO.UsuarioCadastroDTO;
import com.example.demo.repository.UsuarioRepository;

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

}
