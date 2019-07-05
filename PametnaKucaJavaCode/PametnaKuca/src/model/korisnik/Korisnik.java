package model.korisnik;
/***********************************************************************
 * Module:  Korisnik.java
 * Author:  evaje
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Korisnik implements Serializable {
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private Pol pol;
	private TipKorisnika tipKorisnika;

	public Korisnik() {}

	public Korisnik(String ime, String prezime, Date datumRodjenja,
			Pol pol, TipKorisnika tk) {
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.pol = pol;
		this.tipKorisnika = tk;
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

	

}