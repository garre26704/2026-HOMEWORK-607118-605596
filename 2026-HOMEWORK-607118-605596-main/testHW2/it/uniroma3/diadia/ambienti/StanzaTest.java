package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	
	private Stanza stanza;
	private Stanza stanzaAdiacente;
	private Stanza altraStanza;
	private Attrezzo osso;
	private Attrezzo lanterna;
	
	@BeforeEach
	public void setUp() {
		stanza = new Stanza("stanza");
		stanzaAdiacente = new Stanza("stanzaAdiacente");
		altraStanza = new Stanza("altraStanza");
		
		osso = new Attrezzo("osso", 1);
		lanterna = new Attrezzo("lanterna", 3);
	}

	/* Test per impostaStanzaAdiacente */
	
	@Test
	public void testImpostaStanzaAdiacenteEst() {
		
		altraStanza.impostaStanzaAdiacente("est", stanzaAdiacente);
		assertEquals(altraStanza.getStanzaAdiacente("est"), stanzaAdiacente);
	}
	
	@Test
	public void testImpostaStanzaAdiacenteSud() {
		
		stanza.impostaStanzaAdiacente("sud", altraStanza);
		assertEquals(stanza.getStanzaAdiacente("sud"), altraStanza);
	}

	@Test
	public void testImpostaStanzaAdiacenteNull() {
		
		stanza.impostaStanzaAdiacente("destra", altraStanza);
		assertNull(stanza.getStanzaAdiacente("est"));
	}
	
	/* Test per getStanzaAdiacente */
	
	@Test
	public void testGetStanzaAdiacenteEsistente() {
		
		stanza.impostaStanzaAdiacente("ovest", altraStanza);
		assertNotNull(stanza.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacenteNonEsistente() {
		
		stanza.impostaStanzaAdiacente("sud", altraStanza);
		assertNull(stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteNord() {
		
		stanza.impostaStanzaAdiacente("Nord", altraStanza);
		assertEquals(stanza.getStanzaAdiacente("Nord"), altraStanza);
	}
	
	/* Test per addAttrezzo */
	
	@Test
	public void testAddAttrezzoOsso() {
	
		assertTrue(stanza.addAttrezzo(osso));
	}
	
	@Test
	public void testAddAttrezzoLanterna() {
	
		assertTrue(stanza.addAttrezzo(lanterna));
	}

	@Test
	public void testAddAttrezzoLanternaPesoDiverso() {
		Attrezzo lanterna = new Attrezzo("lanterna", 1);
		
		assertTrue(stanza.addAttrezzo(lanterna));
	}
	
	/*Test per hasAttrezzo */
	
	@Test
	public void testHasAttrezzo() {
		stanza.addAttrezzo(osso);
		
		assertTrue(stanza.hasAttrezzo("osso"));
	}
	
	@Test
	public void testHasAttrezzoNonPresente() {
		stanza.addAttrezzo(osso);
		
		assertFalse(stanza.hasAttrezzo("lanterna"));
	}
	
	@Test
	public void testHasAttrezzoEntrambiAttrezziPresenti() {
		stanza.addAttrezzo(osso);
		stanza.addAttrezzo(lanterna);
		
		assertTrue(stanza.hasAttrezzo("lanterna"));
		assertTrue(stanza.hasAttrezzo("osso"));
	}
	
	/* Test per getAttrezzo */
	
	@Test
	public void testGetAttrezzo() {
		stanza.addAttrezzo(lanterna);
		
		assertEquals(lanterna, stanza.getAttrezzo("lanterna"));
	}
	
	@Test
	public void testGetAttrezzoNonPresente() {
		stanza.addAttrezzo(lanterna);
		
		assertNull(stanza.getAttrezzo("osso"));
	}
	
	@Test
	public void testGetAttrezzoEntrambiGliAttrezziPresenti() {
		stanza.addAttrezzo(lanterna);
		stanza.addAttrezzo(osso);
		
		assertEquals(lanterna, stanza.getAttrezzo("lanterna"));
		assertNotNull(stanza.getAttrezzo("osso"));
	}
	
	/* Test per removeAttrezzo */
	
	@Test
	public void testRemoveAttrezzo() {
		stanza.addAttrezzo(lanterna);
		stanza.removeAttrezzo(lanterna);
		
		assertFalse(stanza.hasAttrezzo("lanterna"));
	}
	
	@Test
	public void testRemoveAttrezzoNonPresente() {
		stanza.addAttrezzo(lanterna);
		
		assertFalse(stanza.removeAttrezzo(osso));
	}
	
	@Test
	public void testRemoveAttrezzoConDueAttrezzi() {
		stanza.addAttrezzo(lanterna);
		stanza.addAttrezzo(osso);
		stanza.removeAttrezzo(lanterna);
		
		assertFalse(stanza.hasAttrezzo("lanterna"));
		assertTrue(stanza.hasAttrezzo("osso"));
	}
	
	/* Test per getDirezioni */
	
	@Test
	public void testGetDirezioniZeroDirezioni() {
		
		assertEquals(0, stanza.getDirezioni().length);
	}
	
	@Test
	public void testGetDirezioniUnaDirezione() {
		
		stanza.impostaStanzaAdiacente("est", stanzaAdiacente);
		assertEquals(1, stanza.getDirezioni().length);
	}

	@Test
	public void testGetDirezioniDueDirezioni() {
		
		stanza.impostaStanzaAdiacente("est", altraStanza);
		stanza.impostaStanzaAdiacente("sud", stanzaAdiacente);
		assertEquals(2, stanza.getDirezioni().length);
	}
}