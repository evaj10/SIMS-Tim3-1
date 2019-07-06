package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.komponente.Komponenta;

public class ButtonComponent extends JButton {
	public Komponenta komponenta;

	public Komponenta getKomponenta() {
		return komponenta;
	}

	public void setKomponenta(Komponenta komponenta) {
		this.komponenta = komponenta;
	}

	public ButtonComponent(String text, Komponenta komponenta) {
		super(text);
		this.komponenta = komponenta;
		this.setIcon(new ImageIcon(komponenta.getTipKomponente().getSlika()));
	}

}
