package view.prikaz_unapredjivanje;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UnapredjivanjeDialog extends KorisniciPrikazDialog {

	private JButton btnUnapredi;
	
	public UnapredjivanjeDialog(JFrame parent, String title, KorisniciTableModel korisniciModel) {
		super(parent, title, korisniciModel);
		
		btnUnapredi = new JButton("UNAPREDI");
		btnUnapredi.setPreferredSize(new Dimension(20, 50));
		btnUnapredi.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(btnUnapredi, BorderLayout.SOUTH);
	}

	public void addUnaprediKorisnikaListener(ActionListener a) {
		btnUnapredi.addActionListener(a);
	}
	
	
}
