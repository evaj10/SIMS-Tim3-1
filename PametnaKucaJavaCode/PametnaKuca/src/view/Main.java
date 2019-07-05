package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.Kontroler;
import konstante.Konstante;
import model.Aplikacija;
import model.korisnik.Korisnik;
import model.korisnik.Nalog;
import model.korisnik.Pol;
import model.korisnik.TipKorisnika;

public class Main {

	public static void main(String[] args) {
		Aplikacija app = new Aplikacija();

		Korisnik read = new Korisnik("Ksenija", "Prcic", parseDate("16-3-1998"), Pol.zenski, TipKorisnika.read);

		Nalog ks = new Nalog("ksenijaMafija", "ksenija123", Konstante.TLOCRT1, read);

		app.setTrenutnoUlogovani(ks);

		LoginDialog prozor = new LoginDialog();

		Kontroler kontroler = new Kontroler(prozor, app);

		prozor.setVisible(true);
	}

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd-MM-yyyy").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

}