package com.danilo.gympass.interviewtest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DadosPiloto {
	private int posicaoChegada;
	private String codigoPiloto;
	private String nomePiloto;
	private int qtdVolta;
	private String tempoTotal;
	private String melhorVolta;
	private String melhorTempo;
	private String velocidadeMedia;
	private String diferencaParaOPrimeiro;
	
	
	public String getDiferencaParaOPrimeiro() {
		return diferencaParaOPrimeiro;
	}
	public void setDiferencaParaOPrimeiro(String diferencaParaOPrimeiro) {
		this.diferencaParaOPrimeiro = diferencaParaOPrimeiro;
	}
	public String getVelocidadeMedia() {
		return velocidadeMedia;
	}
	public void setVelocidadeMedia(String velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
	public String getMelhorVolta() {
		return melhorVolta;
	}
	public void setMelhorVolta(String melhorVolta) {
		this.melhorVolta = melhorVolta;
	}
	public String getMelhorTempo() {
		return melhorTempo;
	}
	public void setMelhorTempo(String melhorTempo) {
		this.melhorTempo = melhorTempo;
	}
	private long tempo;
	@JsonIgnore
	public long getTempo() {
		return tempo;
	}
	@JsonProperty
	public void setTempo(long tempo) {
		this.tempo = tempo;
	}
	public int getPosicaoChegada() {
		return posicaoChegada;
	}
	public void setPosicaoChegada(int i) {
		this.posicaoChegada = i;
	}
	public String getCodigoPiloto() {
		return codigoPiloto;
	}
	public void setCodigoPiloto(String codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}
	public String getNomePiloto() {
		return nomePiloto;
	}
	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}
	public int getQtdVolta() {
		return qtdVolta;
	}
	public void setQtdVolta(int i) {
		this.qtdVolta = i;
	}
	public String getTempoTotal() {
		return tempoTotal;
	}
	public void setTempoTotal(String tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
}
