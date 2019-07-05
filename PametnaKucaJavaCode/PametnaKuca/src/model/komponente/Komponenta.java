package model.komponente;

/***********************************************************************
 * Module: Komponenta.java Author: evaje Purpose: Defines the Class Komponenta
 ***********************************************************************/

public class Komponenta {
	private int id;
	private String naziv;
	private int vrednost;
	private boolean ukljucena;
	public Soba soba;
	public TipKomponente tipKomponente;

	public Komponenta(int id, String naziv, Soba soba, TipKomponente tk) {
		this.id = id;
		this.naziv = naziv;
		this.ukljucena = false;
		this.vrednost = 0;
		this.soba = soba;
		this.tipKomponente = tk;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getVrednost() {
		return vrednost;
	}

	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}
	
	public boolean getUkljucena() {
		return ukljucena;
	}

	public void setUkljucena(boolean u) {
		this.ukljucena = u;
	}

	public void iscrtajKomponentu() {
		// TODO: implement
	}

	public Soba getSoba() {
		return soba;
	}

	public void setSoba(Soba newSoba) {
		if (this.soba == null || !this.soba.equals(newSoba)) {
			if (this.soba != null) {
				Soba oldSoba = this.soba;
				this.soba = null;
				oldSoba.removeKomponente(this);
			}
			if (newSoba != null) {
				this.soba = newSoba;
				this.soba.addKomponente(this);
			}
		}
	}

	public TipKomponente getTipKomponente() {
		return tipKomponente;
	}

	public void setTipKomponente(TipKomponente newTipKomponente) {
		if (this.tipKomponente == null || !this.tipKomponente.equals(newTipKomponente)) {
			if (this.tipKomponente != null) {
				TipKomponente oldTipKomponente = this.tipKomponente;
				this.tipKomponente = null;
				oldTipKomponente.removeKomponente(this);
			}
			if (newTipKomponente != null) {
				this.tipKomponente = newTipKomponente;
				this.tipKomponente.addKomponente(this);
			}
		}
	}

}