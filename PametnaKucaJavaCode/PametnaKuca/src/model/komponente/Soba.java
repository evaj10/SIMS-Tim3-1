package model.komponente;

/***********************************************************************
 * Module: Soba.java Author: evaje Purpose: Defines the Class Soba
 ***********************************************************************/

public class Soba {

	private int id;
	private double temperatura;
	private double vlaznost;
	public java.util.List<Komponenta> komponente;

	public void iscrtajSobu() {
		// TODO: implement
	}

	public java.util.List<Komponenta> getKomponente() {
		if (komponente == null)
			komponente = new java.util.ArrayList<Komponenta>();
		return komponente;
	}

	public java.util.Iterator getIteratorKomponente() {
		if (komponente == null)
			komponente = new java.util.ArrayList<Komponenta>();
		return komponente.iterator();
	}

	public void setKomponente(java.util.List<Komponenta> newKomponente) {
		removeAllKomponente();
		for (java.util.Iterator iter = newKomponente.iterator(); iter.hasNext();)
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
			for (java.util.Iterator iter = getIteratorKomponente(); iter.hasNext();) {
				oldKomponenta = (Komponenta) iter.next();
				iter.remove();
				oldKomponenta.setSoba((Soba) null);
			}
		}
	}

}