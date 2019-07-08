package model.stanja;

import model.Aplikacija;

/***********************************************************************
 * Module: SpoljniRezim.java Author: Korisnik Purpose: Defines the Class
 * SpoljniRezim
 ***********************************************************************/

@SuppressWarnings("serial")
public class SpoljniRezim extends Stanje {

	public SpoljniRezim(Aplikacija app) {
		super(app);
	}
	
	public void entry() {
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

	public void pritisnutoDugmeZaOdustajanje() {
	}
	
	public boolean logIn(String korisnickoIme, String lozinka) {
		return false;
	}

	public boolean logOut() {
		return false;
	}
}