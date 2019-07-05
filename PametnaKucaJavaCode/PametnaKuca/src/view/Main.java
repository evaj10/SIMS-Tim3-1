package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.Kontroler;
import konstante.Konstante;
import model.Aplikacija;
import model.komponente.Klima;
import model.komponente.Komponenta;
import model.komponente.Soba;
import model.komponente.TipKomponente;
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
		
		
		/*Korisnik read1 = new Korisnik("Aragorn", "Prcic", parseDate("16-3-1998"), 
				Pol.muski, TipKorisnika.read );
		Korisnik write = new Korisnik("Sonja", "Prcic", parseDate("17-3-1998"), 
				Pol.zenski, TipKorisnika.readWrite);
		
		Nalog ar = new Nalog("aragorn", "ksenija123", Konstante.TLOCRT1, read);
		Nalog msp = new Nalog("msp", "msp", Konstante.TLOCRT1, write);
		ar.setKorisnik(read1);
		msp.setKorisnik(write);
		app.addNalozi(ar);
		app.addNalozi(msp);*/
		
		
		

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