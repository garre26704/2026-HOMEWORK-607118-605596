package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GiocatoreTest {
	
	/* Test per getCfu */
	
	@Test
	public void testGetCfuIniziali() {
		Giocatore giocatore = new Giocatore(20);
		
		assertEquals(20, giocatore.getCfu());
	}
	
	@Test
	public void testGetCfuNonIniziali() {
		Giocatore giocatore = new Giocatore(5);
		
		assertEquals(5, giocatore.getCfu());
		assertNotNull(giocatore.getCfu());
	}
	
	@Test
	public void testGetCfuFiniti() {
		Giocatore giocatore = new Giocatore(0);
		
		assertEquals(0, giocatore.getCfu());
	}
	
	/* Test per setCfu */
	
	@Test
	public void testSetCfu() {
		Giocatore giocatore = new Giocatore(1);
		
		giocatore.setCfu(3);
		
		assertEquals(3, giocatore.getCfu());
	}
	
	@Test
	public void testSetCfuIniziali() {
		Giocatore giocatore = new Giocatore(0);
		
		giocatore.setCfu(20);
		
		assertEquals(20, giocatore.getCfu());
	}
	
	@Test
	public void testSetCfuFiniti() {
		Giocatore giocatore = new Giocatore(20);
		
		giocatore.setCfu(0);
		
		assertEquals(0, giocatore.getCfu());
	}
	
	/* Test per getBorsa */
	
	@Test 
	public void testGetBorsa() {
		Giocatore giocatore = new Giocatore(15);
		
		assertNotNull(giocatore.getBorsa());		
	}
	
	@Test 
	public void testGetBorsaDopoSetCfu() {
		Giocatore giocatore = new Giocatore(0);
		
		giocatore.setCfu(10);
		
		assertNotNull(giocatore.getBorsa());
	}
	
	@Test
	public void testGetBorsaUguali() {
		Giocatore giocatore = new Giocatore(10);
		
		Borsa borsaA = giocatore.getBorsa();
		Borsa borsaB = giocatore.getBorsa();
		
		assertEquals(borsaA, borsaB);
	}
}