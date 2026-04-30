package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	
	private Borsa borsa;
	private Attrezzo osso;
	private Attrezzo lanterna;
	
	@BeforeEach
	public void setUp() {
		borsa = new Borsa(10);
		osso = new Attrezzo("osso", 1);
		lanterna = new Attrezzo("lanterna", 3);
	}
	
	/* Test per isEmpty */
	
	@Test
	public void testBorsaIsEmpty() {
		
		assertTrue(borsa.isEmpty());
	}
	
	@Test 
	public void testBorsaIsNotEmpty() {
		borsa.addAttrezzo(osso);
		
		assertFalse(borsa.isEmpty());
	}
	
	@Test
	public void testBorsaIsEmptyDopoRemove() {
		borsa.addAttrezzo(osso);
		borsa.removeAttrezzo("osso");
		
		assertTrue(borsa.isEmpty());
	}
	
	/* Test per removeAttrezzo */
	
	@Test 
	public void testRemoveAttrezzo() {
		borsa.addAttrezzo(lanterna);
		borsa.removeAttrezzo("lanterna");
		
		assertFalse(borsa.hasAttrezzo("lanterna"));
	}
	
	@Test 
	public void testRemoveAttrezzoNonPresente() {
		Borsa borsetta = new Borsa();
		
		assertNull(borsetta.removeAttrezzo("lanterna"));
	}

	@Test
	public void testRemoveAttrezzoPresente() {
		borsa.addAttrezzo(osso);
		
		assertNotNull(borsa.removeAttrezzo("osso"));
	}
	
	/* Test per getPeso */
	
	@Test
	public void testGetPesoTotale() {
		borsa.addAttrezzo(lanterna);
		borsa.addAttrezzo(osso);
		
		assertEquals(4, borsa.getPeso());
	}
	
	@Test
	public void testGetPesoZero() {
		borsa.addAttrezzo(lanterna);
		borsa.removeAttrezzo("lanterna");
		
		assertEquals(0, borsa.getPeso());
	}
	
	@Test
	public void testGetPesoOsso() {
		borsa.addAttrezzo(osso);
		
		assertEquals(1, borsa.getPeso());
	}
	
	/* Test per hasAttrezzo */
	
	@Test
	public void testHasAttrezzo() {
		borsa.addAttrezzo(lanterna);
		
		assertTrue(borsa.hasAttrezzo("lanterna"));
	}
	
	@Test
	public void testHasAttrezzoNonPresente() {
		borsa.addAttrezzo(lanterna);
		
		assertFalse(borsa.hasAttrezzo("osso"));
	}
	
	@Test
	public void testHasAttrezzoTuttiGliAttrezziPresenti() {
		borsa.addAttrezzo(lanterna);
		borsa.addAttrezzo(osso);
		
		assertTrue(borsa.hasAttrezzo("lanterna"));
		assertTrue(borsa.hasAttrezzo("osso"));
	}
	
	/* Test per getAttrezzo */
	
	@Test
	public void testGetAttrezzo() {
		borsa.addAttrezzo(lanterna);
		
		assertEquals(lanterna, borsa.getAttrezzo("lanterna"));
	}
	
	@Test
	public void testGetAttrezzoNonPresente() {
		borsa.addAttrezzo(lanterna);
		
		assertNull(borsa.getAttrezzo("osso"));
	}
	
	@Test
	public void testGetAttrezzoPresente() {
		borsa.addAttrezzo(osso);
		
		assertEquals(osso, borsa.getAttrezzo("osso"));
		assertNotNull(borsa.getAttrezzo("osso"));
	}
	
	/* Test per addAttrezzo */
	
	@Test
	public void testAddAttrezzo() {
		borsa.addAttrezzo(lanterna);
		
		assertFalse(borsa.isEmpty());
	}
	
	@Test
	public void testAddAttrezzoOltreLimiteDiPeso() {
		Attrezzo nuovoAttrezzo = new Attrezzo("nuovoAttrezzo", 11);
		
		assertFalse(borsa.addAttrezzo(nuovoAttrezzo));
	}
	
	@Test
	public void testAddAttrezzoNeiLimitiDiPeso() {
		
		assertTrue(borsa.addAttrezzo(lanterna));
		assertTrue(borsa.addAttrezzo(osso));
	}
}