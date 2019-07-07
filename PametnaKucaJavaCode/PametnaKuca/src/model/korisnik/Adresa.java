package model.korisnik;

import java.io.Serializable;

/***********************************************************************
 * Module: Adresa.java Author: evaje Purpose: Defines the Class Adresa
 ***********************************************************************/

@SuppressWarnings("serial")
public class Adresa implements Serializable {

	private String ulica;
	private int broj;

	public Mesto mesto;

	public Adresa() {
	}

	public Adresa(String ulica, int broj, Mesto m) {
		this.ulica = ulica;
		this.broj = broj;
		this.mesto = m;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public Mesto getMesto() {
		return mesto;
	}
}