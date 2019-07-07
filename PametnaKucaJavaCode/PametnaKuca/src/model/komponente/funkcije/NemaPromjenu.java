package model.komponente.funkcije;

import java.io.Serializable;

import model.komponente.Komponenta;

/***********************************************************************
 * Module: NemaPovecanje.java Author: Ksenija Purpose: Defines the Class
 * NemaPovecanje
 ***********************************************************************/

public class NemaPromjenu implements Promijeni, Serializable {
	public void uradi(Komponenta k, int naKoliko) {
		k.setVrednost(k.getVrednost());
	}
}