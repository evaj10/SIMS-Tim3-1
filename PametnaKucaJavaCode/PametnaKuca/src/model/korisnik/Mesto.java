package model.korisnik;

/***********************************************************************
 * Module: Mesto.java Author: evaje Purpose: Defines the Class Mesto
 ***********************************************************************/

public class Mesto {
	private int postanskiBr;
	private String grad;

	public java.util.List<Adresa> adrese;

	
	
	public int getPostanskiBr() {
		return postanskiBr;
	}

	public void setPostanskiBr(int postanskiBr) {
		this.postanskiBr = postanskiBr;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public java.util.List<Adresa> getAdrese() {
		if (adrese == null)
			adrese = new java.util.ArrayList<Adresa>();
		return adrese;
	}

	public java.util.Iterator getIteratorAdrese() {
		if (adrese == null)
			adrese = new java.util.ArrayList<Adresa>();
		return adrese.iterator();
	}

	public void setAdrese(java.util.List<Adresa> newAdrese) {
		removeAllAdrese();
		for (java.util.Iterator iter = newAdrese.iterator(); iter.hasNext();)
			addAdrese((Adresa) iter.next());
	}

	public void addAdrese(Adresa newAdresa) {
		if (newAdresa == null)
			return;
		if (this.adrese == null)
			this.adrese = new java.util.ArrayList<Adresa>();
		if (!this.adrese.contains(newAdresa)) {
			this.adrese.add(newAdresa);
			newAdresa.setMesto(this);
		}
	}

	public void removeAdrese(Adresa oldAdresa) {
		if (oldAdresa == null)
			return;
		if (this.adrese != null)
			if (this.adrese.contains(oldAdresa)) {
				this.adrese.remove(oldAdresa);
				oldAdresa.setMesto((Mesto) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllAdrese() {
		if (adrese != null) {
			Adresa oldAdresa;
			for (java.util.Iterator iter = getIteratorAdrese(); iter.hasNext();) {
				oldAdresa = (Adresa) iter.next();
				iter.remove();
				oldAdresa.setMesto((Mesto) null);
			}
		}
	}

}