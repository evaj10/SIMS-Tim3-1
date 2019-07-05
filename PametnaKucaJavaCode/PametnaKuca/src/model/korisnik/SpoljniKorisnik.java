package model.korisnik;

import java.io.Serializable;

/***********************************************************************
 * Module: SpoljniKorisnik.java Author: evaje Purpose: Defines the Class
 * SpoljniKorisnik
 ***********************************************************************/

@SuppressWarnings("serial")
public class SpoljniKorisnik implements Serializable{
	private int idKompanije;
	private String imeKompanije;

	public SpoljniKorisnik() {}

	public SpoljniKorisnik(int idKompanije, String imeKompanije) {
		this.idKompanije = idKompanije;
		this.imeKompanije = imeKompanije;
	}

	public int getIdKompanije() {
		return idKompanije;
	}

	public void setIdKompanije(int idKompanije) {
		this.idKompanije = idKompanije;
	}

	public String getImeKompanije() {
		return imeKompanije;
	}

	public void setImeKompanije(String imeKompanije) {
		this.imeKompanije = imeKompanije;
	}

}