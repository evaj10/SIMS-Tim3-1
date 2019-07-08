package model.komponente.funkcije;

import java.io.Serializable;

import model.komponente.Komponenta;

@SuppressWarnings("serial")
public class ImaUkljuciIskljuci implements Ukljuci_Iskljuci, Serializable {
	public void uradi(Komponenta k, boolean OnOff) {
		k.setUkljucena(OnOff);
	}

}
