package model.stanja;
/***********************************************************************
 * Module:  Stanje.java
 * Author:  evaje
 * Purpose: Defines the Class Stanje
 ***********************************************************************/

import java.io.Serializable;

import model.Aplikacija;

@SuppressWarnings("serial")
public abstract class Stanje implements Serializable {
	public Aplikacija aplikacija;

	public boolean logIn() {
		// TODO: implement
		return false;
	}

	public void logOut() {
		// TODO: implement
	}

	public boolean logovanjeSpoljnog() {
		// TODO: implement
		return false;
	}

	public void odabirIzvjestaja() {
		// TODO: implement
	}

	public void pritisnutoDugmeIzvjestaji() {
		// TODO: implement
	}

	public void pritisnutoDugmePovratak() {
		// TODO: implement
	}

	public void entry() {
		// TODO: implement
	}

	public void pritisnutoDugmeZaOdustajanje() {
		// TODO: implement
	}

}