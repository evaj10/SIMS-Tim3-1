package model.korisnik;

import java.io.Serializable;

/***********************************************************************
 * Module: Mesto.java Author: evaje Purpose: Defines the Class Mesto
 ***********************************************************************/

@SuppressWarnings("serial")
public class Mesto implements Serializable {
	private int postanskiBr;
	private String grad;

	public Mesto() {}
	
	public Mesto(int pBr, String grad) {
		this.postanskiBr = pBr;
		this.grad = grad;
	}
	
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
}