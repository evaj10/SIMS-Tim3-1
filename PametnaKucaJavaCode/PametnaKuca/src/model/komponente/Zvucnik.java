package model.komponente;

import konstante.Konstante;
import model.komponente.funkcije.ImaPromjenu;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module: Zvucnik.java Author: Ksenija Purpose: Defines the Class Zvucnik
 ***********************************************************************/

@SuppressWarnings("serial")
public class Zvucnik extends TipKomponente {

	public Zvucnik() {
		super(Konstante.ENTERTAINMENT, "Jacina zvuka:");
		promijeni = new ImaPromjenu();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
	};

	@Override
	public String toString() {
		return "Zvucnik";
	}
}