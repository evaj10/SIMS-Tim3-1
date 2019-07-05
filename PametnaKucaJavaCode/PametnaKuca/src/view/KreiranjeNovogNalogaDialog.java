package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import model.korisnik.Pol;
import model.korisnik.TipKorisnika;

@SuppressWarnings("serial")
public class KreiranjeNovogNalogaDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtKorisnickoIme;
	private JPasswordField txtLozinka;
	
	private JLabel lblRodjendan;
	private JComboBox<Integer> cmbDan;
	private JComboBox<String> cmbMesec;
	private JComboBox<Integer> cmbGodina;
	
	private JLabel lblPol;
	private ButtonGroup btngrpPol;
	private JRadioButton rdbtnZenski;
	private JRadioButton rdbtnMuski;
	private JRadioButton rdbtnNeodredjen;

	private JLabel lblTipKorisnika;
	private ButtonGroup btngrpTipKorisnika;
	private JRadioButton rdbtnRead;
	private JRadioButton rdbtnReadwrite;
	private JButton btnPrijaviSe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			KreiranjeNovogNalogaDialog dialog = new KreiranjeNovogNalogaDialog();
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
	public KreiranjeNovogNalogaDialog() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setBounds(100, 100, 683, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("ISAK - Kreiranje Novog Naloga");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{40, 10, 41, 0, 20, 0, 40 , 31, 36, 0, 44, 0, 0, 0, 62, 0, 40};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("   Kreiranje novog naloga");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(5, 0, 20, 5);
			gbc_lblNewLabel.gridwidth = 8;
			gbc_lblNewLabel.gridx = 6;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			txtIme = new JTextField();
			txtIme.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtIme.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(txtIme.getText().equals("Ime"))
					{
						txtIme.setText("");
					}
					
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtIme.getText().equals(""))
					{
						txtIme.setText("Ime");
					}
				}
			});
			txtIme.setText("Ime");
			GridBagConstraints gbc_txtIme = new GridBagConstraints();
			gbc_txtIme.gridwidth = 10;
			gbc_txtIme.insets = new Insets(0, 0, 5, 5);
			gbc_txtIme.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtIme.gridx = 1;
			gbc_txtIme.gridy = 2;
			contentPanel.add(txtIme, gbc_txtIme);
			txtIme.setColumns(10);
		}
		{
			txtPrezime = new JTextField();
			txtPrezime.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(txtPrezime.getText().equals("Prezime"))
					{
						txtPrezime.setText("");
					}
					
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtPrezime.getText().equals(""))
					{
						txtPrezime.setText("Prezime");
					}
				}
			});
			txtPrezime.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtPrezime.setText("Prezime");
			GridBagConstraints gbc_txtPrezime = new GridBagConstraints();
			gbc_txtPrezime.gridwidth = 4;
			gbc_txtPrezime.insets = new Insets(0, 0, 5, 5);
			gbc_txtPrezime.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPrezime.gridx = 11;
			gbc_txtPrezime.gridy = 2;
			contentPanel.add(txtPrezime, gbc_txtPrezime);
			txtPrezime.setColumns(10);
		}
		{
			txtKorisnickoIme = new JTextField();
			txtKorisnickoIme.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(txtKorisnickoIme.getText().equals("Korisnicko ime"))
					{
						txtKorisnickoIme.setText("");
					}
					
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtKorisnickoIme.getText().equals(""))
					{
						txtKorisnickoIme.setText("Korisnicko ime");
					}
				}
			});
				
			txtKorisnickoIme.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtKorisnickoIme.setText("Korisnicko ime");
			GridBagConstraints gbc_txtKorisnickoIme = new GridBagConstraints();
			gbc_txtKorisnickoIme.insets = new Insets(0, 0, 5, 5);
			gbc_txtKorisnickoIme.gridwidth = 14;
			gbc_txtKorisnickoIme.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtKorisnickoIme.gridx = 1;
			gbc_txtKorisnickoIme.gridy = 3;
			contentPanel.add(txtKorisnickoIme, gbc_txtKorisnickoIme);
			txtKorisnickoIme.setColumns(10);
		}
		{
			txtLozinka = new JPasswordField();
			txtLozinka.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					txtLozinka.setEchoChar('*');
					if(txtLozinka.getText().equals("Lozinka"))
					{
						txtLozinka.setText("");
					}
					
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtLozinka.getText().equals(""))
					{
						txtLozinka.setText("Lozinka");
						txtLozinka.setEchoChar((char)0);
					}
				}
			});
			
			txtLozinka.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtLozinka.setText("Lozinka");
			txtLozinka.setEchoChar((char)0);
			GridBagConstraints gbc_txtLozinka = new GridBagConstraints();
			gbc_txtLozinka.gridwidth = 14;
			gbc_txtLozinka.insets = new Insets(0, 0, 5, 5);
			gbc_txtLozinka.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtLozinka.gridx = 1;
			gbc_txtLozinka.gridy = 4;
			contentPanel.add(txtLozinka, gbc_txtLozinka);
			txtLozinka.setColumns(10);
		}
		{
			lblRodjendan = new JLabel("Rodjendan");
			lblRodjendan.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblRodjendan = new GridBagConstraints();
			gbc_lblRodjendan.gridwidth = 8;
			gbc_lblRodjendan.insets = new Insets(0, 0, 5, 5);
			gbc_lblRodjendan.gridx = 1;
			gbc_lblRodjendan.gridy = 5;
			contentPanel.add(lblRodjendan, gbc_lblRodjendan);
		}
		{
			lblPol = new JLabel("Pol");
			lblPol.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblPol = new GridBagConstraints();
			gbc_lblPol.insets = new Insets(0, 0, 5, 5);
			gbc_lblPol.gridx = 13;
			gbc_lblPol.gridy = 5;
			contentPanel.add(lblPol, gbc_lblPol);
		}
		{
			cmbDan = new JComboBox<Integer>();
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 2;
			gbc_comboBox.gridy = 6;
			for(int i = 1; i <= 31 ; i++)
			{
				cmbDan.addItem(i);
			}
			contentPanel.add(cmbDan, gbc_comboBox);
		}
		{
			cmbMesec = new JComboBox<String>();
			GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
			gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_1.gridx = 5;
			gbc_comboBox_1.gridy = 6;
			contentPanel.add(cmbMesec, gbc_comboBox_1);
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
		}
		{
			cmbGodina = new JComboBox<Integer>();
			GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
			gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_2.gridx = 8;
			gbc_comboBox_2.gridy = 6;
			
			for(int i = 2020;i > 1901; i--)
			{
				cmbGodina.addItem(i);
			}
			
			contentPanel.add(cmbGodina, gbc_comboBox_2);


		}
		{
			rdbtnZenski = new JRadioButton("Zenski");
			rdbtnZenski.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_rdbtnZenski = new GridBagConstraints();
			gbc_rdbtnZenski.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnZenski.gridx = 12;
			gbc_rdbtnZenski.gridy = 6;
			contentPanel.add(rdbtnZenski, gbc_rdbtnZenski);
		}
		{
			rdbtnMuski = new JRadioButton("Muski");
			rdbtnMuski.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_rdbtnMuski = new GridBagConstraints();
			gbc_rdbtnMuski.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnMuski.gridx = 13;
			gbc_rdbtnMuski.gridy = 6;
			contentPanel.add(rdbtnMuski, gbc_rdbtnMuski);
		}
		{
			rdbtnNeodredjen = new JRadioButton("Neodredjen");
			rdbtnNeodredjen.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_rdbtnNeodredjen = new GridBagConstraints();
			gbc_rdbtnNeodredjen.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnNeodredjen.gridx = 14;
			gbc_rdbtnNeodredjen.gridy = 6;
			contentPanel.add(rdbtnNeodredjen, gbc_rdbtnNeodredjen);
		}
		{
			btngrpPol = new ButtonGroup();
			btngrpPol.add(rdbtnZenski);
			btngrpPol.add(rdbtnMuski);
			btngrpPol.add(rdbtnNeodredjen);
		}
		{
			lblTipKorisnika = new JLabel("Tip Korisnika");
			lblTipKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblTipKorisnika = new GridBagConstraints();
			gbc_lblTipKorisnika.insets = new Insets(0, 0, 5, 5);
			gbc_lblTipKorisnika.gridx = 11;
			gbc_lblTipKorisnika.gridy = 7;
			contentPanel.add(lblTipKorisnika, gbc_lblTipKorisnika);
		}
		{
			rdbtnRead = new JRadioButton("Read");
			rdbtnRead.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_rdbtnRead = new GridBagConstraints();
			gbc_rdbtnRead.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnRead.gridx = 9;
			gbc_rdbtnRead.gridy = 8;
			contentPanel.add(rdbtnRead, gbc_rdbtnRead);
		}
		{
			rdbtnReadwrite = new JRadioButton("ReadWrite");
			rdbtnReadwrite.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_rdbtnReadwrite = new GridBagConstraints();
			gbc_rdbtnReadwrite.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnReadwrite.gridx = 12;
			gbc_rdbtnReadwrite.gridy = 8;
			contentPanel.add(rdbtnReadwrite, gbc_rdbtnReadwrite);
		}
		{
			btngrpTipKorisnika = new ButtonGroup();
			btngrpTipKorisnika.add(rdbtnRead);
			btngrpTipKorisnika.add(rdbtnReadwrite);
		}
		{
			btnPrijaviSe = new JButton("PRIJAVI SE");
			btnPrijaviSe.setBackground(new Color(50, 205, 50));
			GridBagConstraints gbc_btnPrijaviSe = new GridBagConstraints();
			gbc_btnPrijaviSe.gridheight = 3;
			gbc_btnPrijaviSe.insets = new Insets(0, 0, 0, 5);
			gbc_btnPrijaviSe.gridx = 11;
			gbc_btnPrijaviSe.gridy = 9;
			contentPanel.add(btnPrijaviSe, gbc_btnPrijaviSe);
		}
	}
	
	public void addPrijaviSeListener(ActionListener a) {
		btnPrijaviSe.addActionListener(a);
	}
	
	public String getIme()
	{
		return txtIme.getText();
	}
	
	public String getPrezime()
	{
		return txtPrezime.getText();
	}
	
	public String getKorisnickoIme()
	{
		return txtKorisnickoIme.getText();
	}
	
	
	public String getLozinka()
	{
		return txtLozinka.getText();
	}

	public String getDatumRodjenja() {
		int mesec = cmbMesec.getSelectedIndex()+1;
		String datumRodjenja = cmbDan.getSelectedItem() + "-" + mesec + "-" + cmbGodina.getSelectedItem();
		return datumRodjenja;
	}
	
	public Pol getPol()
	{
		Pol pol;
		if(rdbtnZenski.isSelected())
		{
			pol = Pol.zenski;
		}
		else if(rdbtnMuski.isSelected())
		{
			pol = Pol.muski;
		}
		else {
			pol = Pol.ostalo;
		}
		
		return pol;
	}
	
	public TipKorisnika getTipKorisnika()
	{
		TipKorisnika tipKorisnika;
		if(rdbtnRead.isSelected())
		{
			tipKorisnika = TipKorisnika.read;
		}
		else
		{
			tipKorisnika = TipKorisnika.readWrite;
		}
		
		return tipKorisnika;
	}

}
