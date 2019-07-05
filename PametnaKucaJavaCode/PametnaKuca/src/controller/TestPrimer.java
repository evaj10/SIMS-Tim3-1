package controller;

import konstante.Konstante;
import model.Aplikacija;
import model.komponente.Alarm;
import model.komponente.Klima;
import model.komponente.Komponenta;
import model.komponente.Radijator;
import model.komponente.Soba;
import model.komponente.TipKomponente;
import model.komponente.Tlocrt;
import model.komponente.Zvucnik;

public class TestPrimer {

	private Tlocrt tlocrt;
	private Aplikacija app;
	
	public TestPrimer() {
		this.tlocrt = new Tlocrt(1, "ISAK The First", Konstante.TLOCRT1);
		
		Soba dnevni = new Soba(1, "Dnevni boravak");
		Soba spavaca = new Soba(2, "Spavaca soba 1");
		Soba kuhinja = new Soba(3, "Kuhinja");
		Soba kupatilo = new Soba(4, "Kupatilo");
		
		this.tlocrt.addSobe(dnevni);
		this.tlocrt.addSobe(spavaca);
		this.tlocrt.addSobe(kuhinja);
		this.tlocrt.addSobe(kupatilo);
		
		TipKomponente tipAlarm = new Alarm();
		TipKomponente tipRadijator = new Radijator();
		TipKomponente tipZvucnik = new Zvucnik();
		TipKomponente tipKlima = new Klima();
		
		Komponenta alarm = new Komponenta(1, "Alarm za dim", kuhinja, tipAlarm);
		Komponenta radijator = new Komponenta(2, "Radijator - kupatilo", kupatilo, tipRadijator);
		Komponenta zvucnik = new Komponenta(3, "Zvucnik - TUCTUC", dnevni, tipZvucnik);
		Komponenta klima = new Komponenta(4, "Klima da ladi", spavaca, tipKlima);
		
		dnevni.addKomponente(zvucnik);
		spavaca.addKomponente(klima);
		kuhinja.addKomponente(alarm);
		kupatilo.addKomponente(radijator);
		
		this.tlocrt.addKomponente(alarm);
		this.tlocrt.addKomponente(radijator);
		this.tlocrt.addKomponente(zvucnik);
		this.tlocrt.addKomponente(klima);
		
		/*Korisnik read = new Korisnik(1, "Ksenija", "Prcic", null, 
				Pol.zenski, TipKorisnika.read, new Adresa("Bulevar Kralja Petra I", 36, 
						new Mesto(21000, "Novi Sad")));
		Korisnik write = new Korisnik(2, "Sonja", "Prcic", null, 
				Pol.zenski, TipKorisnika.readWrite, new Adresa("Bulevar Kralja Petra I", 36, 
						new Mesto(21000, "Novi Sad")));*/
		
		//Nalog ks = new Nalog("ksenijaMafija", "ksenija123", Konstante.TLOCRT1, read);
		//Nalog msp = new Nalog("msp", "msp", Konstante.TLOCRT1, write);
		
		this.app = new Aplikacija();
		//this.app.addNalozi(ks);
		//this.app.addNalozi(msp);
		this.app.setTlocrt(this.tlocrt);
	}
} 
