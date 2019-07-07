package model.komponente.funkcije;

import java.io.Serializable;

import model.komponente.Komponenta;

/***********************************************************************
 * Module: ImaPovecanje.java Author: Ksenija Purpose: Defines the Class
 * ImaPovecanje
 ***********************************************************************/

public class ImaPromjenu implements Promijeni, Serializable {
	public void uradi(Komponenta k, int naKoliko) {
		if (naKoliko > 100)
			k.setVrednost(100);
		else if (naKoliko < 0)
			k.setVrednost(0);
		else
			k.setVrednost(naKoliko);
	}
}