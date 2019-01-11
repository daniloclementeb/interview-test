package com.danilo.gympass.interviewtest.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import com.danilo.gympass.interviewtest.model.InfoPiloto;
import com.danilo.gympass.interviewtest.model.LinhaTemplate;
import com.danilo.gympass.interviewtest.model.Resposta;
import com.danilo.gympass.interviewtest.model.DadosPiloto;

public interface RunnerMap {
	/**
	 * Consolida informacoes da corrida em um mapa entre idPiloto e informacoes das voltas
	 * @param linha
	 * @return
	 */
	HashMap<String, InfoPiloto> geraMapaCorredor(List<LinhaTemplate> linha);

	/**
	 * Gera a resposta parcial
	 * @param mapa
	 * @return
	 * @throws ParseException
	 */
	List<DadosPiloto> geraRespostaParcial(HashMap<String, InfoPiloto> mapa) throws ParseException;

	/**
	 * preenche as posicoes de cada corredor
	 * @param resposta
	 * @return 
	 * @throws ParseException
	 */
	Resposta preenchePosicao(Resposta resposta) throws ParseException;
}
