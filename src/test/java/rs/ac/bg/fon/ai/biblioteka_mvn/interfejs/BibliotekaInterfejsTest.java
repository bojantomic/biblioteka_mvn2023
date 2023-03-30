package rs.ac.bg.fon.ai.biblioteka_mvn.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import rs.ac.bg.fon.ai.biblioteka_mvn.Knjiga;


public abstract class BibliotekaInterfejsTest {

	protected BibliotekaInterfejs biblioteka;

	@Test
	void testDodajKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn(123);
		
		biblioteka.dodajKnjigu(k);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(1, knjige.size());
		assertTrue(knjige.contains(k));
	}
	
	@Test
	@DisplayName("Provera da nije dozvoljeno unosenje duple knjige")
	void testDodajKnjiguDuplikat() {
		Knjiga k = new Knjiga();
		k.setIsbn(123);
		
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(123);
		
		assertThrows(IllegalArgumentException.class,
				() -> biblioteka.dodajKnjigu(k2) );
	}
	
	@Test
	void testDodajKnjiguNull() {
		assertThrows(NullPointerException.class,
				() -> biblioteka.dodajKnjigu(null) );
	}

	@Test
	void testObrisiKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn(123);
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(456);
		biblioteka.dodajKnjigu(k2);
		
		Knjiga k3 = new Knjiga();
		k3.setIsbn(123);
		
		biblioteka.obrisiKnjigu(k3);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(1, knjige.size());
		assertTrue( knjige.contains(k2) );
	}
	
	@Test
	void testObrisiKnjiguNePostoji() {
		Knjiga k = new Knjiga();
		k.setIsbn(123);
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(456);
		biblioteka.dodajKnjigu(k2);
		
		Knjiga k3 = new Knjiga();
		k3.setIsbn(999);
		
		biblioteka.obrisiKnjigu(k3);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(2, knjige.size());
		assertTrue( knjige.contains(k2) );
		assertTrue( knjige.contains(k) );
	}
	
	@Test
	void testObrisiKnjiguNull() {
		Knjiga k = new Knjiga();
		k.setIsbn(123);
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(456);
		biblioteka.dodajKnjigu(k2);
		
		biblioteka.obrisiKnjigu(null);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(2, knjige.size());
		assertTrue( knjige.contains(k2) );
		assertTrue( knjige.contains(k) );
	}

	@Test
	@DisplayName ("Nijedan argument za pretrazivanje nije unet")
	void testPronadjiKnjiguSveNull() {
		assertThrows(IllegalArgumentException.class,
				() -> biblioteka.pronadjiKnjigu(null, -1, null, null));
	}
	
	@Test
	void testPronadjiKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn(123);
		k.setNaslov("Gospodar prstenova");
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(456);
		k2.setNaslov("Prohujalo sa vihorom");
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> knjige = 
				biblioteka.pronadjiKnjigu(null, -1, "VIH" , null);
		
		assertEquals(1, knjige.size());
		assertTrue( knjige.contains(k2) );
	}
	
	@Test
	void testPronadjiKnjiguViseKnjiga() {
		Knjiga k = new Knjiga();
		k.setIsbn(123);
		k.setNaslov("Gospodar prstenova");
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(456);
		k2.setNaslov("Prohujalo sa vihorom");
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> knjige = 
				biblioteka.pronadjiKnjigu(null, -1, "PR" , null);
		
		assertEquals(2, knjige.size());
		assertTrue( knjige.contains(k2) );
		assertTrue( knjige.contains(k) );
	}
	
	@Test
	@Timeout (value = 5, unit = TimeUnit.SECONDS)
	void testPronadjiKnjiguNemaRezultata() {
		Knjiga k = new Knjiga();
		k.setIsbn(123);
		k.setNaslov("Gospodar prstenova");
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(456);
		k2.setNaslov("Prohujalo sa vihorom");
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> knjige = 
				biblioteka.pronadjiKnjigu(null, -1, "Pera" , null);
		
		assertEquals(0, knjige.size());
	}
	


}
