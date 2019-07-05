package model.komponente;

import java.io.Serializable;

import model.korisnik.Adresa;

/***********************************************************************
 * Module:  Tlocrt.java
 * Author:  evaje
 * Purpose: Defines the Class Tlocrt
 ***********************************************************************/

@SuppressWarnings("serial")
public class Tlocrt implements Serializable {
	private String slika;
	private String naziv;
	private Adresa adresa;

	public java.util.List<Soba> sobe;
	public java.util.Collection<Komponenta> komponente;

	public Tlocrt(String naziv, String slika, Adresa adresa) {
		this.naziv = naziv;
		this.slika = slika;
		this.adresa = adresa;
	}
	
	public void iscrtajTlocrt() {
		// TODO: implement
	}

	public java.util.List<Soba> getSobe() {
		if (sobe == null)
			sobe = new java.util.ArrayList<Soba>();
		return sobe;
	}

	public java.util.Iterator getIteratorSobe() {
		if (sobe == null)
			sobe = new java.util.ArrayList<Soba>();
		return sobe.iterator();
	}

	public void setSobe(java.util.List<Soba> newSobe) {
		removeAllSobe();
		for (java.util.Iterator iter = newSobe.iterator(); iter.hasNext();)
			addSobe((Soba) iter.next());
	}

	public void addSobe(Soba newSoba) {
		if (newSoba == null)
			return;
		if (this.sobe == null)
			this.sobe = new java.util.ArrayList<Soba>();
		if (!this.sobe.contains(newSoba))
			this.sobe.add(newSoba);
	}

	public void removeSobe(Soba oldSoba) {
		if (oldSoba == null)
			return;
		if (this.sobe != null)
			if (this.sobe.contains(oldSoba))
				this.sobe.remove(oldSoba);
	}

	public void removeAllSobe() {
		if (sobe != null)
			sobe.clear();
	}

	public java.util.Collection<Komponenta> getKomponente() {
		if (komponente == null)
			komponente = new java.util.ArrayList<Komponenta>();
		return komponente;
	}

	public java.util.Iterator getIteratorKomponente() {
		if (komponente == null)
			komponente = new java.util.ArrayList<Komponenta>();
		return komponente.iterator();
	}

	public void setKomponente(java.util.Collection<Komponenta> newKomponente) {
		removeAllKomponente();
		for (java.util.Iterator iter = newKomponente.iterator(); iter.hasNext();)
			addKomponente((Komponenta) iter.next());
	}

	public void addKomponente(Komponenta newKomponenta) {
		if (newKomponenta == null)
			return;
		if (this.komponente == null)
			this.komponente = new java.util.ArrayList<Komponenta>();
		if (!this.komponente.contains(newKomponenta))
			this.komponente.add(newKomponenta);
	}

	public void removeKomponente(Komponenta oldKomponenta) {
		if (oldKomponenta == null)
			return;
		if (this.komponente != null)
			if (this.komponente.contains(oldKomponenta))
				this.komponente.remove(oldKomponenta);
	}

	public void removeAllKomponente() {
		if (komponente != null)
			komponente.clear();
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
}