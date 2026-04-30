package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
/**
 * Interfaccia per la gestione polimorfica dei comandi.
 */
public interface Comando {
    /**
     * Esegue la logica specifica del comando.
     */
    public void esegui(Partita partita);

    /**
     * Imposta il parametro del comando (es. la direzione per 'vai').
     */
    public void setParametro(String parametro);
    
    public void setIO(IO io);

    public String getNome();
    public String getParametro();
}