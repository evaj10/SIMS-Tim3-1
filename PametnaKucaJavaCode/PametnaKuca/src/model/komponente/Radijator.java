package model.komponente;

import konstante.Konstante;
import model.komponente.funkcije.ImaPromjenu;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module: Radijator.java Author: Ksenija Purpose: Defines the Class Radijator
 ***********************************************************************/

public class Radijator extends TipKomponente {

	public Radijator() {
		super(Konstante.HEATING, "Temperatura:");
		promijeni = new ImaPromjenu();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
	};

	@Override
	public String toString() {
		return "Radijator";
	}
}