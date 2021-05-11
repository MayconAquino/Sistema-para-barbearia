package com.barbearia.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity /* Cria a tabela Agenda no banco de dados */
public class Agenda {

	@Id /* Identifica qual atributo/campo será o id(chave primária) da tabela Agenda */
	@GeneratedValue(strategy = GenerationType.IDENTITY) /* Gera o id de forma automática/sequencial 1,2,3.... */
	private Long id;

	@ManyToOne /* Uma agenda pode ter vários funcionários */
	private Funcionario funcionario;
	
	@ManyToOne
	private Cliente cliente;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dia;
	
	@NotNull
	@ManyToOne
	private Horario horario;

	@ManyToOne
	private Servico servico;

	public Agenda() {

	}

	public Agenda(Funcionario funcionario, Cliente cliente, LocalDate dia, Horario horario, Servico servico) {
		super();
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.dia = dia;
		this.horario = horario;
		this.servico = servico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

}
