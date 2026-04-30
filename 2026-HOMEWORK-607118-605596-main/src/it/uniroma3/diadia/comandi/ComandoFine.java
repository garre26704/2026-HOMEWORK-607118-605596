package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoFine implements Comando {
    private IO io;
    private final static String NOME = "fine";

    @Override
    public void esegui(Partita partita) {
        this.io.mostraMessaggio("Grazie di aver giocato!"); 
        partita.setFinita();
    }

    @Override public void setParametro(String parametro) {}
    @Override public String getNome() { return NOME; }
    @Override public String getParametro() { return null; }
    public void setIO(IO io) { this.io = io; }
}