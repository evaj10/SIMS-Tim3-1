package model.korisnik;

/***********************************************************************
 * Module: SpoljniKorisnik.java Author: evaje Purpose: Defines the Class
 * SpoljniKorisnik
 ***********************************************************************/

public class SpoljniKorisnik {
	private int idKompanije;
	private String imeKompanije;

	public Adresa adresa;

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

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

}