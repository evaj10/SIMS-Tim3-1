package model.komponente;

import konstante.Konstante;
import model.komponente.funkcije.ImaPovecanje;
import model.komponente.funkcije.ImaSmanjenje;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module:  Ventilator.java
 * Author:  Ksenija
 * Purpose: Defines the Class Ventilator
 ***********************************************************************/

public class Ventilator extends TipKomponente {

	public Ventilator() {
		super(Konstante.COOLING);
	};
	public Ventilator(String opisVrijednosti, String slika) {
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