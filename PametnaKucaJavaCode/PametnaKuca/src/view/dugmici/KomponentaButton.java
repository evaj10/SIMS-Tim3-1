package view.dugmici;

import javax.swing.JButton;

import model.komponente.Komponenta;

@SuppressWarnings("serial")
public class KomponentaButton extends JButton {
	private Komponenta komponenta;

	public KomponentaButton(Komponenta komponenta) {
		super();
		this.komponenta = komponenta;
	}

	public Komponenta getKomponenta() {
		return komponenta;
	}

	public void setKomponenta(Komponenta komponenta) {
		this.komponenta = komponenta;
	}
}
