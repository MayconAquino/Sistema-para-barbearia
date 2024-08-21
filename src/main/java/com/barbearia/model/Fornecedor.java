package com.barbearia.model;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@PrimaryKeyJoinColumn(name="idPessoa")
public class Fornecedor extends Pessoa {
	private static final long serialVersionUID = 1L;
	private String endereco;
	private String telefone;
	private String email;

}
