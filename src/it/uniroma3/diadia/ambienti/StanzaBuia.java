package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String nomeAttrezzoPerVedere;


	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzoPerVedere = nomeAttrezzo;
	}

	@Override
	public String getDescrizione() {
		if (this.hasAttrezzo(this.nomeAttrezzoPerVedere)) {
			return super.getDescrizione();
		} else {
			return "qui c'è un buio pesto";
		}
	}
}