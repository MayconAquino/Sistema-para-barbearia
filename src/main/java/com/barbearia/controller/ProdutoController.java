package com.barbearia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barbearia.model.Produto;
import com.barbearia.repository.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	
	@Autowired
	ProdutoRepository produtoController;
	
	@GetMapping("/cadastro")
	public String cadastro(Produto produto, Model model) {
		model.addAttribute("produto", new Produto());
		model.addAttribute("produto", produto);
		return "produto/cadastro";
	}

	@PostMapping("/salvarProduto")
	public String salvar(Produto produto, Model model) {
		model.addAttribute("produto", new Produto());
		produtoController.save(produto);
		return "produto/cadastro";
	}

	@GetMapping("/lista")
	public String abrirLista(Model model) {
		model.addAttribute("listaProduto", produtoController.findAll());
		return "produto/lista";
	}

	@GetMapping("editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Produto> produto = produtoController.findById(id);
		return cadastro(produto.get(), model);
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		produtoController.deleteById(id);
		return abrirLista(model);
	}

}
