package com.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.model.Cliente;

public interface ClienteRepositoy extends JpaRepository<Cliente, Long> {

}
