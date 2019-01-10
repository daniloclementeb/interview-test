package com.danilo.gympass.interviewtest.service.impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.danilo.gympass.interviewtest.model.LinhaTemplate;
import com.danilo.gympass.interviewtest.service.LeitorArquivo;

@Component
public class LeitorArquivoImpl implements LeitorArquivo{

	@Override
	public List<LinhaTemplate> leArquivo(String path) throws Exception {
		//abrir arquivo
		ArrayList<LinhaTemplate> list = new ArrayList<LinhaTemplate>();
		
		//le o arquivo.log baseado no diretorio do usuario
		Stream<String> linhas = Files.lines(Paths.get(System.getProperty("user.dir")+path));
		
		//executa o parse da linha do arquivo para o template desejado
		Stream<LinhaTemplate> st = linhas.map(arg0 -> {
			return LinhaTemplate.parse(arg0);			
		});

		//gera o array de retorno
		Iterator<LinhaTemplate> loop = st.iterator();
		while (loop.hasNext()) {
			list.add(loop.next());
		}
		
		return list;
	}
	
	

}
