package com.example.demo.entityDTO;

import com.example.demo.user.Role;

public class UsuarioCadastroDTO {

	
	private String username;
	
	private String password;
	
	private String email;
	
	private Role role;
	
	public UsuarioCadastroDTO() {
		
		
	}
	
	public UsuarioCadastroDTO(String username, String password, Role role) {
		this.username = username;
		this.password = password;
		this.role = role;
		
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
