package com.barbearia.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barbearia.repository.AgendaRepository;

@Controller
public class IndexController {
	
	@Autowired
	private AgendaRepository agendaRepository;

	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("mdbarbearia", "MD BARBEARIA");
		model.addAttribute("dataAtual", LocalDate.now());
		model.addAttribute("agendaDoDiaAtual", agendaRepository.findAgendaByData(LocalDate.now()));
		return "index";
	}
	
}
