package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.IO;

public class ComandoVai implements Comando {
    private String direzione;
    private final static String NOME = "vai";
    private IO io;
    
    @Override
    public void esegui(Partita partita) {
        // Supponendo che tu abbia aggiunto un campo privato 'io' alla classe
        if (this.direzione == null) {
            this.io.mostraMessaggio("Dove vuoi andare?"); 
            return;
        }

        Stanza stanzaCorrente = partita.getStanzaCorrente();
        Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);

        if (prossimaStanza == null) {
            this.io.mostraMessaggio("Direzione inesistente"); 
            return;
        }

        partita.setStanzaCorrente(prossimaStanza);
        int cfu = partita.getGiocatore().getCfu();
        partita.getGiocatore().setCfu(cfu - 1);
        
        this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione()); 
    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }

    @Override
    public String getNome() { return NOME; }

    @Override
    public String getParametro() { return this.direzione; }

    @Override
    public void setIO(IO io){this.io=io;}
}