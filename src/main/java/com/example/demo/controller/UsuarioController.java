package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/adicionarUsuario")
	public ResponseEntity<?> adicionarUsuario(@RequestBody UsuarioCadastroDTO usuarioDTO){
		
		  try {
	            // Chama o serviço para adicionar o usuário
	            usuarioService.salvarUsuario(usuarioDTO);

	            // Retorna uma resposta de sucesso com o status 201 (Created)
	            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
	        } catch (Exception e) {
	            // Se ocorrer algum erro, retorna uma resposta com status 400 (Bad Request) e a mensagem de erro
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar o usuário: " + e.getMessage());
	        }
	}
	
	
		
	@PutMapping("/atualizarUsuario/{userId}")
	public ResponseEntity<?> atualizarUsuario(@RequestBody UsuarioCadastroDTO usuarioDTO, @PathVariable Integer userId){
		
		  try {
	            // Chama o serviço para adicionar o usuário

	            usuarioService.atualizarUsuario(userId,usuarioDTO);

	            // Retorna uma resposta de sucesso com o status 201 (Created)
	            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário atualizado com sucesso!");
	        } catch (Exception e) {
	            // Se ocorrer algum erro, retorna uma resposta com status 400 (Bad Request) e a mensagem de erro
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar o usuário: " + e.getMessage());
	        }
	}
	
	@DeleteMapping("/excluir/{userId}")
	public ResponseEntity<?> excluir(@PathVariable Integer userId){		
		  try {
	           
	            return usuarioService.removerUsuario(userId);
	        } catch (Exception e) {
	            
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao excluir o usuário: " + e.getMessage());
	        }
	}
	
	@GetMapping("/informacoes/{idUser}")
	public UsuarioCadastroDTO informacoes(@PathVariable Integer idUser) {
		try {
			UsuarioCadastroDTO user = usuarioService.informacoes(idUser);
			return user;
			
			
		}catch(Exception e) {
			
			throw e;
		}
		
	}
	
	
}
