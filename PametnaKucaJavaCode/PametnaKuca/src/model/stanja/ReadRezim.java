package model.stanja;

import model.Aplikacija;

/***********************************************************************
 * Module: ReadRezim.java Author: Korisnik Purpose: Defines the Class ReadRezim
 ***********************************************************************/

@SuppressWarnings("serial")
public class ReadRezim extends Stanje {

	public ReadRezim(Aplikacija app) {
		super(app);
	}
	
	public boolean logOut() {
		return true;
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
}