package com.danilo.gympass.interviewtest.model;

import java.util.ArrayList;

public class LinhaTemplate {
	private String hora;
	private String idPiloto;
	private String nomePiloto;
	private String nVolta;
	private String tempoVolta;
	private String velocidadeMedia;
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getIdPiloto() {
		return idPiloto;
	}
	public void setIdPiloto(String idPiloto) {
		this.idPiloto = idPiloto;
	}
	public String getNomePiloto() {
		return nomePiloto;
	}
	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}
	public String getnVolta() {
		return nVolta;
	}
	public void setnVolta(String nVolta) {
		this.nVolta = nVolta;
	}
	public String getTempoVolta() {
		return tempoVolta;
	}
	public void setTempoVolta(String tempoVolta) {
		this.tempoVolta = tempoVolta;
	}
	public String getVelocidadeMedia() {
		return velocidadeMedia;
	}
	public void setVelocidadeMedia(String velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
	public static LinhaTemplate parse(String el) {
		//no arquivo exemplo tinhamos tanto a separacao por espacos quanto por tabulacao
		//realizei a uniformizacao dos dois padroes para setar os dados
		String[] array = el.replaceAll("\t", " ").split(" ");
		//valida arquivo vazio
		if (el.length()<=1) {
			return null;
		}
		ArrayList<String> list = new ArrayList<String>();
		for (String e:array) {
			if (!e.trim().isEmpty()) {
				list.add(e.trim());
			}
		}
		LinhaTemplate t = new LinhaTemplate();
		if (!list.isEmpty()) {
			t .setHora(list.get(0));
			t.setIdPiloto(list.get(1));
			t.setNomePiloto(list.get(3));
			t.setnVolta(list.get(4));
			t.setTempoVolta(list.get(5));
			t.setVelocidadeMedia(list.get(6).replace(",", "."));
		}
		return t;
	}
}
