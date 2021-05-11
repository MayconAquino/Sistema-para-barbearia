package com.barbearia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barbearia.model.Funcionario;
import com.barbearia.repository.FuncionarioRepositoy;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepositoy funcionarioRepositoy;
	
	@GetMapping("/cadastro")
	public String cadastro(Funcionario funcionario, Model model) {
		model.addAttribute("funcionario", new Funcionario());
		model.addAttribute("funcionario", funcionario);	
		return "funcionario/cadastro";
	}
	
	@PostMapping("salvarFuncionario")
	public String salvar(Funcionario funcionario, Model model) {
		funcionarioRepositoy.save(funcionario);
		model.addAttribute("funcionario", new Funcionario());	
		return "funcionario/cadastro";
	}
	
	@GetMapping("/lista")
	public String abrirLista(Model model) {	
		model.addAttribute("listaFuncionarios", funcionarioRepositoy.findAll());
		return "funcionario/lista";
		
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		funcionarioRepositoy.deleteById(id);
		return abrirLista(model);
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Funcionario> funcionario = funcionarioRepositoy.findById(id);
		return cadastro(funcionario.get(), model);
	}
}
