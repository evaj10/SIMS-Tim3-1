package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Aplikacija;
import model.korisnik.Korisnik;
import model.korisnik.Nalog;

public class LogovanjeTest {
	Aplikacija app;
	
	@Before
	public void before() {
		app = new Aplikacija();
		app.addNalozi(new Nalog("JelisavetaRadic", "jel-rad3", "tlocrt.bin", new Korisnik()));
		app.addNalozi(new Nalog("IvanaRadic", "iva-rad2", "tlocrt.bin", new Korisnik()));
	}
	
	@Test
	public void testLogIn() {
		assertTrue(app.logIn("IvanaRadic", "iva-rad2"));
	}

}
