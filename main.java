package Structure;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Je suis entrain de faire un test");

		Graphe mygraphePeudense = new Graphe();
		Graphe mygrapheDense = new Graphe();
		//mygraphePeudense.ajouteSommet(String.valueOf(2));
		//mygraphePeudense.afficheSommet();
		//Sommet s12 = new Sommet(mygraphePeudense,String.valueOf(mygraphePeudense.getRandomNumber(10,1)));
		//Sommet s22 = new Sommet(mygraphePeudense,String.valueOf(mygraphePeudense.RandomNumberRange(10,1,Integer.valueOf(s12.getNom()))));
		//mygraphePeudense.ajouteArete(s12,s22);
		//mygraphePeudense.afficheArete();
		//initialisation des sommets
		int n =1000 ;
		int compteur=0;
		int compteur1=0;
		for (int i = 1; i <= n;i++){
			mygraphePeudense.ajouteSommet(String.valueOf(i));
			mygrapheDense.ajouteSommet(String.valueOf(i));
		}

		for (int j = 1; j <=n ;j++){
			for (int i = 1; i <=3 ;i++) {
				if(j+i <=n) {
					Sommet s1 = new Sommet(mygraphePeudense,String.valueOf(j));
					Sommet s2 = new Sommet(mygraphePeudense,String.valueOf(j+i));
					mygraphePeudense.ajouteArete(s1,s2);
					compteur++;
					}
			}
			
		}

		for (int k = 1; k <=n ;k++){
			for (int l = 1; l <=n/3 ;l++){
				if(k+l <=n) {
				Sommet s1 = new Sommet(mygrapheDense,String.valueOf(k));
				Sommet s2 = new Sommet(mygrapheDense,String.valueOf(k+l));
				mygrapheDense.ajouteArete(s1,s2);
				compteur1++;
				}
			}
		}
		//mygraphePeudense.afficheSommet();
		//mygrapheDense.afficheArete();
		System.out.println(compteur);
		//mygraphePeudense.afficheArete();
		System.out.println(compteur1);
	}
	
	

}
