package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
    private String attrezzosbloccante;


	public StanzaBloccata(String nome, String direzione, String attrezzo) {
		super(nome);
		this.direzioneBloccata =direzione;
        this.attrezzosbloccante =attrezzo;
	}

	@Override
	public Stanza getStanzaAdiacente(String dir) {
        if(this.direzioneBloccata.equals(dir) && !this.hasAttrezzo(this.attrezzosbloccante)){
            return this;
        }
        return super.getStanzaAdiacente(dir);
    }
	@Override
	public String getDescrizione() {
		String blocco = "\nAttenzione: l'uscita a " + this.direzioneBloccata + " è bloccata!";
		blocco += "\nTi serve un/una " + this.attrezzosbloccante + " per sbloccarla.";
		
		if (!this.hasAttrezzo(this.attrezzosbloccante)) {
			return super.getDescrizione() + blocco;
		}
		return super.getDescrizione();
	}
}