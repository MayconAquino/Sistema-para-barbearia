package com.barbearia.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ConversaoService {

	public Date stringParaDate(String data) {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataConvertida = null;
		
		try {
			dataConvertida = formato.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dataConvertida;
	}
}
