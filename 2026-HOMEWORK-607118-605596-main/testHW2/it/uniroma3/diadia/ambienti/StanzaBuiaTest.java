package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia stanza;
	private Attrezzo lanterna;

	@Before
	public void setUp() {
		// Creiamo una stanza buia che richiede una "lanterna" per vedere
		stanza = new StanzaBuia("StanzaScura", "lanterna");
		lanterna = new Attrezzo("lanterna", 1);
	}

	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		// Senza lanterna deve restituire il messaggio di buio
		String messaggioBuio = "qui c'è un buio pesto";
		assertEquals(messaggioBuio, stanza.getDescrizione());
	}

	@Test
	public void testGetDescrizioneConAttrezzo() {
		// Aggiungendo la lanterna, deve restituire la descrizione completa
		stanza.addAttrezzo(lanterna);
		assertNotEquals("qui c'è un buio pesto", stanza.getDescrizione());
		assertTrue(stanza.getDescrizione().contains("StanzaScura"));
	}
}