package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import konstante.Konstante;
import model.Aplikacija;
import model.komponente.Komponenta;
import model.komponente.Soba;
import model.komponente.funkcije.NemaPromjenu;
import model.korisnik.Korisnik;
import model.korisnik.Nalog;
import model.korisnik.Pol;
import model.korisnik.TipKorisnika;
import model.stanja.LogInKorisnik;
import model.stanja.LogInSpoljni;
import model.stanja.ReadRezim;
import model.stanja.SpoljniRezim;
import view.BrisanjeKorisnikaDialog;
import view.IzmenaSopstvenihPodatakaDialog;
import view.IzmjenaKorisnikaDialog;
import view.IzvjestajDialog;
import view.KomponentaDialog;
import view.KreiranjeNovogNalogaDialog;
import view.LoginDialog;
import view.LoginSpoljniDialog;
import view.MainFrame;
import view.PrikazIzvestajaDialog;
import view.PrikazStanjaSobeDialog;
import view.dugmici.KomponentaButton;
import view.dugmici.SobaButton;
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

			((MainFrame) theView).addSobe(theApp.getTlocrt().getSobe(), new SobaDialogListener());
			((MainFrame) theView).addKomponente(theApp.getTlocrt().getKomponente(), new KomponentaDialogListener());
		}
		if (theApp.getStanje() instanceof ReadRezim) {
			((MainFrame) theView).restrict();
		}
		else {
			((MainFrame) theView).permit();
		}
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

	private void izmenaSopstvenihPodatakToMainFrame() {
		((IzmenaSopstvenihPodatakaDialog) theView).dispose();
		theView = MainFrame.getInstance();
	}

	private void kreiranjeNovogNalogaToMainFrame() {
		((KreiranjeNovogNalogaDialog) theView).dispose();
		theView = MainFrame.getInstance();
	}

	public class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String korisnickoIme = ((LoginDialog) theView).getUsername();
			String lozinka = ((LoginDialog) theView).getPassword();

			// promeni theView na MainFrame
			if (theApp.dugmeLogIn(korisnickoIme, lozinka)) {
				loginToMainFrame();
			} else {
				JOptionPane.showMessageDialog((LoginDialog) theView,
						"Nevalidna kombinacija korisnickog imena i lozinke!", "Neuspesno prijavljivanje",
						JOptionPane.ERROR_MESSAGE);
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
			theApp.pritisnutoDugmeIzvjestaji();
		}
	}

	public class VodaIzvestajListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za uvid izvestaja o potrosnji vode
			PrikazIzvestajaDialog d = new PrikazIzvestajaDialog((MainFrame) theView);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calendar = Calendar.getInstance();

			d.setAll(theApp.getTlocrtAdresa(), theApp.getTrenutnoUlogovani().getKorisnickoIme(), "Voda",
					sdf.format(calendar.getTime()), "100", "120", "20");
			theView = d;
			((PrikazIzvestajaDialog) theView).setVisible(true);
			funkcijaDialogToMainFrame();
		}
	}

	public class GasIzvestajListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za uvid izvestaja o potrosnji gasa
			PrikazIzvestajaDialog d = new PrikazIzvestajaDialog((MainFrame) theView);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calendar = Calendar.getInstance();

			d.setAll(theApp.getTlocrtAdresa(), theApp.getTrenutnoUlogovani().getKorisnickoIme(), "Gas",
					sdf.format(calendar.getTime()), "100", "120", "20");
			theView = d;
			((PrikazIzvestajaDialog) theView).setVisible(true);
			funkcijaDialogToMainFrame();
		}
	}

	public class StrujaIzvestajListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za uvid izvestaja o potrosnji struje
			PrikazIzvestajaDialog d = new PrikazIzvestajaDialog((MainFrame) theView);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calendar = Calendar.getInstance();

			d.setAll(theApp.getTlocrtAdresa(), theApp.getTrenutnoUlogovani().getKorisnickoIme(), "Struja",
					sdf.format(calendar.getTime()), "100", "120", "20");
			theView = d;
			((PrikazIzvestajaDialog) theView).setVisible(true);
			funkcijaDialogToMainFrame();
		}
	}

	public class KreirajNoviNalogPrijaviSeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String ime = ((KreiranjeNovogNalogaDialog) theView).getIme();
			String prezime = ((KreiranjeNovogNalogaDialog) theView).getPrezime();
			String korisnickoIme = ((KreiranjeNovogNalogaDialog) theView).getKorisnickoIme();
			if (theApp.nalogPostoji(korisnickoIme)) {
				JOptionPane.showMessageDialog((KreiranjeNovogNalogaDialog) theView,
						"Korisnicko ime vec postoji!", "Neuspesno kreiranje korisnika",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			String lozinka = ((KreiranjeNovogNalogaDialog) theView).getLozinka();
			Date datumRodjenja = parseDate(((KreiranjeNovogNalogaDialog) theView).getDatumRodjenja());
			Pol pol = ((KreiranjeNovogNalogaDialog) theView).getPol();
			TipKorisnika tipKorisnika = ((KreiranjeNovogNalogaDialog) theView).getTipKorisnika();
			
			if (ime.equals("Ime") || prezime.equals("Prezime") || korisnickoIme.equals("Korisnicko ime")
					|| lozinka.equals("Lozinka") || pol == null || tipKorisnika == null) {
				JOptionPane.showMessageDialog((KreiranjeNovogNalogaDialog) theView,
						"Morate popuniti sva polja!", "Neuspesno kreiranje korisnika",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			Korisnik korisnik = new Korisnik(ime, prezime, datumRodjenja, pol, tipKorisnika);

			Nalog nalog = new Nalog(korisnickoIme, lozinka, Konstante.TLOCRT1, korisnik);

			theApp.addNalozi(nalog);

			kreiranjeNovogNalogaToMainFrame();
		}

	}

	public class KreiranjeKorisnikaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				theView = new KreiranjeNovogNalogaDialog((MainFrame) theView);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			((KreiranjeNovogNalogaDialog) theView).addPrijaviSeListener(new KreirajNoviNalogPrijaviSeListener());

			((KreiranjeNovogNalogaDialog) theView).setVisible(true);

			// dodavanje listenera za zatvaranje dijaloga i vracanje theView na MainFrame
			funkcijaDialogToMainFrame();
		}
	}

	public class UnapredjivanjeKorisnikaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za unapredjivanje korisnika
			List<Nalog> readNalozi = theApp.getReadNalozi();

			KorisniciTableModel tm = new KorisniciTableModel(readNalozi);
			UnapredjivanjeDialog d = new UnapredjivanjeDialog((MainFrame) theView, "ISAK - Unapredjivanje korisnika",
					tm);
			d.addListSelectionListener(new NaloziSelectionListener());
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
			String korisnickoIme = ((PanelDetailKorisnici) ((UnapredjivanjeDialog) theView).getPanDetail())
					.getTxtKorisnickoIme().getText();
			Nalog nalog = theApp.getNalog(korisnickoIme);
			if (nalog == null) {
				JOptionPane.showMessageDialog((UnapredjivanjeDialog) theView, "Nije odabran nijedan korisnik!",
						"Greska", JOptionPane.ERROR_MESSAGE);
			} else {
				theApp.unaprediKorisnika(nalog);
				JOptionPane.showMessageDialog((UnapredjivanjeDialog) theView, "Korisnik je uspesno unapredjen.",
						"Uspesno unapredjivanje", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public class IzmenaPodatakaKorisnikaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za izmenu podataka korisnika

			List<Nalog> naloziBezSvog = theApp.getNaloziBezSvog();
			IzmjenaKorisnikaDialog ikd = new IzmjenaKorisnikaDialog((MainFrame) theView);
			ikd.addToCmb(naloziBezSvog);

			ikd.addPotvrdiListener(new PotvrdiIzmjenuKorisnikaListener());
			ikd.addPovratakListener(new PovrakatIzmjenaKorisnikaListener());

			theView = ikd;
			funkcijaDialogToMainFrame();
			((IzmjenaKorisnikaDialog) theView).setVisible(true);

		}
	}

	public class PotvrdiIzmjenuKorisnikaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			Nalog izmijenjen = ((IzmjenaKorisnikaDialog) theView).getSelected();
			List<Nalog> sviNalozi = theApp.getNalozi();
			for (Nalog n : sviNalozi) {
				if (n.getKorisnickoIme().equals(izmijenjen.getKorisnickoIme())) {
					n.getKorisnik().setIme(((IzmjenaKorisnikaDialog) theView).getTxfIme());
					n.getKorisnik().setPrezime(((IzmjenaKorisnikaDialog) theView).getTxfPrezime());
					n.getKorisnik().setDatumRodjenja(parseDate(((IzmjenaKorisnikaDialog) theView).getDatum()));
					n.getKorisnik().setPol(((IzmjenaKorisnikaDialog) theView).getPol());
				}
			}
			((IzmjenaKorisnikaDialog) theView).dispose();
			funkcijaDialogToMainFrame();
			theView = MainFrame.getInstance();
		}
	}

	public class PovrakatIzmjenaKorisnikaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			((IzmjenaKorisnikaDialog) theView).dispose();
			funkcijaDialogToMainFrame();
			theView = MainFrame.getInstance();
		}
	}

	public class BrisanjeKorisnikaListener implements ActionListener {
		public ArrayList<String> getKoris() {
			ArrayList<String> koris = new ArrayList<String>();
			for (Nalog n : theApp.getNalozi()) {
				koris.add(n.getKorisnickoIme());
			}
			return koris;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za brisanje korisnika
			BrisanjeKorisnikaDialog d = new BrisanjeKorisnikaDialog((MainFrame)theView);
			d.dialog.setKorisnici(getKoris());
			d.addIzbrisiListener(new IzbrisiListener());

			theView = d;
			((BrisanjeKorisnikaDialog) theView).setVisible(true);
			funkcijaDialogToMainFrame();
		}
	}

	public class IzbrisiListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String korisnickoIme = ((BrisanjeKorisnikaDialog) theView).getTxfKorisnickoIme();
			Nalog nalog = theApp.getNalog(korisnickoIme);
			if (nalog != null) {
				theApp.removeNalozi(nalog);
				((BrisanjeKorisnikaDialog) theView).dispose();
				theView = MainFrame.getInstance();
			} else {
				JOptionPane.showMessageDialog((BrisanjeKorisnikaDialog) theView,
						"Nevalidna vrednost korisnickog imena!", "Neuspesno brisanje", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public class PregledKorisnikaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za pregled korisnika
			List<Nalog> nalozi = theApp.getNalozi();

			KorisniciTableModel tm = new KorisniciTableModel(nalozi);
			KorisniciPrikazDialog d = new KorisniciPrikazDialog((MainFrame) theView, "ISAK - Pregled korisnika", tm);
			d.addListSelectionListener(new NaloziSelectionListener());
			theView = d;
			d.setVisible(true);
			// dodavanje listenera za zatvaranje dijaloga i vracanje theView na MainFrame
			funkcijaDialogToMainFrame();
		}
	}

	public class IzmenaSopstvenihPodatakaCancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			izmenaSopstvenihPodatakToMainFrame();

		}

	}

	public class IzmenaSopstvenihPodatakaOK implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			theApp.getTrenutnoUlogovani().getKorisnik().setIme(((IzmenaSopstvenihPodatakaDialog) theView).getIme());
			theApp.getTrenutnoUlogovani().getKorisnik()
					.setPrezime(((IzmenaSopstvenihPodatakaDialog) theView).getPrezime());
			String korisnickoIme = ((IzmenaSopstvenihPodatakaDialog) theView).getKorisnickoIme();
			if (!theApp.getTrenutnoUlogovani().getKorisnickoIme().equals(korisnickoIme)) {
				if (theApp.nalogPostoji(korisnickoIme)) {
					JOptionPane.showMessageDialog((IzmenaSopstvenihPodatakaDialog) theView,
							"Korisnicko ime vec postoji!", "Neuspesna promena podataka korisnika",
							JOptionPane.ERROR_MESSAGE);
					return;
				}	
			}
			else {
				theApp.getTrenutnoUlogovani().setKorisnickoIme(korisnickoIme);
			}
			theApp.getTrenutnoUlogovani()
					.setKorisnickoIme(((IzmenaSopstvenihPodatakaDialog) theView).getKorisnickoIme());
			theApp.getTrenutnoUlogovani().setSifra(((IzmenaSopstvenihPodatakaDialog) theView).getLozinka());

			Date datumRodjenja = parseDate(((IzmenaSopstvenihPodatakaDialog) theView).getDatumRodjenja());
			theApp.getTrenutnoUlogovani().getKorisnik().setDatumRodjenja(datumRodjenja);

			theApp.getTrenutnoUlogovani().getKorisnik().setPol(((IzmenaSopstvenihPodatakaDialog) theView).getPol());

			izmenaSopstvenihPodatakToMainFrame();

		}
	}

	public class IzmenaSopstvenihPodatakaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				theView = new IzmenaSopstvenihPodatakaDialog((MainFrame) theView);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			((IzmenaSopstvenihPodatakaDialog) theView).addCancelListener(new IzmenaSopstvenihPodatakaCancelListener());
			((IzmenaSopstvenihPodatakaDialog) theView).addOkListener(new IzmenaSopstvenihPodatakaOK());

			((IzmenaSopstvenihPodatakaDialog) theView).setIme(theApp.getTrenutnoUlogovani().getKorisnik().getIme());
			((IzmenaSopstvenihPodatakaDialog) theView)
					.setPrezime(theApp.getTrenutnoUlogovani().getKorisnik().getPrezime());
			((IzmenaSopstvenihPodatakaDialog) theView)
					.setKorisnickoIme(theApp.getTrenutnoUlogovani().getKorisnickoIme());
			((IzmenaSopstvenihPodatakaDialog) theView).setLozinka(theApp.getTrenutnoUlogovani().getSifra());

			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			String datum = df.format(theApp.getTrenutnoUlogovani().getKorisnik().getDatumRodjenja());
			((IzmenaSopstvenihPodatakaDialog) theView).setDatum(datum);

			((IzmenaSopstvenihPodatakaDialog) theView).setPol(theApp.getTrenutnoUlogovani().getKorisnik().getPol());

			((IzmenaSopstvenihPodatakaDialog) theView).setVisible(true);
			
			funkcijaDialogToMainFrame();
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
			theApp.dugmeLogOut();
			FileKontroler.writeOutputFile(theApp);
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
			theApp.pritisnutoDugmePovratak();
		}
	}

	public class SpoljniDijalogLoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String idFirme = ((LoginSpoljniDialog) theView).getId();
			if (theApp.dugmeLogovanjeSpoljnog(idFirme)) {
				((LoginSpoljniDialog) theView).dispose();
				theView = new IzvjestajDialog();
				((IzvjestajDialog) theView).setVisible(true);

				((IzvjestajDialog) theView).addPovratakListener(new IzvestajPovratakListener());
				((IzvjestajDialog) theView).addTraziListener(new IzvestajTraziListener());
				//theApp.promeniStanje(new SpoljniRezim(theApp));
			} else {
				JOptionPane.showMessageDialog((LoginSpoljniDialog) theView, "Nepostojeci ID kompanije!",
						"Neuspesno prijavljivanje", JOptionPane.ERROR_MESSAGE);
			}
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
			theApp.pritisnutoDugmeZaOdustajanje();
		}
	}

	public class IzvestajTraziListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog((IzvjestajDialog) theView, "Trazeni izvestaj uspesno generisan.",
					"Generisanje izvestaja", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public class SobaOKListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			((PrikazStanjaSobeDialog) theView).dispose();
			theView = MainFrame.getInstance();
		}
	}

	public class SobaDialogListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Soba s = ((SobaButton) e.getSource()).getSoba();
			try {
				theView = new PrikazStanjaSobeDialog((MainFrame) theView);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			((PrikazStanjaSobeDialog) theView).setTemperatura(s.getTemperatura() + "");
			((PrikazStanjaSobeDialog) theView).setVlaznost(s.getVlaznost() + "");
			((PrikazStanjaSobeDialog) theView).setNaziv(s.getIme());
			((PrikazStanjaSobeDialog) theView).addKomponente(s.getKomponente());
			((PrikazStanjaSobeDialog) theView).addOKListener(new SobaOKListener());
			((PrikazStanjaSobeDialog) theView).setVisible(true);

			funkcijaDialogToMainFrame();
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

				panelDetailRegistar.getTxtDatumRodjenja().setText(df.format(nalog.getKorisnik().getDatumRodjenja()));
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

	public class KomponentaDialogListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			Komponenta k = ((KomponentaButton) e.getSource()).getKomponenta();
			KomponentaDialog kd = new KomponentaDialog((MainFrame) theView);
			kd.setId(k.getId());
			kd.setSlika(k.getTipKomponente().getSlika());
			kd.setNaziv(k.getNaziv());
			kd.setTip(k.getTipKomponente().toString());
			kd.setSoba(k.getSoba().getIme());
			kd.setToggleButton(k.getUkljucena());
			kd.setOpisVrijednosti(k.getTipKomponente().getOpisVrijednosti());
			kd.setVrijednost(k.getVrednost());

			if (k.getTipKomponente().getPromijeni() instanceof NemaPromjenu) {
				kd.disableVrijednost();
			}

			kd.addPotvrdiListener(new PotvrdiKomponentuListener());
			kd.addPovratakListener(new PovrakatKomponentaListener());

			theView = kd;
			funkcijaDialogToMainFrame();
			((KomponentaDialog) theView).setVisible(true);

		}
	}

	public class PotvrdiKomponentuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			int idKomponente = ((KomponentaDialog) theView).getId();
			Komponenta izmijenjena = theApp.getTlocrt().nadjiKomponentu(idKomponente);
			izmijenjena.getTipKomponente().getPromijeni().uradi(izmijenjena,
					((KomponentaDialog) theView).getVrijednost());
			izmijenjena.getTipKomponente().getUkljuciIskljuci().uradi(izmijenjena,
					((KomponentaDialog) theView).getOnOff());

			((KomponentaDialog) theView).dispose();
			funkcijaDialogToMainFrame();
			theView = MainFrame.getInstance();
		}
	}

	public class PovrakatKomponentaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			((KomponentaDialog) theView).dispose();
			funkcijaDialogToMainFrame();
			theView = MainFrame.getInstance();
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

