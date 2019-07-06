package model.komponente;

import konstante.Konstante;
import model.komponente.funkcije.ImaPovecanje;
import model.komponente.funkcije.ImaSmanjenje;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module:  Bojler.java
 * Author:  Ksenija
 * Purpose: Defines the Class Bojler
 ***********************************************************************/


public class Bojler extends TipKomponente {
	public Bojler() {
		super(Konstante.HEATING);
	};

	public Bojler(String opisVrijednosti, String slika) {
		super(opisVrijednosti, Konstante.HEATING);
		povecaj = new ImaPovecanje();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
		smanji = new ImaSmanjenje();
	}
	
	@Override
	public String toString() {
		return "Bojler";
	}
}