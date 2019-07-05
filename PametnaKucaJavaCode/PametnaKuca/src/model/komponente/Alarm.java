package model.komponente;

import model.komponente.funkcije.ImaPovecanje;
import model.komponente.funkcije.ImaSmanjenje;
import model.komponente.funkcije.ImaUkljuciIskljuci;
import model.komponente.funkcije.NemaPovecanje;
import model.komponente.funkcije.NemaSmanjenje;

/***********************************************************************
 * Module:  Alarm.java
 * Author:  Ksenija
 * Purpose: Defines the Class Alarm
 ***********************************************************************/


public class Alarm extends TipKomponente {

	public Alarm() {};
	
	public Alarm(String opisVrijednosti, String slika) {
		super(opisVrijednosti, slika);
		povecaj = new NemaPovecanje();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
		smanji = new NemaSmanjenje();
	}
	
	@Override
	public String toString() {
		return "Alarm";
	}
}