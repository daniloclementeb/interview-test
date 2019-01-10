package com.danilo.gympass.interviewtest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Resposta {
	@JsonInclude(Include.NON_NULL)
	private String melhorVoltaCorrida;
	@JsonInclude(Include.NON_NULL)
	private List<DadosPiloto> dadosCorrida;
	@JsonInclude(Include.NON_NULL)
	private String mensagem;
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getMelhorVoltaCorrida() {
		return melhorVoltaCorrida;
	}
	public void setMelhorVoltaCorrida(String melhorVoltaCorrida) {
		this.melhorVoltaCorrida = melhorVoltaCorrida;
	}
	public List<DadosPiloto> getDadosCorrida() {
		return dadosCorrida;
	}
	public void setDadosCorrida(List<DadosPiloto> dadosCorrida) {
		this.dadosCorrida = dadosCorrida;
	}
	
}
