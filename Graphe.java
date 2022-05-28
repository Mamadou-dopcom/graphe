package Structure;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;

class Graphe {
	
	
    // Ensembles de sommets et d'ar�tes, directement repr�sent�s comme tels.
    private ArrayList<Sommet> sommets;
    private ArrayList<Arete> aretes;
    ArrayList<Arete> resultat=new ArrayList<>();
    // Une composante connexe est repr�sent�e par un sommet principal
    // Id�e : utiliser l'algorithme Union-Find de Tarjan (dans ce corrig�,
    // il y a au passage les optimisations "union par rangs" et "compression
    // de chemins".

    // Graphe vide : pas de sommets, pas d'ar�tes, pas de composantes.
    public Graphe() {
	sommets = new ArrayList<Sommet>();
	aretes = new ArrayList<Arete>();
	
    }

    // Ajout d'un sommet de nom [n]
    public void ajouteSommet(int n) {
	Sommet s = new Sommet(this, n);
	sommets.add(s);
    }

    // Ajout d'une ar�te entre deux sommets [s1] et [s2]
    
    public int ajouteArete(Sommet s1, Sommet s2) {
		int poids = this.getRandomNumber(1,1000);
			
			Arete a = new Arete(s1, s2, poids);
			if(this.AreteValid(a) == true) {
				aretes.add(a);
				sommets.add(s1);
				sommets.add(s2);
				return 1;
			}
		return 0;
    }

  

	//Prend en entré un nombre min et un nombre max et renvoie un nombre aleatoire dans l'interval
	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)+1) + min);
		}
	
	//Prend en entré un nombre min et un nombre max et l'exception renvoie un nombre aleatoire dans l'interval qui est different de l'exception 
	public int RandomNumberRange(int max, int min, int block){
	Random rand = new Random();
	int randomNum;

	do {
		randomNum = rand.nextInt((max - min) + 1) + min;
	} while (randomNum == block && (max != block && block != min));

	return randomNum;
	}

	public ArrayList<Sommet> getSommets() {
		return sommets;
	}

	public void setSommets(ArrayList<Sommet> sommets) {
		this.sommets = sommets;
	}

	public ArrayList<Arete> getAretes() {
		return aretes;
	}

	public void setAretes(ArrayList<Arete> aretes) {
		this.aretes = aretes;
	}


	public void afficheArete() {
		for(Arete a : aretes)
			System.out.println( a.toString());
			//System.out.println("test");
	}
	
	public void afficheSommet() {
		for(Sommet s : this.getSommets())
			System.out.println( s.toString());
	}
	
	public boolean AreteValid(Arete testarete) {
		boolean test=true;
		for(Arete a : aretes)
			if (a.equales(testarete)==0 || a.equales(testarete)==1)
				test=false;
		return test;
			//System.out.println("test");
	}
	
	public void AfficheArete() {
		for(Arete a : aretes)
			if(a.getExtremites()[1].getNom()==a.getExtremites()[0].getNom()+1)
				System.out.println( a.toString());
			//System.out.println("test");
	}

	/**public void lireFichier(String nom) throws IOException {
	    File fichier = new File(nom);
	    Scanner lecteur = new Scanner(fichier);
			
	    while(lecteur.hasNextInt()) {
		sommets.add(new Sommet(lecteur.nextInt(), lecteur.nextInt(), lecteur.nextInt()));
	    }
	}**/
	
	public void Kruskal(){
		int k=0;
		
		long debut = System.currentTimeMillis();
		
	    UnionFind unionfind = new UnionFind();
	    aretes.sort(Comparator.comparingInt(Arete::getPoids));
	    //this.afficheArete();
	    for(Sommet s : sommets) {
            unionfind.makeSet(s.getNom());
	    }
	    unionfind.toString();
	    while (k < sommets.size()-1) {
	        for (int i = 0; i < aretes.size(); i++) {
	            Arete arete = aretes.get(i);
	            if (unionfind.Find(arete.getExtremites()[0].getNom()) != unionfind.Find(arete.getExtremites()[1].getNom())) {
	                resultat.add(arete);
	                System.out.println("fait");
	                unionfind.Union(arete.getExtremites()[0].getNom(), arete.getExtremites()[1].getNom());
	            }
	        }
	        k++;
	    }
	    System.out.println((System.currentTimeMillis()-debut) + " millisecondes");
	    this.AfficheResult();
	    }
	
	 public void AfficheResult() {
		  for (Arete arete : resultat)
		    	arete.toString();
	  }	 

	
}
