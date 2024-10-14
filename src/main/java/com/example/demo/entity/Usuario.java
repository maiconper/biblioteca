package com.example.demo.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entityDTO.UsuarioCadastroDTO;
import com.example.demo.user.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String senha;
	
	private String email;
	
	private Role role;
	
	public Usuario() {
		
	}
	
	public Usuario(Integer id, String nome, String senha, String email, Role role) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.role = role;
	}
	
	public Usuario(String nome, String senha, Role role) {
		
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.role = role;
	}
	
	public Usuario(UsuarioCadastroDTO usuarioCadastro) {
		
		
		this.nome = usuarioCadastro.getUsername();
		this.senha = usuarioCadastro.getPassword();
		this.email = usuarioCadastro.getEmail();
		this.role = usuarioCadastro.getRole();
		
	}
	
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
		
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		return List.of(new SimpleGrantedAuthority("Role_" + this.role));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
