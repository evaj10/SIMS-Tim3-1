package model.komponente;

import konstante.Konstante;
import model.komponente.funkcije.ImaUkljuciIskljuci;
import model.komponente.funkcije.NemaPromjenu;

/***********************************************************************
 * Module: Alarm.java Author: Ksenija Purpose: Defines the Class Alarm
 ***********************************************************************/

@SuppressWarnings("serial")
public class Alarm extends TipKomponente {

	public Alarm() {
		super(Konstante.ALARM, "");
		promijeni = new NemaPromjenu();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
	};

	@Override
	public String toString() {
		return "Alarm";
	}
}