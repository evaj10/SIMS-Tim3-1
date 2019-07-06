package model.komponente;
/***********************************************************************
 * Module:  TipKomponente.java
 * Author:  evaje
 * Purpose: Defines the Class TipKomponente
 ***********************************************************************/

import java.io.Serializable;

import model.komponente.funkcije.Povecaj;
import model.komponente.funkcije.Smanji;
import model.komponente.funkcije.Ukljuci_Iskljuci;

public abstract class TipKomponente implements Serializable {
	public java.util.List<Komponenta> komponente;
	public Povecaj povecaj;
	public Smanji smanji;
	public Ukljuci_Iskljuci ukljuciIskljuci;
	public String opisVrijednosti;
	public String slika;

	public TipKomponente() {};
	
	public TipKomponente(String slika) {
		super();
		this.slika = slika;
	}
	
	@Override
	public String toString() {
		return "TipKomponente []";
	}

	public Povecaj getPovecaj() {
		return povecaj;
	}
	
	public Smanji getSmanji() {
		return smanji;
	}
	
	
	public Ukljuci_Iskljuci getUkljuciIskljuci() {
		return ukljuciIskljuci;
	}
	
	
	public String getOpisVrijednosti() {
		return opisVrijednosti;
	}

	public void setOpisVrijednosti(String opisVrijednosti) {
		this.opisVrijednosti = opisVrijednosti;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public TipKomponente(String opisVrijednosti, String slika) {
		super();
		this.opisVrijednosti = opisVrijednosti;
		this.slika = slika;
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
			newKomponenta.setTipKomponente(this);
		}
	}

	public void removeKomponente(Komponenta oldKomponenta) {
		if (oldKomponenta == null)
			return;
		if (this.komponente != null)
			if (this.komponente.contains(oldKomponenta)) {
				this.komponente.remove(oldKomponenta);
				oldKomponenta.setTipKomponente((TipKomponente) null);
			}
	}

	public void removeAllKomponente() {
		if (komponente != null) {
			Komponenta oldKomponenta;
			for (java.util.Iterator iter = getIteratorKomponente(); iter.hasNext();) {
				oldKomponenta = (Komponenta) iter.next();
				iter.remove();
				oldKomponenta.setTipKomponente((TipKomponente) null);
			}
		}
	}

}