package com.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
