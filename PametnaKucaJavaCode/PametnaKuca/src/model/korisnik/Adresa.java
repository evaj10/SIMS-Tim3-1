package model.korisnik;

/***********************************************************************
 * Module: Adresa.java Author: evaje Purpose: Defines the Class Adresa
 ***********************************************************************/

public class Adresa {

	private int id;
	private String ulica;
	private int broj;

	public Mesto mesto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setMesto(Mesto newMesto) {
		if (this.mesto == null || !this.mesto.equals(newMesto)) {
			if (this.mesto != null) {
				Mesto oldMesto = this.mesto;
				this.mesto = null;
				oldMesto.removeAdrese(this);
			}
			if (newMesto != null) {
				this.mesto = newMesto;
				this.mesto.addAdrese(this);
			}
		}
	}

}