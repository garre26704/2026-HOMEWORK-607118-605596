package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoAiuto implements Comando {
    private IO io;
    private final static String NOME = "aiuto";
    private static final String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"}; 

    @Override
    public void esegui(Partita partita) {
        for(String s : elencoComandi) {
            this.io.mostraMessaggio(s + " "); 
        }
    }

    @Override public void setParametro(String parametro) {}
    @Override public String getNome() { return NOME; }
    @Override public String getParametro() { return null; }
    public void setIO(IO io) { this.io = io; }
}