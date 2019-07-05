package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Aplikacija;
import model.korisnik.Nalog;
import model.korisnik.Pol;
import model.korisnik.TipKorisnika;
import view.IzmenaSopstvenihPodatakaDialog;
import view.IzvjestajDialog;
import view.LoginDialog;
import view.LoginSpoljniDialog;
import view.MainFrame;
import view.prikaz_unapredjivanje.AbstractDialog;
import view.prikaz_unapredjivanje.KorisniciPrikazDialog;
import view.prikaz_unapredjivanje.KorisniciTableModel;
import view.prikaz_unapredjivanje.PanelDetailKorisnici;
import view.prikaz_unapredjivanje.UnapredjivanjeDialog;

public class Kontroler {

	private Object theView;
	private Aplikacija theApp;

	public Kontroler(LoginDialog theView, Aplikacija theApp) {
		this.theView = theView;
		this.theApp = theApp;
		((LoginDialog) this.theView).addLoginListener(new LoginListener());
		((LoginDialog) this.theView).addIzvestajListener(new IzvestajListener());
	}

	private void loginToMainFrame() {
		((LoginDialog) theView).dispose();
		theView = MainFrame.getInstance();
		if (!MainFrame.getMade()) {
			((MainFrame) theView).addVodaIzvestajListener(new VodaIzvestajListener());
			((MainFrame) theView).addGasIzvestajListener(new GasIzvestajListener());
			((MainFrame) theView).addStrujaIzvestajListener(new StrujaIzvestajListener());

			((MainFrame) theView).addKreiranjeKorisnikaListener(new KreiranjeKorisnikaListener());
			((MainFrame) theView).addUnapredjivanjeKorisnikaListener(new UnapredjivanjeKorisnikaListener());
			((MainFrame) theView).addIzmenaPodatakaKorisnikaListener(new IzmenaPodatakaKorisnikaListener());
			((MainFrame) theView).addBrisanjeKorisnikaListener(new BrisanjeKorisnikaListener());
			((MainFrame) theView).addPregledKorisnikaListener(new PregledKorisnikaListener());
			((MainFrame) theView).addIzmenaSopstvenihPodatakaListener(new IzmenaSopstvenihPodatakaListener());
			((MainFrame) theView).addLogoutListener(new LogoutListener());
		}
		;
		MainFrame.setMade(true);
		((MainFrame) theView).setVisible(true);
	}

