/*
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import konstante.Konstante;
import model.Aplikacija;
import model.komponente.Alarm;
import model.komponente.Klima;
import model.komponente.Komponenta;
import model.komponente.Radijator;
import model.komponente.Soba;
import model.komponente.Tacka;
import model.komponente.TipKomponente;
import model.komponente.Tlocrt;
import model.komponente.Zvucnik;
import model.korisnik.Adresa;
import model.korisnik.Korisnik;
import model.korisnik.Mesto;
import model.korisnik.Nalog;
import model.korisnik.Pol;
import model.korisnik.SpoljniKorisnik;
import model.korisnik.TipKorisnika;

public class TestPrimer {
	public Aplikacija app = new Aplikacija();
	
	public TestPrimer() {}
	
	public TestPrimer(int br) {
		
		Tlocrt tlocrt = new Tlocrt("ISAK The First", Konstante.TLOCRT1,
				new Adresa("Masarikova", 14, new Mesto(15353, "Majur")));
		

		Korisnik k1 = new Korisnik("Mirko", "Birkic", parseDate("18-5-1973"), Pol.muski, TipKorisnika.readWrite);
		Nalog n1 = new Nalog("MirkoBirkic", "mir-bir1", Konstante.TLOCRT1, k1);

		Korisnik k2 = new Korisnik("Ivana", "Radic-Birkic", parseDate("24-9-1977"), Pol.zenski,
				TipKorisnika.readWrite);
		Nalog n2 = new Nalog("IvanaRadic", "iva-rad2", Konstante.TLOCRT1, k2);

		Korisnik k3 = new Korisnik("Jelisaveta", "Radic", parseDate("3-7-1953"), Pol.zenski, TipKorisnika.read);
		Nalog n3 = new Nalog("JelisavetaRadic", "jel-rad3", Konstante.TLOCRT1, k3);

		Korisnik k4 = new Korisnik("Ilija", "Birkic", parseDate("6-10-2003"), Pol.muski, TipKorisnika.read);
		Nalog n4 = new Nalog("THEBOSS", "ili-biri03", Konstante.TLOCRT1, k4);

		Korisnik k5 = new Korisnik("Ktitor", "Birkic", parseDate("7-11-2005"), Pol.ostalo, TipKorisnika.read);
		Nalog n5 = new Nalog("KTITOR4EVER", "bieber<3", Konstante.TLOCRT1, k5);

		SpoljniKorisnik sk = new SpoljniKorisnik(1, "Banka Inesa");
		app.addSpoljniKorisnik(sk);
		
		app.addNalozi(n1);
		app.addNalozi(n2);
		app.addNalozi(n3);
		app.addNalozi(n4);
		app.addNalozi(n5);
		
		Soba dnevni = new Soba("Dnevni boravak");
		Soba spavaca1 = new Soba("Spavaca soba 1");
		Soba spavaca2 = new Soba("Spavaca soba 2");
		Soba spavaca3 = new Soba("Spavaca soba 3");
		Soba kuhinja = new Soba("Kuhinja");
		Soba kupatilo = new Soba("Kupatilo");

		tlocrt.addSobe(dnevni);
		tlocrt.addSobe(spavaca1);
		tlocrt.addSobe(spavaca2);
		tlocrt.addSobe(spavaca3);
		tlocrt.addSobe(kuhinja);
		tlocrt.addSobe(kupatilo);

		TipKomponente tipAlarm = new Alarm();
		TipKomponente tipRadijator = new Radijator();
		TipKomponente tipZvucnik = new Zvucnik();
		TipKomponente tipKlima = new Klima();

		Komponenta alarm = new Komponenta(1, "Panasonic KX-HN6002FXW", kuhinja, tipAlarm, 
				new Tacka(60, 60));
		Komponenta radijator = new Komponenta(2, "Grejac UGNEO", kupatilo, tipRadijator, 
				new Tacka(270, 370));
		Komponenta zvucnik = new Komponenta(3, "BOSE SoundTouch 30 Series III", dnevni, tipZvucnik, 
				new Tacka(230, 30));
		Komponenta klima1 = new Komponenta(4, "LG AM18BP", spavaca1, tipKlima, 
				new Tacka(10, 400));
		Komponenta klima2 = new Komponenta(5, "LG AM18BP", spavaca2, tipKlima, 
				new Tacka(520, 400));

		dnevni.addKomponente(zvucnik);
		spavaca1.addKomponente(klima1);
		spavaca2.addKomponente(klima2);
		kuhinja.addKomponente(alarm);
		kupatilo.addKomponente(radijator);

		tlocrt.addKomponente(alarm);
		tlocrt.addKomponente(radijator);
		tlocrt.addKomponente(zvucnik);
		tlocrt.addKomponente(klima1);
		tlocrt.addKomponente(klima2);
		
		app.setTlocrt(tlocrt);
	}
	
	public static void main(String args[]) {
		TestPrimer tp = new TestPrimer(1);
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(Konstante.FILE_NAME));
			os.writeObject(tp.app);
			System.out.println("Written.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ObjectInputStream os = new ObjectInputStream(new FileInputStream(Konstante.FILE_NAME));
			TestPrimer ucitan = new TestPrimer();
			try {
				ucitan.app = (Aplikacija) os.readObject();
				System.out.println("Read.");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
*/