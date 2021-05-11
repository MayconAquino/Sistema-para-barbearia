package com.barbearia.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {
	
	@Autowired
	private JasperService jasperService;
	
	@Autowired
	private ConversaoService conversaoService;
	
	
	public void porDataAtual(String nomeDoRelatorio, String data, HttpServletResponse response) throws IOException {
		
		jasperService.addParams("pordataatual", conversaoService.stringParaDate(data));
		
		byte[] bytes = jasperService.exportarPDF(nomeDoRelatorio);
		
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.setHeader("Content-disposition", "attachment; filename=relatorio-" + nomeDoRelatorio + ".pdf");
		response.getOutputStream().write(bytes);
		
	}
	
	public void clientes(String nomeDoRelatorio, HttpServletResponse response) throws IOException {
		
		byte[] bytes = jasperService.exportarPDF(nomeDoRelatorio);
		
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.setHeader("Content-disposition", "attachment; filename=relatorio-" + nomeDoRelatorio + ".pdf");
		response.getOutputStream().write(bytes);
	}
	
	public void saidas(String nomeDoRelatorio, HttpServletResponse response) throws IOException {
		
		byte[] bytes = jasperService.exportarPDF(nomeDoRelatorio);
		
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.setHeader("Content-disposition", "attachment; filename=relatorio-" + nomeDoRelatorio + ".pdf");
		response.getOutputStream().write(bytes);
	}
	
	public void porData(String nomeDoRelatorio, String data, HttpServletResponse response) throws IOException {
		
		jasperService.addParams("pordata", conversaoService.stringParaDate(data));
		
		byte[] bytes = jasperService.exportarPDF(nomeDoRelatorio);
		
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.setHeader("Content-disposition", "attachment; filename=relatorio-" + nomeDoRelatorio + ".pdf");
		response.getOutputStream().write(bytes);
	}
	
	
	public void porFuncionario(String nomeDoRelatorio, String funcionario, HttpServletResponse response) throws IOException {
		
		jasperService.addParams("porFuncionario", conversaoService.stringParaDate(funcionario));
		
		byte[] bytes = jasperService.exportarPDF(nomeDoRelatorio);
		
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.setHeader("Content-disposition", "attachment; filename=relatorio-" + nomeDoRelatorio + ".pdf");
		response.getOutputStream().write(bytes);
	}
	

}
