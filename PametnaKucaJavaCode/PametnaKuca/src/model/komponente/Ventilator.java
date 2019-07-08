package model.komponente;

import konstante.Konstante;
import model.komponente.funkcije.ImaPromjenu;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module: Ventilator.java Author: Ksenija Purpose: Defines the Class Ventilator
 ***********************************************************************/

@SuppressWarnings("serial")
public class Ventilator extends TipKomponente {

	public Ventilator() {
		super(Konstante.COOLING, "Stepen:");
		promijeni = new ImaPromjenu();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
	};

	@Override
	public String toString() {
		return "Klima";
	}

}