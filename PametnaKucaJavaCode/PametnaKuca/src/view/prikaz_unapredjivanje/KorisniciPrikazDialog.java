package view.prikaz_unapredjivanje;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;

import controller.Kontroler.NaloziSelectionListener;

@SuppressWarnings("serial")
public class KorisniciPrikazDialog extends AbstractDialog {

	public KorisniciPrikazDialog(JFrame parent, String title, KorisniciTableModel korisniciModel) {
		super(parent, title);

		panDetail = new PanelDetailKorisnici();
		
		// zaglavlje tabele:
		columns = new String[9];
		columns[0] = "Korisnicko ime";
		columns[1] = "Lozinka";
		columns[2] = "Prezime";
		columns[3] = "Ime";
		columns[4] = "Pol";
		columns[5] = "Datum rodjenja";
		columns[6] = "Tip korisnika";
		
		tableModel=korisniciModel;
		initGUI();
		 
		table.getColumnModel().getColumn(0).setMinWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(3).setMinWidth(150);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(80);
		table.getColumnModel().getColumn(6).setMinWidth(70);
	}

	public void addListSelectionListener(NaloziSelectionListener a) {
		// povezivanje selection listenera sa tabelom:
		ListSelectionModel lsm = table.getSelectionModel();
		lsm.addListSelectionListener(a);
	}

}
