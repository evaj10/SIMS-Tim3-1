package model.komponente;

import konstante.Konstante;
import model.komponente.funkcije.ImaPovecanje;
import model.komponente.funkcije.ImaSmanjenje;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module:  Radijator.java
 * Author:  Ksenija
 * Purpose: Defines the Class Radijator
 ***********************************************************************/

public class Radijator extends TipKomponente {

	public Radijator() {
		super(Konstante.HEATING);
	};
	public Radijator(String opisVrijednosti, String slika) {
		super(opisVrijednosti, Konstante.HEATING);
		povecaj = new ImaPovecanje();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
		smanji = new ImaSmanjenje();
	}
	
	@Override
	public String toString() {
		return "Radijator";
	}
}