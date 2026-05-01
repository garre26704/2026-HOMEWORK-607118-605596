package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {
    private List<String> righeDaLeggere; // I comandi che il test "invia" al gioco
    private int indiceRigaCorrente;
    private List<String> messaggiProdotti; // I messaggi che il gioco "stampa"

    public IOSimulator(List<String> righeDaLeggere) {
        this.righeDaLeggere = righeDaLeggere;
        this.indiceRigaCorrente = 0;
        this.messaggiProdotti = new ArrayList<>();
    }

    @Override
    public String leggiRiga() {
        String riga = this.righeDaLeggere.get(indiceRigaCorrente);
        this.indiceRigaCorrente++;
        return riga;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        this.messaggiProdotti.add(messaggio);
    }

    // Metodo utile per i test per verificare cosa ha risposto il gioco
    public String getMessaggio(int i) {
        return this.messaggiProdotti.get(i);
    }
    
    public List<String> getMessaggiProdotti() {
        return this.messaggiProdotti;
    }
}