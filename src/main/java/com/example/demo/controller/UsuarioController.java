package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;
import com.example.demo.entityDTO.UsuarioCadastroDTO;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	/*
	 * @PostMapping("/cadastro") public ResponseEntity<Usuario>
	 * cadastrarUsuario(@RequestBody UsuarioCadastroDTO usuarioDTO){
	 * 
	 * 
	 * return ResponseEntity.ok(usuarioService.cadastrar(usuarioDTO));
	 * 
	 * }
	 */

	@GetMapping("/teste")
	public String teste(){
		
		return "Teste";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> autenticarUsuario(@RequestBody Usuario usuario){
		boolean autenticado = usuarioService.autenticar(usuario.getEmail(), usuario.getSenha());
		
		if(autenticado) {
			return ResponseEntity.ok("Usuario autenticado com sucesso");
		} else {
			return ResponseEntity.badRequest().body("Falha na autenticação");
		}
		
	}
	
}
