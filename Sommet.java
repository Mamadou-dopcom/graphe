package Structure;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

//Un sommet poss�de un nom et une couleur.
//On peut :
//- Cr�er un sommet
//- Lui ajouter des ar�tes incidentes
//- Obtenir sa composante connexe
//- Lui donner une couleur
//Ici, les sommets repr�sentent aussi des composantes connexes, on
//peut donc encore :
//- Unir la composante d'un sommet avec celle d'un autre sommet
class Sommet {
 private String nom;
 private int couleur;
 // Je croyais que j'avais besoin de cet attribut mais � l'heure
 // actuelle il n'est pas utilis�...
 private Graphe graphe;
 // Le dominant est le p�re du sommet consid�r� dans la structure Union-Find
 private Sommet dominant;
 // Le rang est une borne sur la hauteur de la structure Union-Find
 private int rang=0;
 // Ensemble des ar�tes incidentes
 private Set<Arete> incidences;
 // Les sommets accessibles sont repr�sent�s par une table associant
 // chaque sommet accessible � un chemin.
 // On veut que le chemin m�moris� soit le plus court.
 // On pourrait obtenir une repr�sentation plus compacte en m�morisant
 // moins d'information : pour les besoins des m�thodes du TP il suffirait
 // d'avoir la longueur du chemin et sa premi�re ar�te.
 private Map<Sommet, Chemin> accessibles;
 
 public Sommet(Graphe g, String n) {
	graphe = g;
	nom = n;
	dominant = this;
	// Un sommet est cr�� sans ar�tes incidentes.
	// Le seul sommet accessible est lui-m�me, via le chemin vide.
	incidences = new HashSet<Arete>();
	accessibles = new HashMap<Sommet, Chemin>();
	accessibles.put(this, new Chemin(this));
 }

 // Ajout d'une ar�te incidente.
 // Pour mettre � jour l'ensemble des sommets accessible dans le graphe,
 // il faut prendre tous les sommets accessibles depuis le sommet actuel,
 // tous les sommets accessibles depuis le sommet cible, et comparer le
 // nouveau chemin cr�� avec le meilleur chemin qui existait d�j�.
 public void ajouteArete(Arete a) {
	incidences.add(a);
	for(Map.Entry<Sommet, Chemin> accS1 : this.accessibles.entrySet()) {
	    for(Map.Entry<Sommet, Chemin> accS2 :
		    a.autreExtremite(this).accessibles.entrySet()) {
		// � compl�ter...
		// On construit le nouveau chemin entre deux extr�mit�s,
		// on le compare � l'�ventuel chemin d�j� existant, et on
		// garde le plus court.
	    }
	}
 }

 // Un sommet est bien color� s'il n'a pas la m�me couleur que ses voisins.
 public boolean bienColore() {
	for (Arete a : incidences) {
	    if (a.autreExtremite(this).couleur == this.couleur) return false;
	}
	return true;
 }

 // Affecte � un sommet la plus petite couleur pas d�j� prise par ses
 // voisins.
 public int colorie() {
	this.couleur = 0;
	while (!this.bienColore()) this.couleur++;
	return this.couleur;
 }
 
 // Donne le sommet repr�sentant la composante connexe � laquelle
 // appartient [this].
 public Sommet composante() {
	if (dominant != this) {
	    // Cette mise � jour correspond � l'optimisation
	    // "compression de chemins".
	    dominant = dominant.composante();
	}
	return dominant;
 }

 // Fait l'union de deux composantes connexes.
 // Pr�-condition : [this] et [s] doivent �tre chacun le repr�sentant
 // de sa composante connexe (c'est-�-dire la racine de l'arbre
 // correspondant dans la structure Union-Find), sans quoi la structure
 // de donn�es serait corrompue.
 // Remarque : pas forc�ment malin de donner une pr�-condition si critique
 // � une m�thode qui n'est pas priv�e. Il serait plus raisonnable de
 // d'abord appliquer la m�thode [composante()].
 protected Sommet union(Sommet s) {
 	if (this.rang > s.rang) {
	    s.dominant = this; return this;
	} else {
	    this.dominant = s;
 	    if (this.rang == s.rang) s.rang++;
	    return s;
	}
 }
 
}