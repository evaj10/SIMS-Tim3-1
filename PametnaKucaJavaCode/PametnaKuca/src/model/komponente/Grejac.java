package model.komponente;

import konstante.Konstante;
import model.komponente.funkcije.ImaPromjenu;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module: Grejac.java Author: Ksenija Purpose: Defines the Class Grejac
 ***********************************************************************/

public class Grejac extends TipKomponente {

	public Grejac() {
		super(Konstante.HEATING, "Temperatura:");
		promijeni = new ImaPromjenu();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
	};

	@Override
	public String toString() {
		return "Grejac";
	}
}