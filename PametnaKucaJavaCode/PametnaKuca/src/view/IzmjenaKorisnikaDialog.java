package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import konstante.Konstante;
import model.Aplikacija;
import model.korisnik.Nalog;
import model.korisnik.Pol;
import model.korisnik.TipKorisnika;

public class IzmjenaKorisnikaDialog extends JDialog {

	private static final long serialVersionUID = 1884063759494311563L;

	private JPanel panel;
	private JLabel lblChoose;
	private JComboBox cmbUsers;

	private JLabel lblTip;
	private JLabel lblTipUser;
	private JLabel lblIme;
	private JTextField txfIme;
	private JLabel lblPrezime;
	private JTextField txfPrezime;
	private JLabel lblDatum;
	private JComboBox cmbDay;
	private JComboBox cmbMonth;
	private JComboBox cmbYear;
	private JLabel lblPol;
	private JRadioButton rbM;
	private JRadioButton rbZ;
	private JRadioButton rbN;
	private ButtonGroup bgPol;
	private JButton btnBack;
	private JButton btnConfirm;

	public IzmjenaKorisnikaDialog() {
		setResizable(false);
		setTitle("ISAK - Izmjena podataka korisnika");
		setIconImage(new ImageIcon(Konstante.APP_LOGO).getImage());

		// postavljamo dimenziju dijaloga u zavisnosti od velicine ekrana na cetvrtinu
		setWindowSize();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// postavljamo raspored komponenti
		createGUI();
		createLayout();

	}

	private void setWindowSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(width / 3, height / 2);
	}

	private void createGUI() {
		panel = new JPanel(new GridBagLayout());

		lblChoose = new JLabel("Izaberite korisnika:", JLabel.LEFT);
		cmbUsers = new JComboBox();

		// combo box za biranje korisnika

		lblTip = new JLabel("Tip korisnika:");
		lblTipUser = new JLabel("");
		lblIme = new JLabel("Ime:");
		txfIme = new JTextField();
		lblPrezime = new JLabel("Prezime:");
		txfPrezime = new JTextField();
		lblDatum = new JLabel("Datum rodjenja:");
		cmbDay = new JComboBox();
		for (int i = 1; i <= 31; i++)
			cmbDay.addItem(Integer.toString(i));
		Object[] items = { "Jan", "Feb", "Mar", "Apr", "Maj", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec" };
		cmbMonth = new JComboBox();
		for (int i = 0; i < items.length; i++)
			cmbMonth.addItem(items[i]);
		cmbYear = new JComboBox();
		for (int i = 1901; i <= 2020; i++)
			cmbYear.addItem(Integer.toString(i));
		lblPol = new JLabel("Pol:");
		rbM = new JRadioButton("Muski");
		rbZ = new JRadioButton("Zenski");
		rbN = new JRadioButton("Ostalo");
		bgPol = new ButtonGroup();
		bgPol.add(rbZ);
		bgPol.add(rbM);
		bgPol.add(rbN);
		btnBack = new JButton("POVRATAK");
		btnConfirm = new JButton("POTVRDI");

		cmbUsers.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				setSelected(getSelected());
			}
		});
	}

	private void createLayout() {
		add(panel);

		panel.add(lblChoose, new GridBagConstraints(0, 0, 4, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 50, 5, 50), 0, 0));

		panel.add(cmbUsers, new GridBagConstraints(0, 1, 4, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 50, 5, 50), 0, 0));

		panel.add(lblTip, new GridBagConstraints(0, 3, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 50, 5, 5), 0, 0));

		panel.add(lblTipUser, new GridBagConstraints(1, 3, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 50), 0, 0));

		panel.add(lblIme, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 50, 5, 5), 0, 0));

		panel.add(txfIme, new GridBagConstraints(1, 4, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 50), 0, 0));

		panel.add(lblPrezime, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 50, 5, 5), 0, 0));

		panel.add(txfPrezime, new GridBagConstraints(1, 5, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 50), 0, 0));

		panel.add(lblDatum, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 50, 5, 5), 0, 0));

		panel.add(cmbDay, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

		panel.add(cmbMonth, new GridBagConstraints(2, 6, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

		panel.add(cmbYear, new GridBagConstraints(3, 6, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 50), 0, 0));

		panel.add(lblPol, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 50, 5, 5), 0, 0));

		panel.add(rbZ, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

		panel.add(rbM, new GridBagConstraints(2, 7, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

		panel.add(rbN, new GridBagConstraints(3, 7, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 50), 0, 0));

		panel.add(btnBack, new GridBagConstraints(0, 10, 2, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.BOTH,
				new Insets(50, 50, 15, 50), 0, 0));

		panel.add(btnConfirm, new GridBagConstraints(2, 10, 2, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(50, 50, 15, 50), 0, 0));
	}

	public void addToCmb(List<Nalog> nalozi) {
		for (Nalog n : nalozi) {
			cmbUsers.addItem(n);
		}
	}

	public Nalog getSelected() {
		return (Nalog) cmbUsers.getSelectedItem();
	}

	public void setSelected(Nalog n) {
		if (n.getKorisnik().getTipKorisnika() == TipKorisnika.read)
			lblTipUser.setText("READ");
		else
			lblTipUser.setText("READ/WRITE");
		txfIme.setText(n.getKorisnik().getIme());
		txfPrezime.setText(n.getKorisnik().getPrezime());
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String datum = df.format(n.getKorisnik().getDatumRodjenja());
		String[] tokens = datum.split("-");
		cmbDay.setSelectedItem(tokens[0]);
		cmbMonth.setSelectedIndex((Integer.parseInt(tokens[1]) - 1));
		cmbYear.setSelectedItem(tokens[2]);
		Pol p = n.getKorisnik().getPol();
		if (p == Pol.zenski)
			rbZ.setSelected(true);
		else if (p == Pol.muski)
			rbM.setSelected(true);
		else
			rbN.setSelected(true);
	}

	public String getTxfIme() {
		return txfIme.getText();
	}

	public String getTxfPrezime() {
		return txfPrezime.getText();
	}

	public String getDatum() {
		int mjesec = cmbMonth.getSelectedIndex() + 1;
		String datumRodjenja = cmbDay.getSelectedItem() + "-" + mjesec + "-" + cmbYear.getSelectedItem();
		return datumRodjenja;
	}

	public Pol getPol() {
		Pol pol;
		if (rbZ.isSelected())
			pol = Pol.zenski;
		else if (rbM.isSelected())
			pol = Pol.muski;
		else
			pol = Pol.ostalo;

		return pol;
	}

	public void addPovratakListener(ActionListener a) {
		btnBack.addActionListener(a);
	}

	public void addPotvrdiListener(ActionListener a) {
		btnConfirm.addActionListener(a);
	}

	// testiranje
	/*
	 * public static void main(String[] args) { IzmjenaKorisnikaDialog ikd = new
	 * IzmjenaKorisnikaDialog(); ikd.setVisible(true); }
	 */

}
