package tests;

import org.junit.Before;
import org.junit.Test;

import model.Aplikacija;
import model.korisnik.Korisnik;
import model.korisnik.Nalog;
import static org.junit.Assert.*;

public class DodavanjeNalogaTest {

	Aplikacija app;
	
	@Before
	public void before() {
		app = new Aplikacija();
		app.addNalozi(new Nalog("JelisavetaRadic", "jel-rad3", "tlocrt.bin", new Korisnik()));
	}
	
	@Test
	public void testAddNalozi() {
		app.addNalozi(new Nalog("IvanaRadic", "iva-rad2", "tlocrt.bin", new Korisnik()));
		assertEquals(2,app.getNalozi().size());
	}

}
