package Structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

//Une ar�te a deux extr�mit�s (ordre arbitraire, on regarde des graphes
//non orient�s).
//On peut :
//- Savoir si un sommet est une extr�mit�
//- Obtenir l'autre extr�mit� si on en a d�j� une
//- Obtenir le poids de l'ar�te (par d�faut, 1)
class Arete {
 // On repr�sente les extr�mit�s par un tableau � deux cases
 // Comme souvent ici : c'est une possibilit� parmi d'autres
 private Sommet[] extremites;

 private int poids;

 public Arete(Sommet s1, Sommet s2, int p) {
	// On range les extr�mit� dans l'ordre donn� par les param�tres
	// Variante : on les classe en fonction d'un ordre (pas utile ici)
	extremites = new Sommet[2];
	extremites[0] = s1;
	extremites[1] = s2;
	poids = p;
 }
 // Donne l'autre extr�mit�
 // Pr�-condition : [s] est l'une des extr�mit�s
 public Sommet autreExtremite(Sommet s) {
	if (s == extremites[0]) return extremites[1];
	else return extremites[0];  
 }

 // V�rifie qu'un sommet est une extr�mit�
 public boolean admetExtremite(Sommet s) {
	return (s == extremites[0] || s == extremites[1]);
 	}

 // Renvoie le poind d'une arete
 public int getPoids() { 
	 return poids; }
public Sommet[] getExtremites() {
	return extremites;
}
public void setExtremites(Sommet[] extremites) {
	this.extremites = extremites;
}
public void setPoids(int poids) {
	this.poids = poids;
}
@Override
public String toString() {
	return "Arete: [[" + extremites[0].getNom() + ","+extremites[1].getNom()+ "] poids=" + poids + "]";
}

//public boolean verif()
public int equales(Arete a) {
	if( this.extremites[0].getNom()==a.extremites[0].getNom() && this.extremites[1].getNom()==a.extremites[1].getNom()
			|| a.extremites[0].getNom()==a.extremites[1].getNom())
		return 0;
	else if (this.extremites[0].getNom()==a.extremites[1].getNom() && (this.extremites[1].getNom()==a.extremites[0].getNom())) 
		return 1;
	return 2;
	}

}
