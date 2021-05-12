package com.barbearia.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.barbearia.model.Funcionario;
import com.barbearia.repository.FuncionarioRepositoy;
import com.barbearia.service.RelatorioService;

@Controller
@RequestMapping("/relatorio")
public class RelatórioController {
	
	@Autowired
	private RelatorioService relatorioService;
	
	@Autowired
	private FuncionarioRepositoy funcionarioRepositoy;
	
	@GetMapping("/")
	public String visualizarTodosRelatorios(/*Model model*/) {
		
//		model.addAttribute("listaDeFuncionarios", funcionarioRepositoy.findAll());
		
		return "relatorio";
	}
	@PostMapping("/01/{nomeDoRelatorio}")
	public void relatorioPorDataAtual(@PathVariable("nomeDoRelatorio") String nomeDoRelatorio, @RequestParam(name = "porDataAtual") String data, HttpServletResponse response) throws IOException {
		relatorioService.porDataAtual(nomeDoRelatorio, data, response);
	}
	
	@PostMapping("/02/{nomeDoRelatorio}")
	public void relatorioDeClientes(@PathVariable("nomeDoRelatorio") String nomeDoRelatorio, HttpServletResponse response) throws IOException {
		relatorioService.clientes(nomeDoRelatorio, response);
	}
	
	@PostMapping("/03/{nomeDoRelatorio}")
	public void saidas(@PathVariable("nomeDoRelatorio") String nomeDoRelatorio, @RequestParam(name = "dataSaida") String dataSaida, HttpServletResponse response) throws IOException {
		relatorioService.saidas(nomeDoRelatorio, dataSaida, response);
	}
	
	@PostMapping("/04/{nomeDoRelatorio}")
	public void relatorioPorData(@PathVariable("nomeDoRelatorio") String nomeDoRelatorio, @RequestParam(name = "porData") String data, HttpServletResponse response) throws IOException {
		relatorioService.porData(nomeDoRelatorio, data, response);
	}
	@PostMapping("/05/{nomeDoRelatorio}")
	public void relatorioPorFuncionarios(@PathVariable("nomeDoRelatorio") String nomeDoRelatorio, @RequestParam(name = "idDoFuncionario") Long idDoFuncionario, HttpServletResponse response) throws IOException {
		relatorioService.porFuncionario(nomeDoRelatorio, idDoFuncionario, response);
	}
	
	@ModelAttribute("listaDeFuncionarios")
	public List<Funcionario> listaDeFuncionarios() {
		return funcionarioRepositoy.findAll();
	}
}

