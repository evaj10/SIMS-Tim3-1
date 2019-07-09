package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.Aplikacija;
import model.korisnik.Korisnik;
import model.korisnik.Nalog;

public class PostojanjeNalogaTest {
	Aplikacija app;
	
	@Before
	public void before() {
		app = new Aplikacija();
		app.addNalozi(new Nalog("JelisavetaRadic", "jel-rad3", "tlocrt.bin", new Korisnik()));
	}
	
	@Test
	public void testNalogPostoji() {
		assertFalse(app.nalogPostoji("JelisavetaRadic"));
		assertFalse(app.nalogPostoji("KorisnickoIme"));
	}

}
