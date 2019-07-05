package model.komponente.funkcije;

import model.komponente.Komponenta;

/***********************************************************************
 * Module:  NemaPovecanje.java
 * Author:  Ksenija
 * Purpose: Defines the Class NemaPovecanje
 ***********************************************************************/


public class NemaPovecanje implements Povecaj {
	public void uradi(Komponenta k, int naKoliko) {
		k.setVrednost(k.getVrednost());
	}
}