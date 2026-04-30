package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata stanza;
	private Stanza adiacente;
	private Attrezzo chiave;

	@Before
	public void setUp() {
		// Creiamo una stanza bloccata a nord che richiede una "chiave"[cite: 1]
		stanza = new StanzaBloccata("StanzaBloccata", "nord", "chiave");
		adiacente = new Stanza("Biblioteca");
		chiave = new Attrezzo("chiave", 1);
		stanza.impostaStanzaAdiacente("nord", adiacente);
	}

	@Test
	public void testGetStanzaAdiacenteSenzaChiave() {
		// Senza chiave a terra, deve ritornare la stanza stessa (rimbalzo)[cite: 1]
		assertEquals(stanza, stanza.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetStanzaAdiacenteConChiave() {
		// Posando la chiave, deve permettere il passaggio alla stanza adiacente[cite: 1]
		stanza.addAttrezzo(chiave);
		assertEquals(adiacente, stanza.getStanzaAdiacente("nord"));
	}
}