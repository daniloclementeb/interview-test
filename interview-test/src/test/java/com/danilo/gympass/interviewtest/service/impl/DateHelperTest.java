package com.danilo.gympass.interviewtest.service.impl;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) 
public class DateHelperTest {

	DateHelper dateHelper = new DateHelper();
	
	
	
	@Test
	public void testaDiferencaTempoValoresNormais() throws ParseException {		
		String tempoInicial="00:00.000";
		String tempoFinal="00:10.000";
		assertEquals("00:10.000", dateHelper.calculaDiferencaTempo(tempoInicial, tempoFinal));
	}
	@Test(expected=ParseException.class)
	public void testaDiferencaTempoResultadoNegativo() throws ParseException {		
		String tempoInicial="00:10.000";
		String tempoFinal="00:00.000";
		dateHelper.calculaDiferencaTempo(tempoInicial, tempoFinal);
	}
	@Test(expected=ParseException.class)
	public void testaDiferencaTempoPassandoTexto() throws ParseException {		
		String tempoInicial="abacaxi";
		String tempoFinal="00:00.000";
		dateHelper.calculaDiferencaTempo(tempoInicial, tempoFinal);
	}
	@Test(expected=ParseException.class)
	public void testaDiferencaTempoResultadoMinutoInvalida() throws ParseException {		
		String tempoInicial="90:10.000";
		String tempoFinal="00:00.000";
		dateHelper.calculaDiferencaTempo(tempoInicial, tempoFinal);
	}
	@Test(expected=ParseException.class)
	public void testaLongDateToStringNumeroNegativo() throws ParseException {		
		dateHelper.longDateToString(-1);
	}
	@Test(expected=ParseException.class)
	public void testaLongDateToStringZero() throws ParseException {		
		dateHelper.longDateToString(0);
	}
	@Test
	public void testaLongDateToStringNormal() throws ParseException {		
		assertEquals("00:00.010",dateHelper.longDateToString(10));
	}
	@Test
	public void testaStringDateToLongNormal() throws ParseException {		
		assertEquals(10810000,dateHelper.stringDateToLong("00:10.000"));
	}
	@Test(expected=ParseException.class)
	public void testaStringDateToLongTexto() throws ParseException {		
		dateHelper.stringDateToLong("abacaxi");
	}
}
