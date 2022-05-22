package Structure;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Graphe {
    // Ensembles de sommets et d'ar�tes, directement repr�sent�s comme tels.
    private Set<Sommet> sommets;
    private Set<Arete> aretes;
    // Une composante connexe est repr�sent�e par un sommet principal
    // Id�e : utiliser l'algorithme Union-Find de Tarjan (dans ce corrig�,
    // il y a au passage les optimisations "union par rangs" et "compression
    // de chemins".
    private Set<Sommet> composantes;
    // Le nombre de composantes pourrait �tre recalcul� � la demande plut�t
    // qu'enregistr�, mais �a ne co�te pas cher.
    private int nbComposantes;

    // Graphe vide : pas de sommets, pas d'ar�tes, pas de composantes.
    public Graphe() {
	sommets = new HashSet<Sommet>();
	aretes = new HashSet<Arete>();
	composantes = new HashSet<Sommet>();
	nbComposantes = 0;
    }

    // Ajout d'un sommet de nom [n]
    public void ajouteSommet(String n) {
	Sommet s = new Sommet(this, n);
	sommets.add(s);
	// Un nouveau sommet cr�e une nouvelle composante
	composantes.add(s);
	nbComposantes++;
    }

    // Ajout d'une ar�te entre deux sommets [s1] et [s2]
    public void ajouteArete(Sommet s1, Sommet s2) {
	Arete a = new Arete(s1, s2);
	aretes.add(a);
	// On r�cup�re les composantes des deux sommets reli�s...
	Sommet sc1 = s1.composante();
	Sommet sc2 = s2.composante();
	// ... si elles �taient diff�rentes, alors on les unit.
	if (sc1 != sc2) {
	    nbComposantes--;
	    composantes.remove(sc1);
	    composantes.remove(sc2);
	    composantes.add(sc1.union(sc2));
	}
    }

    // V�rifie que tous deux sommets adjacents ont des couleurs diff�rentes
    public boolean bienColore() {
	for(Sommet s : sommets) {
	    if (!s.bienColore()) return false;
	}
	return true;
    }

    // Prend les sommets dans l'ordre, affecte � chacun la plus petite couleur
    // disponible, et renvoie la couleur maximale utilis�e.
    public int colorie() {
	int couleurMax = 0;
	for(Sommet s : sommets) {
	    couleurMax = Math.max(couleurMax, s.colorie());
	}
	return couleurMax;
    }

}


