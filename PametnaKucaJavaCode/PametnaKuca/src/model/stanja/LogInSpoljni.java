package model.stanja;

import model.Aplikacija;

/***********************************************************************
 * Module: LogInSpoljni.java Author: Korisnik Purpose: Defines the Class
 * LogInSpoljni
 ***********************************************************************/

@SuppressWarnings("serial")
public class LogInSpoljni extends Stanje {

	public LogInSpoljni(Aplikacija app) {
		super(app);
	}
	
	public boolean logovanjeSpoljnog(String id) {
		if (aplikacija.loginSpoljni(id)) {
			return true;
		}
		return false;
	}

	public void entry() {
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