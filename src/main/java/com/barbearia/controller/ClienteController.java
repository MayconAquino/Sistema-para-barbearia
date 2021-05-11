package com.barbearia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barbearia.model.Cliente;
import com.barbearia.model.Servico;
import com.barbearia.repository.ClienteRepositoy;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteRepositoy clienteRepository;

	@GetMapping("/cadastro")
	public String cadastro(Cliente cliente, Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("cliente", cliente);
		return "cliente/cadastro";
	}

	@PostMapping("/salvarCliente")
	public String salvar(Cliente cliente, Model model) {
		model.addAttribute("cliente", new Cliente());
		clienteRepository.save(cliente);
		return "cliente/cadastro";
	}

	@GetMapping("/lista")
	public String abrirLista(Model model) {
		model.addAttribute("listaClientes", clienteRepository.findAll());
		return "cliente/lista";
	}

	@GetMapping("editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cadastro(cliente.get(), model);
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		clienteRepository.deleteById(id);
		return abrirLista(model);
	}
}
