package model.stanja;

import model.Aplikacija;

/***********************************************************************
 * Module: LogInKorisnik.java Author: Korisnik Purpose: Defines the Class
 * LogInKorisnik
 ***********************************************************************/

@SuppressWarnings("serial")
public class LogInKorisnik extends Stanje {
	
	public LogInKorisnik(Aplikacija app) {
		super(app);
	}
	
	public boolean logIn(String korisnickoIme, String lozinka) {
		if (aplikacija.logIn(korisnickoIme, lozinka)) {
			return true;
		}
		return false;
	}

	public boolean logOut() {
		return false;
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
}