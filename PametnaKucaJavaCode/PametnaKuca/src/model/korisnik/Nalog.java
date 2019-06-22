package model.korisnik;

/***********************************************************************
 * Module: Nalog.java Author: evaje Purpose: Defines the Class Nalog
 ***********************************************************************/

public class Nalog {
	private String korisnickoIme;
	private String sifra;
	private String fileTlocrt;

	public Korisnik korisnik;

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getFileTlocrt() {
		return fileTlocrt;
	}

	public void setFileTlocrt(String fileTlocrt) {
		this.fileTlocrt = fileTlocrt;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}