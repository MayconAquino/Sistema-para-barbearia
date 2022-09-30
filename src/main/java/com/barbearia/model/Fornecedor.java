package com.barbearia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class Fornecedor extends Pessoa {
	private static final long serialVersionUID = 1L;
	private String endereco;
	private String telefone;
	private String email;

	public Fornecedor() {
		//testegit
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
