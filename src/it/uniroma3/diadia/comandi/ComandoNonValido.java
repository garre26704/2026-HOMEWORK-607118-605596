package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoNonValido implements Comando {
    private IO io;

    @Override
    public void esegui(Partita partita) {
        this.io.mostraMessaggio("Comando sconosciuto"); 
    }

    @Override public void setParametro(String parametro) {}
    @Override public String getNome() { return "sconosciuto"; }
    @Override public String getParametro() { return null; }
    public void setIO(IO io) { this.io = io; }
}