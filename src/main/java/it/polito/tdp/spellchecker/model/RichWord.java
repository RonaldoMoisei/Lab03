package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String parole;
	private boolean corretto;
	
	
	public RichWord(String parole, boolean corretto) {
		this.parole = parole;
		this.corretto = corretto;
	}
	
	
	public String getParole() {
		return parole;
	}
	public void setParole(String parole) {
		this.parole = parole;
	}
	public boolean isCorretto() {
		return corretto;
	}
	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}
	
	

}
