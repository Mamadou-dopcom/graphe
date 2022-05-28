package Structure;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Veuillez saisir un entier :");

		Graphe mygraphePeudense = new Graphe();
		
		Graphe mygrapheDense = new Graphe();
		Scanner saisieUtilisateur = new Scanner(System.in);
		int n = saisieUtilisateur.nextInt();
		//int n =100 ;
		int compteur=0;
		int compteur1=0;
		
		
		for (int j = 1; j <n ;j++){
			Sommet s1 = new Sommet(mygraphePeudense,j);
			Sommet s2 = new Sommet(mygraphePeudense,j+1);
			Sommet s3 = new Sommet(mygrapheDense,j);
			Sommet s4 = new Sommet(mygrapheDense,j+1);
			if (mygraphePeudense.ajouteArete(s1,s2)==1 && mygrapheDense.ajouteArete(s3, s4)==1)
				compteur++;
				compteur1++;
				
		}
	
		int j = 1;
		while (j <=3*n -(n-1)){ 
			
			Sommet s1 = new Sommet(mygraphePeudense,mygraphePeudense.getRandomNumber(n, 1));
			Sommet s2 = new Sommet(mygraphePeudense,mygraphePeudense.RandomNumberRange(n, 1, s1.getNom()));
			if (mygraphePeudense.ajouteArete(s1,s2)==1) {;
				compteur++;
				j++;
			}
		}
		
		int i =1;
		while (i <=(n*n/3)-(n-1)) {
			
			Sommet s3 = new Sommet(mygrapheDense,mygrapheDense.getRandomNumber(n, 1));
			Sommet s4 = new Sommet(mygrapheDense,mygrapheDense.RandomNumberRange(n, 1, s3.getNom()));
			if (mygrapheDense.ajouteArete(s3,s4)==1) {;
				compteur1++;
				i++;
				}
			}
		//mygraphePeudense.afficheSommet();
		//
		System.out.println("Nombre d'aretes formé pour "+ n+ " sommets d'un graphe Peu dense est :" +compteur);
		mygraphePeudense.AfficheArete();
		System.out.println("Nombre d'aretes formé pour "+ n+ " sommets d'un graphe Dense est :" +compteur1);
		mygrapheDense.AfficheArete();
		//System.out.println(compteur1);
		
	
		mygraphePeudense.afficheArete();
		System.out.println("____________________________________");
		mygraphePeudense.Kruskal();
		//mygraphePeudense.afficheArete();
		//kruskalalgo.tostring();
		
		//ListeChaineeSimple l = new ListeChaineeSimple ();
		//ListeChaineeSimple l2 = new ListeChaineeSimple();
		//int n = 5;
		//for (int i = 1; i <= n; i++) {
			//unionfind.makeSet(i);5
			
		//}
		
		//Ensemble ens2 = new Ensemble();
		
		//ens2.insererEnQueue(6);
		//ens2.insererEnQueue(7);
		//ens2.insererEnQueue(8);
		
		//unionfind.afficheElement();
		//unionfind.Union(2, 3);
		//unionfind.myremove(3);
		//System.out.println(l.toString());
		//System.out.println(l);
		//System.out.println("___________________________________________");
		//unionfind.afficheElement();
	}

}
