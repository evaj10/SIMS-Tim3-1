package controller;
/***********************************************************************
 * Module:  Aplikacija.java
 * Author:  student
 * Purpose: Defines the Class Aplikacija
 ***********************************************************************/

import model.komponente.Komponenta;
import model.komponente.Tlocrt;
import model.korisnik.Nalog;
import model.korisnik.TipIzvestaja;
import model.korisnik.TipKorisnika;
import model.stanja.Stanje;

public class Aplikacija {
	public Tlocrt tlocrt;

	public java.util.List<Nalog> nalozi;
	public Stanje stanje;

	public void kreirajIzvestaj(TipIzvestaja tipIzvestaja) {
		// TODO: implement
	}

	public boolean logIn() {
		// TODO: implement
		return false;
	}

	public void logOut() {
		// TODO: implement
	}

	public void upgradeKorisnik(TipKorisnika r) {
		// TODO: implement
	}

	public void ukljuciIskljuci(Komponenta k, int novaVrednost) {
		// TODO: implement
	}

	public void promeniVrijednost(Komponenta k, int novaVrednost) {
		// TODO: implement
	}

	public void izmenaSopstvenihPodataka() {
		// TODO: implement
	}

	public void izmenaPodataka(TipKorisnika r) {
		// TODO: implement
	}

	public void ucitavanjeTlocrta() {
		// TODO: implement
	}

	public boolean validnostLozinke(String lozinka) {
		// TODO: implement
		return false;
	}

	public void osveziPrikaz(Komponenta k) {
		// TODO: implement
	}

	public void promeniStanje(Stanje s) {
		// TODO: implement
	}

	public boolean logovanjeSpoljnig() {
		// TODO: implement
		return false;
	}

	public void odabirIzvjestaja() {
		// TODO: implement
	}

	public void pritisnutoDugmeIzvjestaji() {
		// TODO: implement
	}

	public void pritisnutoDugmePovratak() {
		// TODO: implement
	}

	public void prikaziFormuZaLogovanje() {
		// TODO: implement
	}

	public void prikaziPorukuGreske() {
		// TODO: implement
	}

	public void prikaziTlocrt() {
		// TODO: implement
	}

	public void prikaziFormuZaLogovanjeSpoljnog() {
		// TODO: implement
	}

	public void prikaziFormuZaIzborIzvjestaja() {
		// TODO: implement
	}

	public void posaljiIzvjestaj() {
		// TODO: implement
	}

	public void pritisnutoDugmeZaOdustajanje() {
		// TODO: implement
	}

	public java.util.List<Nalog> getNalozi() {
		if (nalozi == null)
			nalozi = new java.util.ArrayList<Nalog>();
		return nalozi;
	}

	public java.util.Iterator getIteratorNalozi() {
		if (nalozi == null)
			nalozi = new java.util.ArrayList<Nalog>();
		return nalozi.iterator();
	}

	public void setNalozi(java.util.List<Nalog> newNalozi) {
		removeAllNalozi();
		for (java.util.Iterator iter = newNalozi.iterator(); iter.hasNext();)
			addNalozi((Nalog) iter.next());
	}

	public void addNalozi(Nalog newNalog) {
		if (newNalog == null)
			return;
		if (this.nalozi == null)
			this.nalozi = new java.util.ArrayList<Nalog>();
		if (!this.nalozi.contains(newNalog))
			this.nalozi.add(newNalog);
	}

	public void removeNalozi(Nalog oldNalog) {
		if (oldNalog == null)
			return;
		if (this.nalozi != null)
			if (this.nalozi.contains(oldNalog))
				this.nalozi.remove(oldNalog);
	}

	public void removeAllNalozi() {
		if (nalozi != null)
			nalozi.clear();
	}

	public Tlocrt getTlocrt() {
		return tlocrt;
	}

	public void setTlocrt(Tlocrt tlocrt) {
		this.tlocrt = tlocrt;
	}

	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}
}