package com.danilo.gympass.interviewtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danilo.gympass.interviewtest.model.Resposta;
import com.danilo.gympass.interviewtest.service.InterviewService;

@RestController
public class InterviewController {

	@Autowired
	private InterviewService service;
	
	
	//endpoint responsavel por executar o servico do teste
	@RequestMapping(path="/execute", produces=MediaType.APPLICATION_JSON_VALUE)
	public Resposta executaEntrevista() {
		try {
			return service.executar("/arquivo.log");
		} catch (Exception e) {
			Resposta r = new Resposta();
			r.setMensagem("Erro no processamento");
			return r;
		}
	}
	
	//endpoint auxiliar para localizar diretorio onde deve ficar o arquivo de log
	@RequestMapping(path="/logDir")
	public String informaPathDoLog() {
		return System.getProperty("user.dir");
	}
}
