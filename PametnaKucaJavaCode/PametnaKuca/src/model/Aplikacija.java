package model;
/***********************************************************************
 * Module:  Aplikacija.java
 * Author:  student
 * Purpose: Defines the Class Aplikacija
 ***********************************************************************/

import java.io.Serializable;

import model.komponente.Tlocrt;
import model.korisnik.Nalog;
import model.korisnik.SpoljniKorisnik;
import model.korisnik.TipKorisnika;
import model.stanja.LogInKorisnik;
import model.stanja.Stanje;

@SuppressWarnings("serial")
public class Aplikacija implements Serializable {
	private Nalog trenutnoUlogovani;
	private Tlocrt tlocrt;

	private java.util.List<Nalog> nalozi;
	private java.util.List<SpoljniKorisnik> spoljniKorisnici;
	private Stanje stanje;
	
	public Aplikacija() {
		this.stanje = new LogInKorisnik(this);
	}
	
	public Nalog getNalog(String korisnickoIme) {
		for (Nalog n : nalozi) {
			if (n.getKorisnickoIme().equals(korisnickoIme)) {
				return n;
			}
		}
		return null;
	}
	
	public boolean nalogPostoji(String korisnickoIme) {
		if (getNalog(korisnickoIme) == null) {
			return false;
		}
		return true;
	}
	
	public void unaprediKorisnika(Nalog n) {
		n.getKorisnik().setTipKorisnika(TipKorisnika.readWrite);
	}

	public boolean logIn(String korisnickoIme, String lozinka) {
		for (Nalog n : nalozi) {
			if (n.getKorisnickoIme().equals(korisnickoIme) && n.getSifra().equals(lozinka)) {
				trenutnoUlogovani = n;
				return true;
			}
		}
		return false;
	}

	public void logOut() {
		trenutnoUlogovani = null;
	}
	
	public boolean loginSpoljni(String id) {
		int unos;
		try {
			unos = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			return false;
		}
		for (SpoljniKorisnik sk : spoljniKorisnici) {
			if (sk.getIdKompanije() == unos) {
				return true;
			}
		}
		return false;
	}

	public void promeniStanje(Stanje s) {
		this.stanje = s;
	}

	public java.util.List<Nalog> getNalozi() {
		if (nalozi == null)
			nalozi = new java.util.ArrayList<Nalog>();
		return nalozi;
	}
	
	public java.util.List<Nalog> getNaloziBezSvog() {
		if (nalozi == null) {
			nalozi = new java.util.ArrayList<Nalog>();
			return nalozi;
		}
		java.util.ArrayList<Nalog> naloziBezSvog = new java.util.ArrayList<Nalog>();
		for (Nalog n : nalozi) {
			if (!n.getKorisnickoIme().equals(trenutnoUlogovani.getKorisnickoIme())) {
				naloziBezSvog.add(n);
			}
		}
		return naloziBezSvog;
	}

	public java.util.List<Nalog> getReadNalozi() {
		if (nalozi == null) {
			nalozi = new java.util.ArrayList<Nalog>();
			return nalozi;
		}
		java.util.ArrayList<Nalog> readNalozi = new java.util.ArrayList<Nalog>();
		for (Nalog n : nalozi) {
			if (n.getKorisnik().getTipKorisnika() == TipKorisnika.read) {
				readNalozi.add(n);
			}
		}
		return readNalozi;
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

	public void addSpoljniKorisnik(SpoljniKorisnik newSpoljniKorisnik) {
		if (newSpoljniKorisnik == null)
			return;
		if (this.spoljniKorisnici == null)
			this.spoljniKorisnici = new java.util.ArrayList<SpoljniKorisnik>();
		if (!this.spoljniKorisnici.contains(newSpoljniKorisnik))
			this.spoljniKorisnici.add(newSpoljniKorisnik);
	}
	
	public Nalog getTrenutnoUlogovani() {
		return trenutnoUlogovani;
	}

	public void setTrenutnoUlogovani(Nalog nalog) {
		this.trenutnoUlogovani = nalog;
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

	public java.util.List<SpoljniKorisnik> getSpoljniKorisnici() {
		return spoljniKorisnici;
	}

	public void setSpoljniKorisnici(java.util.List<SpoljniKorisnik> spoljniKorisnici) {
		this.spoljniKorisnici = spoljniKorisnici;
	}
	
	public String getTlocrtAdresa() {
		return tlocrt.dobaviAdresu();
	}
}