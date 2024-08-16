package com.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.model.Horario;

import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario,Long>{

    List<Horario> findAll();
}
