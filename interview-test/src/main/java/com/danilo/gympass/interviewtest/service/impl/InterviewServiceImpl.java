package com.danilo.gympass.interviewtest.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danilo.gympass.interviewtest.model.DadosPiloto;
import com.danilo.gympass.interviewtest.model.InfoPiloto;
import com.danilo.gympass.interviewtest.model.LinhaTemplate;
import com.danilo.gympass.interviewtest.model.Resposta;
import com.danilo.gympass.interviewtest.service.InterviewService;
import com.danilo.gympass.interviewtest.service.LeitorArquivo;
import com.danilo.gympass.interviewtest.service.RunnerMap;

@Service
public class InterviewServiceImpl implements InterviewService{
	
	@Autowired
	private LeitorArquivo leitor;
	
	@Autowired 
	private RunnerMap runnerMap;
	
	@Override
	public Resposta executar(String path) throws Exception {
		//le arquivo
		List<LinhaTemplate> arquivo = leitor.leArquivo(path);
		
		//gera um hashmap com codigo corredor por volta
		HashMap<String, InfoPiloto> mapa = runnerMap.geraMapaCorredor(arquivo);
		
		//prepara resposta final
		List<DadosPiloto> r = runnerMap.geraRespostaParcial(mapa);
		
		Resposta resposta = new Resposta();
		resposta.setDadosCorrida(r);
		runnerMap.preenchePosicao(resposta);
		return resposta;
	}

}
