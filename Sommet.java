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
 private int nom;

 // Je croyais que j'avais besoin de cet attribut mais � l'heure
 // actuelle il n'est pas utilis�...
 private Graphe graphe;
 
 public Sommet(Graphe g, int n) {
	graphe = g;
	nom = n;
	
 }



public int getNom() {
	return nom;
}

public void setNom(int nom) {
	this.nom = nom;
}

@Override
public String toString() {
	return "Sommet [nom=" + this.getNom() + "]";
}
 

 
}