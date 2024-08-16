package com.barbearia.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Funcionario extends Pessoa {
	private static final long serialVersionUID = 1L;
	private Double comissao;
	private String funcao;
	private String login;
	private String senha;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataAdmissao;

	@OneToMany
	private List<Horario> horarios = new ArrayList<>();

	public Funcionario() {
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

	public Funcionario(Double comissao, String nome, String funcao, LocalDate dataAdmissao, String login, String senha) {
		super(nome);
		this.comissao = comissao;
		this.funcao = funcao;
		this.dataAdmissao = dataAdmissao;
		this.login = login;
		this.senha = senha;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

}
