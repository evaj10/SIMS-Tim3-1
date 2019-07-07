package model.komponente;

import konstante.Konstante;
import model.komponente.funkcije.ImaPromjenu;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module: Bojler.java Author: Ksenija Purpose: Defines the Class Bojler
 ***********************************************************************/

public class Bojler extends TipKomponente {
	public Bojler() {
		super(Konstante.HEATING, "Teperatura:");
		promijeni = new ImaPromjenu();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
	};

	@Override
	public String toString() {
		return "Bojler";
	}
}