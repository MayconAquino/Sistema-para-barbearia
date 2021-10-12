package com.barbearia.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.barbearia.model.Agenda;
import com.barbearia.model.Cliente;
import com.barbearia.model.Servico;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
	
	@Query("SELECT a FROM Agenda a WHERE a.dia = ?1 ORDER BY a.horario.hora ASC")
	List<Agenda> findAgendaByData(LocalDate consulta);

	@Query("SELECT a FROM Agenda a WHERE a.funcionario.id = ?1 ORDER BY a.dia ASC")
	List<Agenda> findAgendaByFuncionario(Long id);
	
	List<Agenda> findByServico(Servico servico);
	
	List<Cliente> findByCliente(Cliente cliente);
}
