package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoPosa implements Comando {
    private IO io;
    private String nomeAttrezzo;
    private final static String NOME = "posa";

    @Override
    public void esegui(Partita partita) {
        if (nomeAttrezzo == null) {
            this.io.mostraMessaggio("Cosa vuoi posare?");
            return;
        }
        
        Borsa borsa = partita.getGiocatore().getBorsa();
        Attrezzo attrezzo = borsa.removeAttrezzo(nomeAttrezzo);
        
        if (attrezzo == null) {
            this.io.mostraMessaggio("L'attrezzo non è nella borsa");
            return;
        } else {
            partita.getStanzaCorrente().addAttrezzo(attrezzo);
            this.io.mostraMessaggio("Hai posato l'attrezzo " + nomeAttrezzo);
        }
    }

    @Override public void setParametro(String parametro) { this.nomeAttrezzo = parametro; }
    @Override public String getNome() { return NOME; }
    @Override public String getParametro() { return this.nomeAttrezzo; }
    @Override public void setIO(IO io) { this.io = io; }
}