package com.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.barbearia.model.Funcionario;

public interface FuncionarioRepositoy extends JpaRepository<Funcionario, Long> {

	@Query("SELECT f FROM Funcionario f WHERE f.login = ?1")
	Funcionario findByLogin(String login);
	
}
