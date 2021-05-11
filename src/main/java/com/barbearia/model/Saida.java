package com.barbearia.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Saida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Fornecedor fornecedor;

	@ManyToOne
	private Produto produto;

	private Double valor;
	private int unidade;
	private Double total;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataSaida;

	public Saida() {
		// TODO Auto-generated constructor stub
	}

	public Saida(Fornecedor fornecedor, Produto produto, Double valor, int unidade, Double total, LocalDate dataSaida) {
		super();
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.valor = valor;
		this.unidade = unidade;
		this.total = total;
		this.dataSaida = dataSaida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Double calcularTotal(Double valor, int unidade) {
		return valor * unidade;
	}

}
