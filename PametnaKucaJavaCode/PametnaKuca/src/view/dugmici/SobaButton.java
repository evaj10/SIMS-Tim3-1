package view.dugmici;

import javax.swing.JButton;

import model.komponente.Soba;

@SuppressWarnings("serial")
public class SobaButton extends JButton {
	private Soba soba;

	public SobaButton(Soba soba) {
		super();
		this.soba = soba;
		this.setText(soba.getIme());
	}

	public Soba getSoba() {
		return soba;
	}

	public void setSoba(Soba soba) {
		this.soba = soba;
	}

}
