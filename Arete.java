package Structure;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

//Une arête a deux extrémités (ordre arbitraire, on regarde des graphes
//non orientés).
//On peut :
//- Savoir si un sommet est une extrémité
//- Obtenir l'autre extrémité si on en a déjà une
//- Obtenir le poids de l'arête (par défaut, 1)
class Arete {
 // On représente les extrémités par un tableau à deux cases
 // Comme souvent ici : c'est une possibilité parmi d'autres
 private Sommet[] extremites;

 public Arete(Sommet s1, Sommet s2) {
	// On range les extrémité dans l'ordre donné par les paramètres
	// Variante : on les classe en fonction d'un ordre (pas utile ici)
	extremites = new Sommet[2];
	extremites[0] = s1;
	extremites[1] = s2;
	// On inscrit l'arête dans les listes d'incidence de ses extrémités
	s1.ajouteArete(this);
	s2.ajouteArete(this);
 }

 // Donne l'autre extrémité
 // Pré-condition : [s] est l'une des extrémités
 public Sommet autreExtremite(Sommet s) {
	if (s == extremites[0]) return extremites[1];
	else return extremites[0];  
 }

 // Vérifie qu'un sommet est une extrémité
 public boolean admetExtremite(Sommet s) {
	return (s == extremites[0] || s == extremites[1]);
 }

 // Pour une arête non pondérée, le poids est 1
 public int getPoids() { return 1; }
}

//Une arête pondérée est une arête avec en plus un poids.
class AretePonderee extends Arete {
 private int poids;

 public AretePonderee(Sommet s1, Sommet s2, int p) {
	super(s1, s2);
	poids = p;
 }

 public int getPoids() { return poids; }
}


//Un chemin est un ensemble d'arêtes entre une source et une destination
//On peut :
//- Créer un chemin vide
//- Obtenir la longueur du chemin
//- Ajouter une arête compatible à la fin du chemin
//- Concaténer un chemin à la fin du chemin
//- Obtenir le chemin inverse