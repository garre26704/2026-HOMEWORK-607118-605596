package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {
	
	private Labirinto labirinto;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	@BeforeEach
	public void setUp() {
		labirinto = new Labirinto();
		stanzaIniziale = labirinto.getStanzaIniziale();
		stanzaVincente = labirinto.getStanzaVincente();
	}
	
	/* Test per Stanza Iniziale  e Stanza Vincente*/
	
	@Test
	public void testStanzaInizialeEsistente() {
		assertNotNull(stanzaIniziale);
		assertEquals("Atrio", stanzaIniziale.getNome());
	}
	
	@Test
	public void testStanzaInizialeFalsa() {
		
		assertNotEquals("Laboratorio Campus", stanzaIniziale.getNome());
	}
	
	@Test
	public void testStanzaVincente() {
		assertNotNull(stanzaVincente);
		assertEquals("Biblioteca", stanzaVincente.getNome());
	}
	
	/* Test per stanze vicine */
	
	@Test
	public void testStanzaEstdiStanzaIniziale() {
		
		assertNotNull(stanzaIniziale.getStanzaAdiacente("est"));
		assertEquals("Aula N11", stanzaIniziale.getStanzaAdiacente("est").getNome());
		
	}
	
	@Test
	public void testStanzaOvestdiStanzaIniziale() {
		
		assertNotNull(stanzaIniziale.getStanzaAdiacente("ovest"));
		assertEquals("Laboratorio Campus", stanzaIniziale.getStanzaAdiacente("ovest").getNome());
		
	}
	
	@Test
	public void testStanzaSuddiStanzaVincente() {
		
		assertNotNull(stanzaIniziale.getStanzaAdiacente("sud"));
		assertEquals("Atrio", stanzaVincente.getStanzaAdiacente("sud").getNome());
		
	}
	
	/* Test per verificare presenza degli attrezzi nelle stanze */
	
	@Test
	public void testAttrezziPresentiInAtrio() {
		
		assertTrue(stanzaIniziale.hasAttrezzo("osso"));
		assertFalse(stanzaIniziale.hasAttrezzo("lanterna"));
		
	}
	
	@Test
	public void testAttrezziPresentiInAulaN10() {
		Stanza aulaN10 = stanzaIniziale.getStanzaAdiacente("sud");
		
		assertTrue(aulaN10.hasAttrezzo("lanterna"));
		assertFalse(aulaN10.hasAttrezzo("osso"));
	}
	
	@Test
	public void testAttrezziPresenti() {
		Stanza aulaN10 = stanzaIniziale.getStanzaAdiacente("sud");
		
		assertEquals("lanterna", aulaN10.getAttrezzo("lanterna").getNome());
	}

}
