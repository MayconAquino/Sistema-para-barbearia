package com.barbearia.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}
