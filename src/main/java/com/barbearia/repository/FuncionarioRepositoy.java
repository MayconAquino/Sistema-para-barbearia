package com.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.model.Funcionario;

public interface FuncionarioRepositoy extends JpaRepository<Funcionario, Long> {

}
