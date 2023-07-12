package com.barbearia.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class Cliente extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	private String endereco;
	private String telefone;
	private String email;
	

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}


	public Cliente(String nome, String endereco, String telefone, String email) {
		super(nome);
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereço) {
		this.endereco = endereço;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
		

}
