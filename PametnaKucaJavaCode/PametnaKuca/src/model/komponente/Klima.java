package model.komponente;

import konstante.Konstante;
import model.komponente.funkcije.ImaPovecanje;
import model.komponente.funkcije.ImaSmanjenje;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module:  Klima.java
 * Author:  Ksenija
 * Purpose: Defines the Class Klima
 *************************************s**********************************/


public class Klima extends TipKomponente {
	public Klima() {
		super(Konstante.COOLING);
	};

	public Klima(String opisVrijednosti, String slika) {
		super(opisVrijednosti, Konstante.COOLING);
		povecaj = new ImaPovecanje();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
		smanji = new ImaSmanjenje();
	}

	@Override
	public String toString() {
		return "Klima";
	}
	
	

}