package it.uniroma3.diadia.giocatore;

public class Giocatore {
	
	private Borsa borsa;
	private int cfu;
	
	public Giocatore(int cfuIniziali) {
		this.cfu = cfuIniziali;
		this.borsa = new Borsa();
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
}
