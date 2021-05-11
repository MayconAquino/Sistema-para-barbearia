package com.barbearia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barbearia.model.Fornecedor;
import com.barbearia.repository.FornecedorRepository;


@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@GetMapping("/cadastro")
	public String cadastro(Fornecedor fornecedor, Model model) {
		model.addAttribute("fornecedor", new Fornecedor());
		model.addAttribute("fornecedor", fornecedor);
		return "fornecedor/cadastro";
	}

	@PostMapping("/salvarFornecedor")
	public String salvar(Fornecedor fornecedor, Model model) {
		model.addAttribute("fornecedor", new Fornecedor());
		fornecedorRepository.save(fornecedor);
		return "fornecedor/cadastro";
	}

	@GetMapping("/lista")
	public String abrirLista(Model model) {
		model.addAttribute("listaFornecedor", fornecedorRepository.findAll());
		return "fornecedor/lista";
	}

	@GetMapping("editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		return cadastro(fornecedor.get(), model);
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		fornecedorRepository.deleteById(id);
		return abrirLista(model);
	}

}
