package model.korisnik;
/***********************************************************************
 * Module:  Korisnik.java
 * Author:  evaje
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/

import java.util.Date;

public class Korisnik {
	private int id;
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private Pol pol;
	private TipKorisnika tipKorisnika;

	public Adresa adresa;
	public Nalog nalog;

	public Korisnik(int id, String ime, String prezime, Date datumRodjenja,
			Pol pol, TipKorisnika tk, Adresa adr) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.pol = pol;
		this.tipKorisnika = tk;
		this.adresa = adr;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}

	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Nalog getNalog() {
		return nalog;
	}

	public void setNalog(Nalog nalog) {
		this.nalog = nalog;
	}

}