package model.komponente.funkcije;

import model.komponente.Komponenta;

/***********************************************************************
 * Module:  ImaSmanjenje.java
 * Author:  Ksenija
 * Purpose: Defines the Class ImaSmanjenje
 ***********************************************************************/


public class ImaSmanjenje implements Smanji {
	public void uradi(Komponenta k, int naKoliko) {
		k.setVrednost(naKoliko);
	}
}