package Structure;

import java.util.ArrayList;
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

 public Arete(Sommet s1, Sommet s2) {
	// On range les extr�mit� dans l'ordre donn� par les param�tres
	// Variante : on les classe en fonction d'un ordre (pas utile ici)
	extremites = new Sommet[2];
	extremites[0] = s1;
	extremites[1] = s2;
	// On inscrit l'ar�te dans les listes d'incidence de ses extr�mit�s
	s1.ajouteArete(this);
	s2.ajouteArete(this);
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

 // Pour une ar�te non pond�r�e, le poids est 1
 public int getPoids() { return 1; }
}

//Une ar�te pond�r�e est une ar�te avec en plus un poids.
class AretePonderee extends Arete {
 private int poids;

 public AretePonderee(Sommet s1, Sommet s2, int p) {
	super(s1, s2);
	poids = p;
 }

 public int getPoids() { return poids; }
}


//Un chemin est un ensemble d'ar�tes entre une source et une destination
//On peut :
//- Cr�er un chemin vide
//- Obtenir la longueur du chemin
//- Ajouter une ar�te compatible � la fin du chemin
//- Concat�ner un chemin � la fin du chemin
//- Obtenir le chemin inverse