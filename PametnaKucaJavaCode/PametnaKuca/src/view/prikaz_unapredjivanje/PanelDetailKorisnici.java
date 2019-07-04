package view.prikaz_unapredjivanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class PanelDetailKorisnici extends JPanel {

	
	private JLabel lblKorisnickoIme;
	private JTextField txtKorisnickoIme;
	
	private JLabel lblLozinka;
	private JTextField txtLozinka;
	
	
	private JLabel lblPrezime;
	private JTextField txtPrezime;
	
	private JLabel lblIme;
	private JTextField txtIme;
	
	private JLabel lblDatumRodjenja;
	private JTextField txtDatumRodjenja;
	
	private JLabel lblPol;
	private JRadioButton rdbtnMuski;
	private JRadioButton rdbtnZenski;
	private JRadioButton rdbtnOstalo;
	
	private JLabel lblTipKorisnika;
	private JRadioButton rdbtnRead;
	private JRadioButton rdbtnReadWrite;
	
	public PanelDetailKorisnici(){
		setLayout(new BorderLayout());
		
		Dimension lblDimension=new Dimension(150,20);
		
		Box boxCentar=new Box(BoxLayout.Y_AXIS);
		
		
		JPanel panKorisnickoIme=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblKorisnickoIme = new JLabel("Korisnicko ime");
		lblKorisnickoIme.setPreferredSize(lblDimension);
		lblKorisnickoIme.setPreferredSize(lblDimension);
		txtKorisnickoIme=new JTextField(10);
		txtKorisnickoIme.setEditable(false);
		txtKorisnickoIme.setBackground(Color.white);
		panKorisnickoIme.add(lblKorisnickoIme);
		panKorisnickoIme.add(txtKorisnickoIme);
		boxCentar.add(panKorisnickoIme);
		
		JPanel panLozinka = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblLozinka=new JLabel("Lozinka");
		lblLozinka.setPreferredSize(lblDimension);
		txtLozinka=new JTextField(20);
		txtLozinka.setEditable(false);
		txtLozinka.setBackground(Color.white);
		panLozinka.add(lblLozinka);
		panLozinka.add(txtLozinka);
		boxCentar.add(panLozinka);
		
		JPanel panPrezime=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblPrezime=new JLabel("Prezime");
		lblPrezime.setPreferredSize(lblDimension);
		txtPrezime=new JTextField(20);
		txtPrezime.setEditable(false);
		txtPrezime.setBackground(Color.white);
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		boxCentar.add(panPrezime);
		
		JPanel panIme=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblIme =new JLabel("Ime");
		lblIme.setPreferredSize(lblDimension);
		txtIme=new JTextField(20);
		txtIme.setEditable(false);
		txtIme.setBackground(Color.white);
		panIme.add(lblIme);
		panIme.add(txtIme);
		boxCentar.add(panIme);
		
		
		JPanel panDatumRodjenja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblDatumRodjenja = new JLabel("Datum rodjenja");
		lblDatumRodjenja.setPreferredSize(lblDimension);
		lblDatumRodjenja.setPreferredSize(lblDimension);
		txtDatumRodjenja=new JTextField(11);
		txtDatumRodjenja.setEditable(false);
		txtDatumRodjenja.setBackground(Color.white);
		panDatumRodjenja.add(lblDatumRodjenja);
		panDatumRodjenja.add(txtDatumRodjenja);
		boxCentar.add(panDatumRodjenja);
		
		JPanel panPol=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblPol = new JLabel("Pol");
		lblPol.setPreferredSize(lblDimension);
		rdbtnZenski=new JRadioButton("Zenski");
		rdbtnZenski.setEnabled(false);
		rdbtnMuski=new JRadioButton("Muski");
		rdbtnMuski.setEnabled(false);
		rdbtnOstalo=new JRadioButton("Ostalo");
		rdbtnOstalo.setEnabled(false);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnZenski);
		bg.add(rdbtnMuski);
		bg.add(rdbtnOstalo);
		panPol.add(lblPol);
		panPol.add(rdbtnZenski);
		panPol.add(rdbtnMuski);
		panPol.add(rdbtnOstalo);
		boxCentar.add(panPol);
		
		
		JPanel panTipKorisnika=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblTipKorisnika = new JLabel("Tip korisnika");
		lblTipKorisnika.setPreferredSize(lblDimension);
		rdbtnRead=new JRadioButton("Read");
		rdbtnRead.setEnabled(false);
		rdbtnReadWrite=new JRadioButton("ReadWrite");
		rdbtnReadWrite.setEnabled(false);
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(rdbtnRead);
		bg1.add(rdbtnReadWrite);
		panTipKorisnika.add(lblTipKorisnika);
		panTipKorisnika.add(rdbtnRead);
		panTipKorisnika.add(rdbtnReadWrite);
		boxCentar.add(panTipKorisnika);
		
		
		add(boxCentar,BorderLayout.CENTER);
	}



	public JTextField getTxtKorisnickoIme() {
		return txtKorisnickoIme;
	}

	public void setTxtKorisnickoIme(JTextField txtKorisnickoIme) {
		this.txtKorisnickoIme = txtKorisnickoIme;
	}



	public JTextField getTxtLozinka() {
		return txtLozinka;
	}

	public void setTxtLozinka(JTextField txtLozinka) {
		this.txtLozinka = txtLozinka;
	}



	public JTextField getTxtPrezime() {
		return txtPrezime;
	}

	public void setTxtPrezime(JTextField txtPrezime) {
		this.txtPrezime = txtPrezime;
	}



	public JTextField getTxtIme() {
		return txtIme;
	}

	public void setTxtIme(JTextField txtIme) {
		this.txtIme = txtIme;
	}



	public JTextField getTxtDatumRodjenja() {
		return txtDatumRodjenja;
	}

	public void setTxtDatumRodjenja(JTextField txtDatumRodjenja) {
		this.txtDatumRodjenja = txtDatumRodjenja;
	}



	public JRadioButton getRdbtnMuski() {
		return rdbtnMuski;
	}

	public void setRdbtnMuski(JRadioButton rdbtnMuski) {
		this.rdbtnMuski = rdbtnMuski;
	}

	public JRadioButton getRdbtnZenski() {
		return rdbtnZenski;
	}

	public void setRdbtnZenski(JRadioButton rdbtnZenski) {
		this.rdbtnZenski = rdbtnZenski;
	}

	public JRadioButton getRdbtnOstalo() {
		return rdbtnOstalo;
	}

	public void setRdbtnOstalo(JRadioButton rdbtnOstalo) {
		this.rdbtnOstalo = rdbtnOstalo;
	}

	
	
	public JRadioButton getRdbtnRead() {
		return rdbtnRead;
	}

	public void setRdbtnRead(JRadioButton rdbtnRead) {
		this.rdbtnRead = rdbtnRead;
	}

	public JRadioButton getRdbtnReadWrite() {
		return rdbtnReadWrite;
	}

	public void setRdbtnReadWrite(JRadioButton rdbtnReadWrite) {
		this.rdbtnReadWrite = rdbtnReadWrite;
	}

}
