package com.danilo.gympass.interviewtest.model;

public class Volta {
	private String horaInicio;
	private String nVolta;
	private String tempo;
	private String velocidade;
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getnVolta() {
		return nVolta;
	}
	public void setnVolta(String nVolta) {
		this.nVolta = nVolta;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	public String getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}
	
	public static Volta linhaToVolta(LinhaTemplate e) {
		Volta v = new Volta();
		v.setHoraInicio(e.getHora());
		v.setnVolta(e.getnVolta());
		v.setTempo(e.getTempoVolta());
		v.setVelocidade(e.getVelocidadeMedia());
		return v ;
	}
}
