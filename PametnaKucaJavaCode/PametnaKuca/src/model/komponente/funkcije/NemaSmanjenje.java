package model.komponente.funkcije;

import model.komponente.Komponenta;

/***********************************************************************
 * Module:  NemaSmanjenje.java
 * Author:  Ksenija
 * Purpose: Defines the Class NemaSmanjenje
 ***********************************************************************/


public class NemaSmanjenje implements Smanji {
	public void uradi(Komponenta k, int naKoliko) {
		k.setVrednost(k.getVrednost());
	}
}