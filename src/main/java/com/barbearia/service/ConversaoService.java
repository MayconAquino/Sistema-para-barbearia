package com.barbearia.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ConversaoService {

	private Date dataConvertida = null;
	
	public Date stringParaDate(String data) {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			dataConvertida = formato.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dataConvertida;
	}
	
	public Date localDateParaDate(LocalDate localDate) {
		
		dataConvertida = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()); 
		
		return dataConvertida;
	}
}
