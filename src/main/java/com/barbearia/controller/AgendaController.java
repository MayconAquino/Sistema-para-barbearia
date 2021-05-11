package com.barbearia.controller;

import java.time.LocalDate;
import java.util.ArrayList;
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
import com.barbearia.repository.AgendaRepository;
import com.barbearia.repository.ClienteRepositoy;
import com.barbearia.repository.FuncionarioRepositoy;
import com.barbearia.repository.HorarioRepository;
import com.barbearia.repository.ServicoRepository;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
	
	List<Agenda> agenda = new ArrayList<Agenda>();
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	@Autowired
	private FuncionarioRepositoy funcionarioRepositoy;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ClienteRepositoy clienteRepository;

	@GetMapping("/cadastro")
	public String cadastro( Agenda agenda, Model model) {
		model.addAttribute("listaDeHorarios", horarioRepository.findAll());
		model.addAttribute("listaDeFuncionarios", funcionarioRepositoy.findAll());
		model.addAttribute("listaDeServicos", servicoRepository.findAll());
		model.addAttribute("listaDeClientes", clienteRepository.findAll());

		model.addAttribute("agenda", new Agenda());
		model.addAttribute("agenda", agenda);
		return "agenda/cadastro";
	}

	@PostMapping("/salvarAgenda")
	public String salvar(Agenda agenda, Model model) {
		agendaRepository.save(agenda);
		model.addAttribute("listaDeHorarios", horarioRepository.findAll());
		model.addAttribute("listaDefuncionarios",funcionarioRepositoy.findAll());
		model.addAttribute("listaDeServicos",servicoRepository.findAll());
		model.addAttribute(new Agenda());
		return "agenda/cadastro";	
	}
	
	@GetMapping("/lista")
	public String abrirLista(Model model) {
		agenda =  agendaRepository.findAll();
		model.addAttribute("listaDeAgendas",agenda);
		return "agenda/lista";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Agenda> agenda = agendaRepository.findById(id);
		return cadastro(agenda.get(), model);
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		agendaRepository.deleteById(id);
		return abrirLista(model);
	}
	
	@PostMapping("/consultar")
	public String consultarAgendaPorDia(String consulta, Model model) {
		LocalDate dataConvertida = LocalDate.parse(consulta);
		agenda = agendaRepository.findAgendaByData(dataConvertida);
		model.addAttribute("listaDeAgendas", agenda);
		return "agenda/lista";
	}
}
