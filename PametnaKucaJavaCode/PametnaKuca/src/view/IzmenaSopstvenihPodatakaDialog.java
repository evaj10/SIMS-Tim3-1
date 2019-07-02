package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class IzmenaSopstvenihPodatakaDialog extends JDialog {
	
	private JLabel lblIzmenaPodataka;
	
	private JLabel lblIme;
	private JTextField txfIme;
	
	private JLabel lblPrezime;
	private JTextField txfPrezime;
	
	private JLabel lblKorisnickoIme;
	private JTextField txfKorisnickoIme;
	
	private JLabel lblStaraLozinka;
	private JTextField txfLozinka;
	
	private JLabel lblPotvrdaLozinke;
	private JTextField txfPonovoLozinka;
	
	private JLabel lblPol;
	private ButtonGroup btngrpPol;
	private JRadioButton rdbtnZenski;
	private JRadioButton rdbtnMuski;
	private JRadioButton rdbtnNeodredjen;
	
	private JLabel lblDatumRodjenja;
	private JComboBox<Integer> cmbDan;
	private JComboBox<String> cmbMesec;
	private JComboBox<Integer> cmbGodina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IzmenaSopstvenihPodatakaDialog dialog = new IzmenaSopstvenihPodatakaDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public IzmenaSopstvenihPodatakaDialog() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setBounds(100, 100, 464, 402);
		setLocationRelativeTo(null);
		setResizable(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 73, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			lblIzmenaPodataka = new JLabel("Izmena podataka");
			lblIzmenaPodataka.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblIzmenaPodataka = new GridBagConstraints();
			gbc_lblIzmenaPodataka.gridwidth = 3;
			gbc_lblIzmenaPodataka.insets = new Insets(20, 30, 20, 5);
			gbc_lblIzmenaPodataka.gridx = 2;
			gbc_lblIzmenaPodataka.gridy = 0;
			getContentPane().add(lblIzmenaPodataka, gbc_lblIzmenaPodataka);
		}
		{
			lblIme = new JLabel("Ime:");
			lblIme.setVerticalAlignment(SwingConstants.TOP);
			lblIme.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblIme = new GridBagConstraints();
			gbc_lblIme.anchor = GridBagConstraints.WEST;
			gbc_lblIme.insets = new Insets(5, 25, 5, 5);
			gbc_lblIme.gridx = 1;
			gbc_lblIme.gridy = 2;
			getContentPane().add(lblIme, gbc_lblIme);
		}
		{
			txfIme = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.gridwidth = 3;
			gbc_textField.insets = new Insets(5, 5, 5, 25);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 3;
			gbc_textField.gridy = 2;
			getContentPane().add(txfIme, gbc_textField);
			txfIme.setColumns(10);
		}
		{
			lblPrezime = new JLabel("Prezime:");
			lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblPrezime = new GridBagConstraints();
			gbc_lblPrezime.anchor = GridBagConstraints.WEST;
			gbc_lblPrezime.insets = new Insets(5, 25, 5, 5);
			gbc_lblPrezime.gridx = 1;
			gbc_lblPrezime.gridy = 3;
			getContentPane().add(lblPrezime, gbc_lblPrezime);
		}
		{
			txfPrezime = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.gridwidth = 3;
			gbc_textField_1.insets = new Insets(5, 5, 5, 25);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 3;
			gbc_textField_1.gridy = 3;
			getContentPane().add(txfPrezime, gbc_textField_1);
			txfPrezime.setColumns(10);
		}
		{
			lblKorisnickoIme = new JLabel("Korisnicko ime:");
			lblKorisnickoIme.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblKorisnickoIme = new GridBagConstraints();
			gbc_lblKorisnickoIme.anchor = GridBagConstraints.WEST;
			gbc_lblKorisnickoIme.insets = new Insets(5, 25, 5, 5);
			gbc_lblKorisnickoIme.gridx = 1;
			gbc_lblKorisnickoIme.gridy = 4;
			getContentPane().add(lblKorisnickoIme, gbc_lblKorisnickoIme);
		}
		{
			txfKorisnickoIme = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.gridwidth = 3;
			gbc_textField_2.insets = new Insets(5, 5, 5, 25);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 3;
			gbc_textField_2.gridy = 4;
			getContentPane().add(txfKorisnickoIme, gbc_textField_2);
			txfKorisnickoIme.setColumns(10);
		}
		{
			lblStaraLozinka = new JLabel("Nova lozinka:");
			lblStaraLozinka.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblStaraLozinka = new GridBagConstraints();
			gbc_lblStaraLozinka.anchor = GridBagConstraints.WEST;
			gbc_lblStaraLozinka.insets = new Insets(5, 25, 5, 5);
			gbc_lblStaraLozinka.gridx = 1;
			gbc_lblStaraLozinka.gridy = 5;
			getContentPane().add(lblStaraLozinka, gbc_lblStaraLozinka);
		}
		{
			txfLozinka = new JTextField();
			GridBagConstraints gbc_textField_3 = new GridBagConstraints();
			gbc_textField_3.gridwidth = 3;
			gbc_textField_3.insets = new Insets(5, 5, 5, 25);
			gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_3.gridx = 3;
			gbc_textField_3.gridy = 5;
			getContentPane().add(txfLozinka, gbc_textField_3);
			txfLozinka.setColumns(10);
		}
		{
			lblPotvrdaLozinke = new JLabel("Potvrda lozinke:");
			lblPotvrdaLozinke.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblPotvrdaLozinke = new GridBagConstraints();
			gbc_lblPotvrdaLozinke.anchor = GridBagConstraints.WEST;
			gbc_lblPotvrdaLozinke.insets = new Insets(5, 25, 5, 5);
			gbc_lblPotvrdaLozinke.gridx = 1;
			gbc_lblPotvrdaLozinke.gridy = 6;
			getContentPane().add(lblPotvrdaLozinke, gbc_lblPotvrdaLozinke);
		}
		{
			txfPonovoLozinka = new JTextField();
			GridBagConstraints gbc_textField_4 = new GridBagConstraints();
			gbc_textField_4.gridwidth = 3;
			gbc_textField_4.insets = new Insets(5, 5, 5, 25);
			gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_4.gridx = 3;
			gbc_textField_4.gridy = 6;
			getContentPane().add(txfPonovoLozinka, gbc_textField_4);
			txfPonovoLozinka.setColumns(10);
		}
		{
			{
				lblPol = new JLabel("Pol:");
				lblPol.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_lblPol = new GridBagConstraints();
				gbc_lblPol.anchor = GridBagConstraints.WEST;
				gbc_lblPol.insets = new Insets(5, 25, 5, 5);
				gbc_lblPol.gridx = 1;
				gbc_lblPol.gridy = 7;
				getContentPane().add(lblPol, gbc_lblPol);
			}
			{
				rdbtnZenski = new JRadioButton("Zenski");
				rdbtnZenski.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_rdbtnZenski = new GridBagConstraints();
				gbc_rdbtnZenski.insets = new Insets(5, 5, 5, 5);
				gbc_rdbtnZenski.gridx = 3;
				gbc_rdbtnZenski.gridy = 7;
				getContentPane().add(rdbtnZenski, gbc_rdbtnZenski);
			}
			{
				rdbtnMuski = new JRadioButton("Muski");
				rdbtnMuski.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_rdbtnMuski = new GridBagConstraints();
				gbc_rdbtnMuski.insets = new Insets(5, 5, 5, 5);
				gbc_rdbtnMuski.gridx = 4;
				gbc_rdbtnMuski.gridy = 7;
				getContentPane().add(rdbtnMuski, gbc_rdbtnMuski);
			}
			{
				rdbtnNeodredjen = new JRadioButton("Neodredjen");
				rdbtnNeodredjen.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_rdbtnNeodredjeni = new GridBagConstraints();
				gbc_rdbtnNeodredjeni.insets = new Insets(5, 5, 5, 15);
				gbc_rdbtnNeodredjeni.gridx = 5;
				gbc_rdbtnNeodredjeni.gridy = 7;
				getContentPane().add(rdbtnNeodredjen, gbc_rdbtnNeodredjeni);
			}
			
				btngrpPol = new ButtonGroup();
				btngrpPol.add(rdbtnZenski);
				btngrpPol.add(rdbtnMuski);
				btngrpPol.add(rdbtnNeodredjen);
			{
				lblDatumRodjenja = new JLabel("Datum rodjenja:");
				lblDatumRodjenja.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_lblDatumRodjenja = new GridBagConstraints();
				gbc_lblDatumRodjenja.anchor = GridBagConstraints.WEST;
				gbc_lblDatumRodjenja.insets = new Insets(5, 25, 5, 5);
				gbc_lblDatumRodjenja.gridx = 1;
				gbc_lblDatumRodjenja.gridy = 8;
				getContentPane().add(lblDatumRodjenja, gbc_lblDatumRodjenja);
			}
			{
				cmbDan = new JComboBox<Integer>();
				cmbDan.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.insets = new Insets(5, 5, 5, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 3;
				gbc_comboBox.gridy = 8;
				for(int i = 1; i <= 31 ; i++)
				{
					cmbDan.addItem(i);
				}
				getContentPane().add(cmbDan, gbc_comboBox);
			}
			{
				cmbMesec = new JComboBox<String>();
				cmbMesec.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.insets = new Insets(5, 5, 5, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 4;
				gbc_comboBox.gridy = 8;
				cmbMesec.addItem("Jan");
				cmbMesec.addItem("Feb");
				cmbMesec.addItem("Mart");
				cmbMesec.addItem("April");
				cmbMesec.addItem("Maj");
				cmbMesec.addItem("Jun");
				cmbMesec.addItem("Jul");
				cmbMesec.addItem("Avg");
				cmbMesec.addItem("Sept");
				cmbMesec.addItem("Nov");
				cmbMesec.addItem("Dec");
				getContentPane().add(cmbMesec, gbc_comboBox);
			}
			{
				cmbGodina = new JComboBox<Integer>();
				cmbGodina.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.insets = new Insets(5, 5, 5, 25);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 5;
				gbc_comboBox.gridy = 8;
				for(int i = 2020;i > 1901; i--)
				{
					cmbGodina.addItem(i);
				}
				getContentPane().add(cmbGodina, gbc_comboBox);
			}
		}
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(30, 5, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 10;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		{
			JButton btnOk = new JButton("OK");
			GridBagConstraints gbc_btnOk = new GridBagConstraints();
			gbc_btnOk.insets = new Insets(30, 5, 0, 5);
			gbc_btnOk.gridx = 5;
			gbc_btnOk.gridy = 10;
			getContentPane().add(btnOk, gbc_btnOk);
		}
	}

}
