package Structure;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

//Un chemin est un ensemble d'ar�tes entre une source et une destination
//On peut :
//- Cr�er un chemin vide
//- Obtenir la longueur du chemin
//- Ajouter une ar�te compatible � la fin du chemin
//- Concat�ner un chemin � la fin du chemin
//- Obtenir le chemin inverse
class Chemin {
 protected ArrayList<Arete> aretes;
 private Sommet source;
 private Sommet destination;

 // Le chemin vide est quand m�me d�fini au niveau d'un sommet
 public Chemin(Sommet s) {
	aretes = new ArrayList<Arete>();
	source = s;
	destination = s;
 }

 // La longueur est la somme des poids des chemins
 public int longueur() {
	int l = 0;
	for(Arete a : aretes) {
	    l += a.getPoids();
	}
	return l;
 }

 // Ajout d'une ar�te � la fin du chemin
 // - renvoie vraie si l'ar�te est compatible
 // - renvoie faux (et ne fait rien) sinon
 public boolean ajouteArete(Arete a) {
	if (a.admetExtremite(destination)) {
	    aretes.add(a);
	    destination = a.autreExtremite(destination);
	    return true;
	}
	return false;
 }

 // Concat�nation d'un chemin � la fin du chemin, renvoie un bool�en
 // comme l'ajout d'ar�te
 public boolean concatene(Chemin c) {
	if (c.source != this.destination) return false;
	for (Arete a : aretes) {
	    this.ajouteArete(a);
	}
	return true;
 }

 // Construit un (nouveau) chemin renvers�
 public Chemin rev() {
	Chemin c = new Chemin(destination);
	for (int i=aretes.size()-1; i>=0; i--) {
	    c.ajouteArete(aretes.get(i));
	}
	return c;
 }

}