	private void funkcijaDialogToMainFrame() {
		((Window) theView).addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosed(WindowEvent e) {
		    	// vracanje na MainFrame
		        theView = MainFrame.getInstance();
		    }
		});
	}
	
	public class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String korisnickoIme = ((LoginDialog) theView).getUsername();
			String lozinka = ((LoginDialog) theView).getPassword();

			// promeni theView na MainFrame
			if (theApp.logIn()) {
				loginToMainFrame();
			} else {
				// obavestenje da je nevalidno korisnicko ime i lozinka
				// theView.errorLogin();
			}
		}
	}

	public class IzvestajListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// promeni theView na IzvestajDialog
			((LoginDialog) theView).dispose();
			theView = new LoginSpoljniDialog();
			((LoginSpoljniDialog) theView).setVisible(true);
			((LoginSpoljniDialog) theView).addPovratakListener(new SpoljniDijalogPovratakListener());
			((LoginSpoljniDialog) theView).addLoginListener(new SpoljniDijalogLoginListener());
		}
	}

	public class VodaIzvestajListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za uvid izvestaja o potrosnji vode
			System.out.println("IZVESTAJ VODA");
			// TODO
		}
	}

	public class GasIzvestajListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za uvid izvestaja o potrosnji gasa
			System.out.println("IZVESTAJ GAS");
			// TODO
		}
	}

	public class StrujaIzvestajListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za uvid izvestaja o potrosnji struje
			System.out.println("IZVESTAJ STRUJA");
			// TODO
		}
	}

	public class KreiranjeKorisnikaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za kreiranje novog korisnika
			System.out.println("KREIRANJE KORISNIKA");
			// TODO
		}
	}

	public class UnapredjivanjeKorisnikaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za unapredjivanje korisnika
			System.out.println("UNAPREDJIVANJE KORISNIKA");
			List<Nalog> readNalozi = theApp.getReadNalozi();

			KorisniciTableModel tm = new KorisniciTableModel(readNalozi);
			UnapredjivanjeDialog d = new UnapredjivanjeDialog((MainFrame) theView, "ISAK - Unapredjivanje korisnika", tm);
			d.addUnaprediKorisnikaListener(new UnaprediKorisnikaListener());
			theView = d;
			d.setVisible(true);
			
			// dodavanje listenera za zatvaranje dijaloga i vracanje theView na MainFrame
			funkcijaDialogToMainFrame();
		}
	}

	public class UnaprediKorisnikaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// izvrsi unapredjivanje korisnika
			System.out.println("UNAPREDI KORISNIKA");
			String korisnickoIme = ((PanelDetailKorisnici) ((UnapredjivanjeDialog)theView).getPanDetail()).getTxtKorisnickoIme().getText();
			Nalog nalog = theApp.getNalog(korisnickoIme);
			if (nalog == null) {
				JOptionPane.showMessageDialog((UnapredjivanjeDialog)theView, "Nije odabran nijedan korisnik!", "Greska", JOptionPane.ERROR_MESSAGE);
			}
			else {
				nalog.getKorisnik().setTipKorisnika(TipKorisnika.readWrite);
				// TODO // theApp.unaprediKorisnika(nalog);
				JOptionPane.showMessageDialog((UnapredjivanjeDialog)theView, "Korisnik je uspesno unapredjen.", "Uspesno unapredjivanje", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public class IzmenaPodatakaKorisnikaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za izmenu podataka korisnika
			System.out.println("IZMENA PODATAKA KORISNIKA");
			// TODO
		}
	}

	public class BrisanjeKorisnikaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za brisanje korisnika
			System.out.println("BRISANJE KORISNIKA");
			// TODO
		}
	}

	public class PregledKorisnikaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za pregled korisnika
			System.out.println("PREGLED KORISNIKA");
			List<Nalog> nalozi = theApp.getNalozi();

			KorisniciTableModel tm = new KorisniciTableModel(nalozi);
			KorisniciPrikazDialog d = new KorisniciPrikazDialog((MainFrame) theView, "ISAK - Pregled korisnika", tm);
			theView = d;
			d.setVisible(true);
			// dodavanje listenera za zatvaranje dijaloga i vracanje theView na MainFrame
			funkcijaDialogToMainFrame();
		}
	}

	public void IzmenaSopstvenihPodatakaNaMainFrame()
	{
		((IzmenaSopstvenihPodatakaDialog) theView).dispose();
		theView = MainFrame.getInstance();
		if (!MainFrame.getMade()) {
			((MainFrame) theView).addVodaIzvestajListener(new VodaIzvestajListener());
			((MainFrame) theView).addGasIzvestajListener(new GasIzvestajListener());
			((MainFrame) theView).addStrujaIzvestajListener(new StrujaIzvestajListener());

			((MainFrame) theView).addKreiranjeKorisnikaListener(new KreiranjeKorisnikaListener());
			((MainFrame) theView).addUnapredjivanjeKorisnikaListener(new UnapredjivanjeKorisnikaListener());
			((MainFrame) theView).addIzmenaPodatakaKorisnikaListener(new IzmenaPodatakaKorisnikaListener());
			((MainFrame) theView).addBrisanjeKorisnikaListener(new BrisanjeKorisnikaListener());
			((MainFrame) theView).addPregledKorisnikaListener(new PregledKorisnikaListener());
			((MainFrame) theView).addIzmenaSopstvenihPodatakaListener(new IzmenaSopstvenihPodatakaListener());
			((MainFrame) theView).addLogoutListener(new LogoutListener());
		}
		;
		MainFrame.setMade(true);
		((MainFrame) theView).setVisible(true);
	}
	
	public class IzmenaSopstvenihPodatakaCancelListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			IzmenaSopstvenihPodatakaNaMainFrame();
			
		}
		
	}
	
	public class IzmenaSopstvenihPodatakaOK implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			theApp.getTrenutnoUlogovani().getKorisnik().setIme(((IzmenaSopstvenihPodatakaDialog) theView).getIme());
			theApp.getTrenutnoUlogovani().getKorisnik().setPrezime(((IzmenaSopstvenihPodatakaDialog) theView).getPrezime());
			theApp.getTrenutnoUlogovani().setKorisnickoIme(((IzmenaSopstvenihPodatakaDialog) theView).getKorisnickoIme());
			theApp.getTrenutnoUlogovani().setSifra(((IzmenaSopstvenihPodatakaDialog) theView).getLozinka());
			
			Date datumRodjenja = parseDate(((IzmenaSopstvenihPodatakaDialog) theView).getDatumRodjenja());
			theApp.getTrenutnoUlogovani().getKorisnik().setDatumRodjenja(datumRodjenja);
			
			theApp.getTrenutnoUlogovani().getKorisnik().setPol(((IzmenaSopstvenihPodatakaDialog) theView).getPol());
			
			IzmenaSopstvenihPodatakaNaMainFrame();
			
			
		}
		
	}
	
	public class IzmenaSopstvenihPodatakaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				theView = new IzmenaSopstvenihPodatakaDialog();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			((IzmenaSopstvenihPodatakaDialog) theView).addCancelListener(new IzmenaSopstvenihPodatakaCancelListener());
			((IzmenaSopstvenihPodatakaDialog) theView).addOkListener(new IzmenaSopstvenihPodatakaOK());
			
			((IzmenaSopstvenihPodatakaDialog) theView).setIme(theApp.getTrenutnoUlogovani().getKorisnik().getIme());
			((IzmenaSopstvenihPodatakaDialog) theView).setPrezime(theApp.getTrenutnoUlogovani().getKorisnik().getPrezime());
			((IzmenaSopstvenihPodatakaDialog) theView).setKorisnickoIme(theApp.getTrenutnoUlogovani().getKorisnickoIme());
			((IzmenaSopstvenihPodatakaDialog) theView).setLozinka(theApp.getTrenutnoUlogovani().getSifra());
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			String datum = df.format(theApp.getTrenutnoUlogovani().getKorisnik().getDatumRodjenja());
			((IzmenaSopstvenihPodatakaDialog) theView).setDatum(datum);
			
			((IzmenaSopstvenihPodatakaDialog) theView).setPol(theApp.getTrenutnoUlogovani().getKorisnik().getPol());
			
			((IzmenaSopstvenihPodatakaDialog) theView).setVisible(true);
		}
	}

	public class LogoutListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// promeni theView na LoginDialog
			((MainFrame) theView).dispose();
			theView = new LoginDialog();
			((LoginDialog) theView).addLoginListener(new LoginListener());
			((LoginDialog) theView).addIzvestajListener(new IzvestajListener());
			((LoginDialog) theView).setVisible(true);
			// System.out.println("HELLO IZLOGOVAO SAM SE");
		}
	}

	public class SpoljniDijalogPovratakListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			((LoginSpoljniDialog) theView).dispose();
			theView = new LoginDialog();
			((LoginDialog) theView).setVisible(true);

			((LoginDialog) theView).addLoginListener(new LoginListener());
			((LoginDialog) theView).addIzvestajListener(new IzvestajListener());

		}
	}

	public class SpoljniDijalogLoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			((LoginSpoljniDialog) theView).dispose();
			theView = new IzvjestajDialog();
			((IzvjestajDialog) theView).setVisible(true);

			((IzvjestajDialog) theView).addPovratakListener(new IzvestajPovratakListener());
			((IzvjestajDialog) theView).addTraziListener(new IzvestajTraziListener());
		}

	}

	public class IzvestajPovratakListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			((IzvjestajDialog) theView).dispose();
			theView = new LoginDialog();
			((LoginDialog) theView).setVisible(true);

			((LoginDialog) theView).addLoginListener(new LoginListener());
			((LoginDialog) theView).addIzvestajListener(new IzvestajListener());
		}
	}

	public class IzvestajTraziListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO
			// String odabir = ((IzvjestajDialog) theView).getVrstaIzvestaja();
			// theApp.formirajIzvestaj(odabir);
		}
	}

	public class NaloziSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {

			if (!e.getValueIsAdjusting()) {
				int row = ((AbstractDialog) theView).getTable().getSelectedRow();

				/* Nista nije selektovano */
				if (row == -1)
					return;
				String korisnickoIme = (String) ((AbstractDialog) theView).getTable().getValueAt(row, 0);
				Nalog nalog = theApp.getNalog(korisnickoIme);
				
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				PanelDetailKorisnici panelDetailRegistar = (PanelDetailKorisnici) ((AbstractDialog) theView)
						.getPanDetail();
				panelDetailRegistar.getTxtKorisnickoIme().setText(nalog.getKorisnickoIme());
				panelDetailRegistar.getTxtLozinka().setText(nalog.getSifra());
				panelDetailRegistar.getTxtPrezime().setText(nalog.getKorisnik().getPrezime());
				panelDetailRegistar.getTxtIme().setText(nalog.getKorisnik().getIme());
				panelDetailRegistar.getTxtDatumRodjenja()
						.setText(df.format(nalog.getKorisnik().getDatumRodjenja()));
				if (nalog.getKorisnik().getPol() == Pol.muski) {
					panelDetailRegistar.getRdbtnMuski().setSelected(true);
				} else if (nalog.getKorisnik().getPol() == Pol.zenski) {
					panelDetailRegistar.getRdbtnZenski().setSelected(true);
				} else {
					panelDetailRegistar.getRdbtnOstalo().setSelected(true);
				}
				if (nalog.getKorisnik().getTipKorisnika() == TipKorisnika.read) {
					panelDetailRegistar.getRdbtnRead().setSelected(true);
				} else {
					panelDetailRegistar.getRdbtnReadWrite().setSelected(true);
				}
			}
		}
	}
	
	 public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("dd-MM-yyyy").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
}
