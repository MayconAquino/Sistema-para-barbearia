package com.barbearia.model;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class Fornecedor extends Pessoa {
	private static final long serialVersionUID = 1L;
	private String endereco;
	private String telefone;
	private String email;

	public Fornecedor() {
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

	public Fornecedor(String nome, String endereco, String telefone, String email) {
		super(nome);
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
