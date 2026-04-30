package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	
	private Partita partita;
	private Stanza stanza;
	private Stanza stanzaVincente;
	
	@BeforeEach
	public void setUp() {
		partita = new Partita();
		stanza = new Stanza("Stanza");
		stanzaVincente = partita.getStanzaVincente();
	}
	
	/* Test per metodo isFinita */
	
	@Test
	public void testIsFinitaSetFinita() {
		
		partita.setFinita();
		
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinitaQuandoCfuFiniti() {
		
		partita.getGiocatore().setCfu(0);;
		
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinitaVinta() {
		
		partita.setStanzaCorrente(partita.getStanzaVincente());
		
		assertTrue(partita.isFinita());
	}
	
	/* Test per metodo vinta */
	
	@Test
	public void testVinta() {
		
		partita.setStanzaCorrente(partita.getStanzaVincente());
		
		assertTrue(partita.vinta());
	}
	
	@Test
	public void testVintaStart() {
		
		assertFalse(partita.vinta());
	}
	
	@Test
	public void testNonVinta() {
		
		partita.setStanzaCorrente(stanza);
		
		assertFalse(partita.vinta());
	}
	
	/* Test per metodo setStanzaCorrente */
	
	@Test
	public void testSetStanzaCorrente() {
		
		partita.setStanzaCorrente(stanza);
		
		assertEquals(stanza, partita.getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaCorrenteNotNull() {
		
		partita.setStanzaCorrente(stanza);
		
		assertNotNull(partita.getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaCorrenteNull() {
		
		partita.setStanzaCorrente(null);
		
		assertNull(partita.getStanzaCorrente());
	}
	
	/* Test per metodo getStanzaCorrente */
	
	@Test
	public void testGetStanzaCorrente() {
		
		assertNotNull(partita.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaCorrenteNuova() {
		Stanza nuovaStanza = new Stanza("nuovaStanza");
		
		partita.setStanzaCorrente(nuovaStanza);
		
		assertEquals(nuovaStanza, partita.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaCorrenteInizio() {
		
		assertEquals(partita.getStanzaCorrente().getNome(), "Atrio");
	}
}
