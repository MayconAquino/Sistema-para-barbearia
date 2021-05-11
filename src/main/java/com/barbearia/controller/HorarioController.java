package com.barbearia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barbearia.model.Horario;
import com.barbearia.repository.HorarioRepository;

@Controller
@RequestMapping("/horario")
public class HorarioController {

	@Autowired
	HorarioRepository horarioRepository;

	@GetMapping("/cadastro")
	public String cadastro(Horario horario, Model model) {
		model.addAttribute("horario", new Horario());
		model.addAttribute("horario", horario);
		return "horario/cadastro";
	}

	@PostMapping("salvarHorario")
	public String salvar(Horario horario, Model model) {
		horarioRepository.save(horario);
		model.addAttribute("horario", new Horario());
		return "horario/cadastro";

	}

	@GetMapping("/lista")
	public String abrirLista(Model model) {
		model.addAttribute("listaHorarios", horarioRepository.findAll());
		return "horario/lista";

	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		horarioRepository.deleteById(id);
		return abrirLista(model);
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Horario> horario = horarioRepository.findById(id);
		return cadastro(horario.get(), model);
	}
}
