package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Aplikacija;
import view.IzvjestajDialog;
import view.LoginDialog;
import view.LoginSpoljniDialog;
import view.MainFrame;

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
		};
		MainFrame.setMade(true);
		((MainFrame) theView).setVisible(true);
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
			// TODO
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
			// TODO
		}
	}

	public class IzmenaSopstvenihPodatakaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// prikazi dijalog za izmenu sopstvenih podataka
			System.out.println("IZMENA SOPSTVENIH PODATAKA");
			// TODO
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

}
