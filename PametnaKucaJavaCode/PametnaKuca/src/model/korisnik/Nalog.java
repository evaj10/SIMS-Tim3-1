package model.korisnik;

import java.io.Serializable;

/***********************************************************************
 * Module: Nalog.java Author: evaje Purpose: Defines the Class Nalog
 ***********************************************************************/

@SuppressWarnings("serial")
public class Nalog implements Serializable {

	private String korisnickoIme;
	private String sifra;
	private String fileTlocrt;

	private Korisnik korisnik;

	public Nalog() {
	}

	public Nalog(String korIme, String sifra, String fileTlocrt, Korisnik k) {
		this.korisnickoIme = korIme;
		this.sifra = sifra;
		this.fileTlocrt = fileTlocrt;
		this.korisnik = k;
	}

	@Override
	public String toString() {
		return korisnickoIme;
	}

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