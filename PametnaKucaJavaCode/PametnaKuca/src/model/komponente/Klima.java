package model.komponente;

import konstante.Konstante;
import model.komponente.funkcije.ImaPromjenu;
import model.komponente.funkcije.ImaUkljuciIskljuci;

/***********************************************************************
 * Module: Klima.java Author: Ksenija Purpose: Defines the Class Klima s
 **********************************/

public class Klima extends TipKomponente {
	public Klima() {
		super(Konstante.COOLING, "Temperatura:");
		promijeni = new ImaPromjenu();
		ukljuciIskljuci = new ImaUkljuciIskljuci();
	};

	@Override
	public String toString() {
		return "Klima";
	}

}