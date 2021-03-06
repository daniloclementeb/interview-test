package com.danilo.gympass.interviewtest.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danilo.gympass.interviewtest.model.DadosPiloto;
import com.danilo.gympass.interviewtest.model.DadosPilotoComparator;
import com.danilo.gympass.interviewtest.model.InfoPiloto;
import com.danilo.gympass.interviewtest.model.LinhaTemplate;
import com.danilo.gympass.interviewtest.model.Resposta;
import com.danilo.gympass.interviewtest.model.Volta;
import com.danilo.gympass.interviewtest.service.RunnerMap;

@Component
public class RunnerMapImpl implements RunnerMap{
	
	@Autowired
	DateHelper helper;
	
	@Override
	public HashMap<String, InfoPiloto> geraMapaCorredor(List<LinhaTemplate> linha) {
		
		HashMap<String, InfoPiloto> mapa = new HashMap<String, InfoPiloto>();
		if (linha != null) {
			for (LinhaTemplate t: linha) {
				Volta v = Volta.linhaToVolta(t);
				
				if (mapa.containsKey(t.getIdPiloto())) {
					if (mapa.get(t.getIdPiloto()).getVoltas().size() < 4) {
						mapa.get(t.getIdPiloto()).getVoltas().add(v);						
					} else {
						System.out.println("size maior que 4");
					}
				} else {
					ArrayList<Volta> list = new ArrayList<Volta>();
					list.add(v);
					InfoPiloto info = new InfoPiloto();
					info.setNome(t.getNomePiloto());
					info.setVoltas(list);
					mapa.put(t.getIdPiloto(), info);
				}
			}
		}
		return mapa;
	}

	@Override
	public List<DadosPiloto> geraRespostaParcial(HashMap<String, InfoPiloto> mapa) throws ParseException {
		ArrayList<DadosPiloto> list = new ArrayList<DadosPiloto>();
		if (mapa != null) {
			Iterator<Entry<String, InfoPiloto>> iterator = mapa.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<String, InfoPiloto> el = iterator.next();
				DadosPiloto r = populaResposta(el);
				list.add(r);
			}
			list.sort(new DadosPilotoComparator());
		}
		return list;
	}

	private DadosPiloto populaResposta(Entry<String, InfoPiloto> el) throws ParseException {
		DadosPiloto r = new DadosPiloto();
		r.setCodigoPiloto(el.getKey());
		r.setNomePiloto(el.getValue().getNome());
		if (el.getValue().getVoltas() == null) {
			r.setQtdVolta(0);
		} else {
			r.setQtdVolta(el.getValue().getVoltas().size());
		}
		r.setTempoTotal(calculaTempoTotal(el.getValue()));
		r.setTempo(el.getValue().getTempoTotal());
		r.setMelhorVolta(el.getValue().getMelhorVolta());
		r.setMelhorTempo(el.getValue().getMelhorTempo());
		r.setVelocidadeMedia(String.format("%.2f", el.getValue().getVelocidadeMedia()).replace(",", "."));
		return r;
	}

	private String calculaTempoTotal(InfoPiloto infoPiloto) throws ParseException {
		long total = 0;
		double velocidadeTotal = 0;
		if (infoPiloto.getVoltas() != null) {
			for (Volta v:infoPiloto.getVoltas()) {
				long tempo = helper.stringDateToLong(v.getTempo());
				total += tempo;
				if (infoPiloto.getMelhorTempo() == null) {
					infoPiloto.setMelhorTempo(helper.longDateToString(tempo));
					infoPiloto.setMelhorVolta(v.getnVolta());
				} else if (helper.stringDateToLong(infoPiloto.getMelhorTempo()) > tempo) {
					infoPiloto.setMelhorTempo(helper.longDateToString(tempo));
					infoPiloto.setMelhorVolta(v.getnVolta());
				}
				velocidadeTotal += Double.parseDouble(v.getVelocidade());
			}
			infoPiloto.setVelocidadeMedia(velocidadeTotal/infoPiloto.getVoltas().size());
		}
		infoPiloto.setTempoTotal(total);
		return helper.longDateToString(total);
	}

	@Override
	public Resposta preenchePosicao(Resposta resposta) throws ParseException {
		// Com a lista ordenada, posso preencher o campo posicao de forma natural
		if (resposta != null) {
			int pos = 1;
			String tempoPrimeiro = null;
			ArrayList<DadosPiloto> list = (ArrayList<DadosPiloto>) resposta.getDadosCorrida();
			for (DadosPiloto el:list) {
				tempoPrimeiro = setaDiferencaParaPrimeiro(pos, tempoPrimeiro, el);
				el.setPosicaoChegada(pos++);
				setaMelhorVolta(resposta, el);
			}
		}
		return resposta;
	}

	private String setaDiferencaParaPrimeiro(int pos, String tempoPrimeiro, DadosPiloto el) throws ParseException {
		if (pos == 1) {
			//tempoTotal base para calculo
			el.setDiferencaParaOPrimeiro("N/A");
			tempoPrimeiro = el.getTempoTotal();
		} else {
			//calculo a diferenca
			el.setDiferencaParaOPrimeiro(helper.calculaDiferencaTempo(tempoPrimeiro, el.getTempoTotal()));
		}
		return tempoPrimeiro;
	}

	private void setaMelhorVolta(Resposta resposta, DadosPiloto el) throws ParseException {
		if (resposta.getMelhorVoltaCorrida() == null) {
			resposta.setMelhorVoltaCorrida(el.getMelhorTempo());
		} else {
			long tempo = helper.stringDateToLong(el.getMelhorTempo());
			if (tempo < helper.stringDateToLong(resposta.getMelhorVoltaCorrida())) {
				resposta.setMelhorVoltaCorrida(el.getMelhorTempo());
			}
		
		}
	}

	public void setHelper(DateHelper helper) {
		this.helper = helper;
	}
	
}
