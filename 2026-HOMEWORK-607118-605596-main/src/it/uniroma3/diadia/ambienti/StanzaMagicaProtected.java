package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {
    private int contatoreAttrezziPosati;
    private int sogliaMagica;

    public StanzaMagicaProtected(String nome, int soglia) {
        super(nome);
        this.contatoreAttrezziPosati = 0;
        this.sogliaMagica = soglia;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        this.contatoreAttrezziPosati++;
        if (this.contatoreAttrezziPosati > this.sogliaMagica) {
            attrezzo = this.modificaAttrezzo(attrezzo);
        }
        
        // Accesso diretto grazie a 'protected'
        if (this.numeroAttrezzi < 10) { 
            this.attrezzi[numeroAttrezzi] = attrezzo;
            this.numeroAttrezzi++;
            return true;
        }
        return false;
    }

    private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
        String nuovoNome = new StringBuilder(attrezzo.getNome()).reverse().toString();
        int nuovoPeso = attrezzo.getPeso() * 2;
        return new Attrezzo(nuovoNome, nuovoPeso);
    }
}