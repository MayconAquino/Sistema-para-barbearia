package com.barbearia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barbearia.model.Saida;
import com.barbearia.repository.FornecedorRepository;
import com.barbearia.repository.ProdutoRepository;
import com.barbearia.repository.SaidaRepository;


@Controller
@RequestMapping("/saida")
public class SaidaController {
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	SaidaRepository saidaRepository;
	
	@GetMapping("/cadastro")
	public String cadastro( Saida saida, Model model) {
		model.addAttribute("listaDeFornecedor", fornecedorRepository.findAll());
		model.addAttribute("listaDeProduto",  produtoRepository.findAll());
		model.addAttribute("saida", new Saida());
		model.addAttribute("saida", saida);
		return "saida/cadastro";
	}

	@PostMapping("/salvarSaida")
	public String salvar(Saida saida, Model model) {
		saida.setTotal(saida.calcularTotal(saida.getValor(), saida.getUnidade()));
		saidaRepository.save(saida);
		model.addAttribute("listaDeFornecedor", fornecedorRepository.findAll());
		model.addAttribute("listaDeProduto",  produtoRepository.findAll());		
		model.addAttribute(new Saida());
		return "saida/cadastro";	
	}
	
	@GetMapping("/lista")
	public String abrirLista(Model model) {
		model.addAttribute("listaSaida", saidaRepository.findAll());
		return "saida/lista";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Saida> saida = saidaRepository.findById(id);
		return cadastro(saida.get(), model);
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		saidaRepository.deleteById(id);
		return abrirLista(model);
	}
	
}
