package com.barbearia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barbearia.model.Agenda;
import com.barbearia.model.Servico;
import com.barbearia.repository.AgendaRepository;
import com.barbearia.repository.ServicoRepository;

@Controller
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	AgendaRepository agendaRepository;

	@GetMapping("/cadastro")
	public String cadastro(Servico servico, Model model) {
		model.addAttribute("servico", new Servico());
		model.addAttribute("servico", servico);
		return "servico/cadastro";
	}

	@PostMapping("salvarServico")
	public String salvar(Servico servico, Model model) {
		model.addAttribute("servico", new Servico());
		servicoRepository.save(servico);
		return "servico/cadastro";

	}

	@GetMapping("/lista")
	public String abrirLista(Model model) {
		model.addAttribute("listaDeServicos", servicoRepository.findAll());
		return "servico/lista";
	}

	@GetMapping("editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Servico> servico = servicoRepository.findById(id);
		return cadastro(servico.get(), model);
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		
		Servico servico = servicoRepository.getOne(id);
		List<Agenda> agenda = agendaRepository.findByServico(servico);
		
		if (agenda.isEmpty()) {
			servicoRepository.deleteById(id);
			model.addAttribute("msgDeSucesso", "Serviço excluído com sucesso!");
			return abrirLista(model);
		} else {
			model.addAttribute("msgDeErro", "Esse serviço já possui agendas. Sendo assim, não é possível excluir!");
			return abrirLista(model);
		}
	}
}
