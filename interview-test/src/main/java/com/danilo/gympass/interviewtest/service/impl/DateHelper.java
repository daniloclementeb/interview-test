package com.danilo.gympass.interviewtest.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

@Component
public class DateHelper {
	
	private final SimpleDateFormat format = new SimpleDateFormat("mm:ss.SSS");
	
	/**
	 * Metodo responsavel por calcular a diferenca de dois tempos
	 * @param tempoInicial
	 * @param tempoFinal
	 * @return diferenca no formato string mm:ss.SSS
	 * @throws ParseException
	 */
	public String calculaDiferencaTempo(String tempoInicial, String tempoFinal) throws ParseException {
		long t1 = stringDateToLong(tempoInicial);
		long t2 = stringDateToLong(tempoFinal);
		if (t1 > t2) {
			throw new ParseException("valores invalidos", 0);
		}
		return longDateToString(t2-t1);
	}

	/**
	 * formata um campo numerico em String
	 * @param l
	 * @return String no formato mm:ss.SSS
	 * @throws ParseException 
	 */
	public String longDateToString(long l) throws ParseException {
		if (l<=0) {
			throw new ParseException("valores invalidos", 0);
		}
		return format.format(l);
	}

	/**
	 * Transforma uma string no formato mm:ss.SSS em um timestamp do tipo long
	 * @param t0
	 * @return
	 * @throws ParseException
	 */
	public long stringDateToLong(String t0) throws ParseException {
		return format.parse(t0).getTime();
	}
}
