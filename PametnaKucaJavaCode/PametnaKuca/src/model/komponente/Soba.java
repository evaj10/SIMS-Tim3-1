package model.komponente;

import java.io.Serializable;

/***********************************************************************
 * Module: Soba.java Author: evaje Purpose: Defines the Class Soba
 ***********************************************************************/

@SuppressWarnings("serial")
public class Soba implements Serializable {

	private String ime;
	private double temperatura;
	private double vlaznost;
	public java.util.List<Komponenta> komponente;

	public Soba() {}
	
	public Soba(String ime) {
		this.ime = ime;
		this.temperatura = 0;
		this.vlaznost = 0;
	}
	
	public void iscrtajSobu() {
		// TODO: implement
	}

	public java.util.List<Komponenta> getKomponente() {
		if (komponente == null)
			komponente = new java.util.ArrayList<Komponenta>();
		return komponente;
	}

	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorKomponente() {
		if (komponente == null)
			komponente = new java.util.ArrayList<Komponenta>();
		return komponente.iterator();
	}

	public void setKomponente(java.util.List<Komponenta> newKomponente) {
		removeAllKomponente();
		for (@SuppressWarnings("rawtypes")
		java.util.Iterator iter = newKomponente.iterator(); iter.hasNext();)
			addKomponente((Komponenta) iter.next());
	}

	public void addKomponente(Komponenta newKomponenta) {
		if (newKomponenta == null)
			return;
		if (this.komponente == null)
			this.komponente = new java.util.ArrayList<Komponenta>();
		if (!this.komponente.contains(newKomponenta)) {
			this.komponente.add(newKomponenta);
			newKomponenta.setSoba(this);
		}
	}

	public void removeKomponente(Komponenta oldKomponenta) {
		if (oldKomponenta == null)
			return;
		if (this.komponente != null)
			if (this.komponente.contains(oldKomponenta)) {
				this.komponente.remove(oldKomponenta);
				oldKomponenta.setSoba((Soba) null);
			}
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getVlaznost() {
		return vlaznost;
	}

	public void setVlaznost(double vlaznost) {
		this.vlaznost = vlaznost;
	}

	public void removeAllKomponente() {
		if (komponente != null) {
			Komponenta oldKomponenta;
			for (@SuppressWarnings("rawtypes")
			java.util.Iterator iter = getIteratorKomponente(); iter.hasNext();) {
				oldKomponenta = (Komponenta) iter.next();
				iter.remove();
				oldKomponenta.setSoba((Soba) null);
			}
		}
	}

}