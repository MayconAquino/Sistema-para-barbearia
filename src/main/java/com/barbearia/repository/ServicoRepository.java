package com.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
