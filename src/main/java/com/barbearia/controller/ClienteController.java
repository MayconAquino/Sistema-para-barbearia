package com.barbearia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.barbearia.model.Cliente;
import com.barbearia.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	@PostMapping("/salvarCliente")
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(clienteRepository.save(cliente));
	}

	@GetMapping("/lista")
	public List<Cliente> abrirLista() {
		return clienteRepository.findAll();
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente clienteAtualizado) {
		return clienteRepository.findById(id)
				.map(cliente -> {
					cliente.setNome(clienteAtualizado.getNome());
					cliente.setEndereco(clienteAtualizado.getEndereco());
					cliente.setTelefone(clienteAtualizado.getTelefone());
					cliente.setEmail(clienteAtualizado.getEmail());

					Cliente clienteSalvo = clienteRepository.save(cliente);

					return ResponseEntity.ok(clienteSalvo);
				})
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletarCliente(@PathVariable("id") Long id) {
		return clienteRepository.findById(id)
				.map(cliente -> {
					clienteRepository.delete(cliente);
					return ResponseEntity.noContent().build();
				})
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
