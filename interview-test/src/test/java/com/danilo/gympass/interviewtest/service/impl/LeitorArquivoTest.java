package com.danilo.gympass.interviewtest.service.impl;

import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class) 
public class LeitorArquivoTest {
	
	LeitorArquivoImpl leitor = new LeitorArquivoImpl();

    @Before
    public void setUp() throws Exception {

         MockitoAnnotations.initMocks(this);
    }

	@Test(expected=Exception.class)
	public void testaPassandoPathNulo() throws Exception {
		leitor.leArquivo(null);
	}
	
	@Test(expected=Exception.class)
	public void testaArquivoInexistente() throws Exception {
		when(Paths.get("")).thenThrow(Exception.class);
		leitor.leArquivo("");
	}
}
