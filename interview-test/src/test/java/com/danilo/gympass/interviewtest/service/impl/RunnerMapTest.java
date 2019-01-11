package com.danilo.gympass.interviewtest.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.danilo.gympass.interviewtest.model.DadosPiloto;
import com.danilo.gympass.interviewtest.model.InfoPiloto;
import com.danilo.gympass.interviewtest.model.LinhaTemplate;
import com.danilo.gympass.interviewtest.model.Resposta;

@RunWith(SpringJUnit4ClassRunner.class)
public class RunnerMapTest {
	
	RunnerMapImpl runner = new RunnerMapImpl();
	@InjectMocks
	DateHelper helper;
	  @Before
	  public void setUp() throws Exception {

         MockitoAnnotations.initMocks(this);
	  }

	@Test
	public void testaMapaCorredorListaNula() throws Exception {
		assertEquals(0, runner.geraMapaCorredor(null).size());
	}
	
	@Test
	public void testaMapaCorredorLista1Elemento() throws Exception {
		List<LinhaTemplate> list = new ArrayList<LinhaTemplate>();
		LinhaTemplate el = new LinhaTemplate();
		
		list.add(el);
		assertEquals(1, runner.geraMapaCorredor(list ).size());
	}
	
	@Test
	public void testaGeraRespostaParcialMapNulo() throws ParseException {
		assertEquals(0, runner.geraRespostaParcial(null).size());
	}
	
	@Test
	public void testaGeraRespostaParcialMap1Elemento() throws ParseException {
		HashMap<String, InfoPiloto> mapa = new HashMap<String, InfoPiloto>();
		helper = mock(DateHelper.class);
		when(helper.longDateToString(any(long.class))).thenReturn("00:00.000");
		InfoPiloto piloto = new InfoPiloto();
		runner.setHelper(helper);
		mapa.put("000", piloto );
		assertEquals(1, runner.geraRespostaParcial(mapa ).size());
	}
	
	@Test
	public void testaPreenchePosicaoNull() throws ParseException {
		assertNull(runner.preenchePosicao(null));
	}
	
	@Test
	public void testaPreenchePosicaoComDadosDeCorridaVazio() throws ParseException {
		Resposta resposta = new Resposta();
		List<DadosPiloto> dadosCorrida = new ArrayList<DadosPiloto>();
		resposta.setDadosCorrida(dadosCorrida );
		assertNotNull(runner.preenchePosicao(resposta ));
	}
	
	@Test
	public void testaPreenchePosicaoCom1Elemento() throws ParseException {
		Resposta resposta = new Resposta();
		List<DadosPiloto> dadosCorrida = new ArrayList<DadosPiloto>();
		DadosPiloto e = new DadosPiloto();
		dadosCorrida.add(e);
		resposta.setDadosCorrida(dadosCorrida );
		assertNotNull(runner.preenchePosicao(resposta ));
	}
}
