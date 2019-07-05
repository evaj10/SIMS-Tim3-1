package model.komponente.funkcije;

import model.komponente.Komponenta;

public class ImaUkljuciIskljuci implements Ukljuci_Iskljuci {
	public void uradi(Komponenta k, boolean OnOff) {
		k.setUkljucena(OnOff);
	}

}
