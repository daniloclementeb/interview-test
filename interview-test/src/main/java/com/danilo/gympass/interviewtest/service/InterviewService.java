package com.danilo.gympass.interviewtest.service;

import com.danilo.gympass.interviewtest.model.Resposta;

public interface InterviewService {
	/**
	 * Servico responsavel por consolidar a solucao proposta
	 * @param path
	 * @return
	 * @throws Exception
	 */
	Resposta executar(String path) throws Exception;
}
