package model.stanja;

import model.Aplikacija;

/***********************************************************************
 * Module: ReadWriteRezim.java Author: Korisnik Purpose: Defines the Class
 * ReadWriteRezim
 ***********************************************************************/

@SuppressWarnings("serial")
public class ReadWriteRezim extends Stanje {
	
	public ReadWriteRezim(Aplikacija app) {
		super(app);
	}
	
	public boolean logOut() {
		aplikacija.promeniStanje(new LogInKorisnik(aplikacija));
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