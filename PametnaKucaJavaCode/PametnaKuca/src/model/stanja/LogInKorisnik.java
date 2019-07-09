package model.stanja;

import model.Aplikacija;
import model.korisnik.TipKorisnika;

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
			if (aplikacija.getNalog(korisnickoIme)
					.getKorisnik().getTipKorisnika() == TipKorisnika.read) {
				aplikacija.promeniStanje(new ReadRezim(aplikacija));
			}
			else {
				aplikacija.promeniStanje(new ReadWriteRezim(aplikacija));
			}
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
		aplikacija.promeniStanje(new LogInSpoljni(aplikacija));
	}

	public void pritisnutoDugmePovratak() {
	}

	public void pritisnutoDugmeZaOdustajanje() {
	}
}