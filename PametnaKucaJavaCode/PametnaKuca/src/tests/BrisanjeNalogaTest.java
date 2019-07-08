package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Aplikacija;
import model.korisnik.Korisnik;
import model.korisnik.Nalog;

public class BrisanjeNalogaTest {

	Aplikacija app;
	
	@Before
	public void before() {
		app = new Aplikacija();
		app.addNalozi(new Nalog("JelisavetaRadic", "jel-rad3", "tlocrt.bin", new Korisnik()));
		app.addNalozi(new Nalog("IvanaRadic", "iva-rad2", "tlocrt.bin", new Korisnik()));
	}
	
	@Test
	public void testRemoveNalozi() {
		Nalog m = app.getNalog("JelisavetaRadic");
		app.removeNalozi(m);
		System.out.println(app.getNalozi().size());
		assertNotEquals(2,app.getNalozi().size());
	}

}
