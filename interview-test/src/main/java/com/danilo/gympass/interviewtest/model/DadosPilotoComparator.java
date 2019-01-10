package com.danilo.gympass.interviewtest.model;

import java.util.Comparator;

public class DadosPilotoComparator implements Comparator<DadosPiloto>{
	@Override
	public int compare(DadosPiloto o1, DadosPiloto o2) {
		if (o1.getQtdVolta() > o2.getQtdVolta()) {
			return -1;
		} else {
			if (o1.getQtdVolta() < o2.getQtdVolta()) {
				return 1;
			} else {
				if (o1.getTempo() > o2.getTempo())
					return 1;
				else
					return -1;
			}
		}
	}
	

}
