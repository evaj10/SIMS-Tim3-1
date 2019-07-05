package model.komponente;

import model.komponente.funkcije.ImaPovecanje;
import model.komponente.funkcije.ImaSmanjenje;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module:  Ventilator.java
 * Author:  Ksenija
 * Purpose: Defines the Class Ventilator
 ***********************************************************************/

public class Ventilator extends TipKomponente {

	public Ventilator() {};
	public Ventilator(String opisVrijednosti, String slika) {
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