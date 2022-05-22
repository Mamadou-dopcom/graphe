package Structure;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

//Un sommet possède un nom et une couleur.
//On peut :
//- Créer un sommet
//- Lui ajouter des arêtes incidentes
//- Obtenir sa composante connexe
//- Lui donner une couleur
//Ici, les sommets représentent aussi des composantes connexes, on
//peut donc encore :
//- Unir la composante d'un sommet avec celle d'un autre sommet
class Sommet {
 private String nom;
 private int couleur;
 // Je croyais que j'avais besoin de cet attribut mais à l'heure
 // actuelle il n'est pas utilisé...
 private Graphe graphe;
 // Le dominant est le père du sommet considéré dans la structure Union-Find
 private Sommet dominant;
 // Le rang est une borne sur la hauteur de la structure Union-Find
 private int rang=0;
 // Ensemble des arêtes incidentes
 private Set<Arete> incidences;
 // Les sommets accessibles sont représentés par une table associant
 // chaque sommet accessible à un chemin.
 // On veut que le chemin mémorisé soit le plus court.
 // On pourrait obtenir une représentation plus compacte en mémorisant
 // moins d'information : pour les besoins des méthodes du TP il suffirait
 // d'avoir la longueur du chemin et sa première arête.
 private Map<Sommet, Chemin> accessibles;
 
 public Sommet(Graphe g, String n) {
	graphe = g;
	nom = n;
	dominant = this;
	// Un sommet est créé sans arêtes incidentes.
	// Le seul sommet accessible est lui-même, via le chemin vide.
	incidences = new HashSet<Arete>();
	accessibles = new HashMap<Sommet, Chemin>();
	accessibles.put(this, new Chemin(this));
 }

 // Ajout d'une arête incidente.
 // Pour mettre à jour l'ensemble des sommets accessible dans le graphe,
 // il faut prendre tous les sommets accessibles depuis le sommet actuel,
 // tous les sommets accessibles depuis le sommet cible, et comparer le
 // nouveau chemin créé avec le meilleur chemin qui existait déjà.
 public void ajouteArete(Arete a) {
	incidences.add(a);
	for(Map.Entry<Sommet, Chemin> accS1 : this.accessibles.entrySet()) {
	    for(Map.Entry<Sommet, Chemin> accS2 :
		    a.autreExtremite(this).accessibles.entrySet()) {
		// À compléter...
		// On construit le nouveau chemin entre deux extrémités,
		// on le compare à l'éventuel chemin déjà existant, et on
		// garde le plus court.
	    }
	}
 }

 // Un sommet est bien coloré s'il n'a pas la même couleur que ses voisins.
 public boolean bienColore() {
	for (Arete a : incidences) {
	    if (a.autreExtremite(this).couleur == this.couleur) return false;
	}
	return true;
 }

 // Affecte à un sommet la plus petite couleur pas déjà prise par ses
 // voisins.
 public int colorie() {
	this.couleur = 0;
	while (!this.bienColore()) this.couleur++;
	return this.couleur;
 }
 
 // Donne le sommet représentant la composante connexe à laquelle
 // appartient [this].
 public Sommet composante() {
	if (dominant != this) {
	    // Cette mise à jour correspond à l'optimisation
	    // "compression de chemins".
	    dominant = dominant.composante();
	}
	return dominant;
 }

 // Fait l'union de deux composantes connexes.
 // Pré-condition : [this] et [s] doivent être chacun le représentant
 // de sa composante connexe (c'est-à-dire la racine de l'arbre
 // correspondant dans la structure Union-Find), sans quoi la structure
 // de données serait corrompue.
 // Remarque : pas forcément malin de donner une pré-condition si critique
 // à une méthode qui n'est pas privée. Il serait plus raisonnable de
 // d'abord appliquer la méthode [composante()].
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