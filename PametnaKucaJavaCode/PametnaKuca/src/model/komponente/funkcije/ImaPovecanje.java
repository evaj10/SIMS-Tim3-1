package model.komponente.funkcije;

import model.komponente.Komponenta;

/***********************************************************************
 * Module:  ImaPovecanje.java
 * Author:  Ksenija
 * Purpose: Defines the Class ImaPovecanje
 ***********************************************************************/


public class ImaPovecanje implements Povecaj {
	public void uradi(Komponenta k, int naKoliko) {
		k.setVrednost(naKoliko);
	}
}