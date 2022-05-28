
package Structure;

import java.util.Objects;

public class Ensemble {
	
	Integer representant;
	ListeChaineeSimple listeChaineeS ;

	
	public Ensemble() {
		representant=null;
		listeChaineeS=new ListeChaineeSimple();
	}
	
	public Ensemble(int x,ListeChaineeSimple listeChaineeS) {
		representant=x;
		listeChaineeS = listeChaineeS;
	}
	
	public Ensemble(int x) {
		representant=x;
		listeChaineeS= new ListeChaineeSimple();
		listeChaineeS.insererEnTete(x);
	}

	
	public void insererEnQueue(int x) {
		// Cas où la liste est vide
		if (representant==(Integer)null) { 
			representant = x;
			listeChaineeS.insererEnQueue(x);
		}
		else 
			listeChaineeS.insererEnQueue(x);
	}
	
	public int getTete() {
		return representant;
	}

	public void setTete(int tete) {
		this.representant = tete;
	}

	public ListeChaineeSimple getListeChaineeS() {
		return listeChaineeS;
	}

	public void setListeChaineeS(ListeChaineeSimple listeChaineeS) {
		this.listeChaineeS = listeChaineeS;
	}

	@Override
	public String toString() {
		return "Ensemble [representant=" + representant + ", listeChaineeS=" + listeChaineeS.toString() + "]";
	}
	
	public void concatener(Ensemble e) {
		this.listeChaineeS.concatener(e.listeChaineeS);
	}

	@Override
	public int hashCode() {
		return Objects.hash(representant);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ensemble other = (Ensemble) obj;
		return Objects.equals(representant, other.representant);
	}

	

	
	
	
}
