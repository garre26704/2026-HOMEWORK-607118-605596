package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoPrendi implements Comando {
    private IO io;
    private String nomeAttrezzo;
    private final static String NOME = "prendi";

    @Override
    public void esegui(Partita partita) {
        if (nomeAttrezzo == null) {
            this.io.mostraMessaggio("Cosa vuoi prendere?");
            return;
        }
        
        Stanza stanza = partita.getStanzaCorrente();
        Attrezzo attrezzo = stanza.getAttrezzo(nomeAttrezzo);
        
        if (attrezzo == null) {
            this.io.mostraMessaggio("L'attrezzo non è nella stanza");
            return;
        }
        
        if (partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
            stanza.removeAttrezzo(attrezzo);
            this.io.mostraMessaggio("Hai preso l'attrezzo: " + nomeAttrezzo);
        } else {
            this.io.mostraMessaggio("Borsa già piena");
        }
    }

    @Override public void setParametro(String parametro) { this.nomeAttrezzo = parametro; }
    @Override public String getNome() { return NOME; }
    @Override public String getParametro() { return this.nomeAttrezzo; }
    @Override public void setIO(IO io) { this.io = io; }
}