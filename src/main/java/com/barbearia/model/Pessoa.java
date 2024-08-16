package com.barbearia.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;
	
	String nome;

	public Pessoa() {
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public abstract String getPassword();

	public abstract String getUsername();

	public abstract boolean isAccountNonExpired();
}
