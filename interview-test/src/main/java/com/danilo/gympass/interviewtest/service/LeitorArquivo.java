package com.danilo.gympass.interviewtest.service;

import java.io.IOException;
import java.util.List;

import com.danilo.gympass.interviewtest.model.LinhaTemplate;

public interface LeitorArquivo {
	/**
	 * metodo responsavel por ler o arquivo de log
	 * @param path nome do arquivo
	 * @return lista conforme o template indicado
	 * @throws IOException
	 * @throws Exception
	 */
	List<LinhaTemplate> leArquivo(String path) throws IOException, Exception;
}
