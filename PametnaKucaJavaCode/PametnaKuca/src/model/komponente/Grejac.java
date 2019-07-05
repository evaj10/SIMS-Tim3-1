package model.komponente;

import model.komponente.funkcije.ImaPovecanje;
import model.komponente.funkcije.ImaSmanjenje;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module:  Grejac.java
 * Author:  Ksenija
 * Purpose: Defines the Class Grejac
 ***********************************************************************/


public class Grejac extends TipKomponente {

	public Grejac() {};
	public Grejac(String opisVrijednosti, String slika) {
		super(opisVrijednosti, slika);
		povecaj = new ImaPovecanje();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
		smanji = new ImaSmanjenje();
	}
	
	@Override
	public String toString() {
		return "Grejac";
	}
}