package Structure;

public class Noeud {

	
	private int valeur;
	private Noeud suivant;

	public Noeud(int valeur, Noeud suivant) {
		this.valeur = valeur;
		this.suivant = suivant;
	}
	
	public Noeud(int valeur) {
		this.valeur = valeur;
		this.suivant = null;
	}
	
	
	public int getValeur() { return valeur; }
	
	public Noeud getSuivant() { return suivant; }
	
	public void setSuivant(Noeud n) { this.suivant = n; }
	

	

}
