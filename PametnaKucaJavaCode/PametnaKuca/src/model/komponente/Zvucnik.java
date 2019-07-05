package model.komponente;

import model.komponente.funkcije.ImaPovecanje;
import model.komponente.funkcije.ImaSmanjenje;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module: Zvucnik.java Author: Ksenija Purpose: Defines the Class Zvucnik
 ***********************************************************************/

public class Zvucnik extends TipKomponente {

	public Zvucnik() {};
	public Zvucnik(String opisVrijednosti, String slika) {
		super(opisVrijednosti, slika);
		povecaj = new ImaPovecanje();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
		smanji = new ImaSmanjenje();
	}
	
	@Override
	public String toString() {
		return "Klima";
	}
}