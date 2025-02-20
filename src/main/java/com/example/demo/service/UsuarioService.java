package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

	public Optional<Usuario> findById(Integer userId) {
		
		return usuarioRepository.findById(userId);
	}
	
	public ResponseEntity<?> removerUsuario(Integer userId) {
		try {
			
			usuarioRepository.deleteById(userId);
			return ResponseEntity.status(HttpStatus.OK).body("Usuario removido!");
		}catch(Exception e){
			throw new RuntimeException("Usuario nao encotrado!");
		}
		
	}
	
	public UsuarioCadastroDTO informacoes(Integer userId) {
		try {
			
			Optional<Usuario> user = usuarioRepository.findById(userId);
			if(user.isEmpty()) {
				
				throw new RuntimeException("Usuario nao encontrado!");
			}
			
			return new UsuarioCadastroDTO(user.get());
			
		}catch(Exception e){
			
			throw e;
		}
		
		
	}
	
	public UsuarioCadastroDTO atualizarUsuario(Integer userId, UsuarioCadastroDTO newUser) {
		
		String username = newUser.getUsername();		
		String password = newUser.getPassword();		
		String email = newUser.getEmail();		
		Role role = newUser.getRole();
		
		try {
	        Optional<Usuario> oldUser = usuarioRepository.findById(userId);
	        
	        if(!oldUser.isPresent()) {
	        	
	        	throw new RuntimeException("Usuario nao encontrado!");
	        }
	        
	        if(!username.isEmpty()) {
	        	oldUser.get().setNome(username);
	        }
	        if(!!email.isEmpty()) {
	        	oldUser.get().setEmail(email);
	        }
	        if(!password.isEmpty()) {
	        	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    		
	        	oldUser.get().setSenha(passwordEncoder.encode(password));
	        	
	        }
	        if(role != null) {
	        	oldUser.get().setRole(role);
	        }
	        
	        usuarioRepository.save(oldUser.get());
	        
	        return new UsuarioCadastroDTO(oldUser.get());
		
		} catch(Exception e) {
			throw e;
		}
		
		
	}

}
