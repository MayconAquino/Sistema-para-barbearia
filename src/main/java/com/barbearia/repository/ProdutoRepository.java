package com.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
