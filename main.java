
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Je suis entrain de faire un test");

		Graphe mygraphePeudense = new Graphe();
		Graphe mygrapheDense = new Graphe();
		//initialisation des sommets
		n = 10;
		for (int i = 1; i <= 10;i++){
			mygraphePeudense.ajouteSommet(String.valueOf(i));
			mygrapheDense.ajouteSommet(String.valueOf(i));
		}

		for (int j = 1; j <=3*n ;j++){
			Sommet s1 = new Sommet(mygraphePeudense.getRandomNumber(10,1));
			Sommet s2 = new Sommet(mygraphePeudense.RandomNumberRange(10,1,Integer.valueOf(s1.nom));
			mygrapheDense.ajouteArete(s1,s2);
		}

		for (int k = 1; k <=(n*n)/3 ;k++){
			Sommet s1 = new Sommet(mygrapheDense,String.valueOf(mygrapheDense.getRandomNumber(10,1)));
			Sommet s2 = new Sommet(mygrapheDense,String.valueOf(mygraphePeudense.RandomNumberRange(10,1,Integer.valueOf(s1.nom)));
			mygrapheDense.ajouteArete(s1,s2);
		}
	}

}
