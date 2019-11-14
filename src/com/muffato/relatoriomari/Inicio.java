package com.muffato.relatoriomari;

import com.muffato.relatoriomari.agenda.RelatorioMariAgenda;

public class Inicio {

	public static void main(String[] args) {

		try {
			new RelatorioMariAgenda().inicia();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}