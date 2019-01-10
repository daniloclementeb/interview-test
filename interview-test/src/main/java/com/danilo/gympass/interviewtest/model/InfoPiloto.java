package com.danilo.gympass.interviewtest.model;

import java.util.List;

public class InfoPiloto {
	private String nome;
	private long tempoTotal;
	private String melhorVolta;
	private String melhorTempo;
	private double velocidadeMedia;
		
	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}
	public void setVelocidadeMedia(double velocidadeMedia) {
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
	private List<Volta> voltas;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Volta> getVoltas() {
		return voltas;
	}
	public void setVoltas(List<Volta> voltas) {
		this.voltas = voltas;
	}
	public long getTempoTotal() {
		return tempoTotal;
	}
	public void setTempoTotal(long tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	
}
