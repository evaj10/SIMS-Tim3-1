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
	protected Aplikacija aplikacija;

	public Stanje(Aplikacija app) {
		this.aplikacija = app;
	}
	
	public boolean logIn(String korisnickoIme, String lozinka) {
		return false;
	}

	public boolean logOut() {
		return false;
	}

	public boolean logovanjeSpoljnog(String id) {
		return false;
	}

	public void odabirIzvjestaja() {
	}

	public void pritisnutoDugmeIzvjestaji() {
	}

	public void pritisnutoDugmePovratak() {
	}

	public void entry() {
	}

	public void pritisnutoDugmeZaOdustajanje() {
	}

	public Aplikacija getAplikacija() {
		return aplikacija;
	}

	public void setAplikacija(Aplikacija aplikacija) {
		this.aplikacija = aplikacija;
	}
}