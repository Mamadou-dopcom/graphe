package Structure;

public class ListeChaineeSimple {
		// Variable d'instance
		Noeud tete;

		// Constructeurs
		public ListeChaineeSimple() {
			this.tete = null; // Crée une liste vide
		}

		public ListeChaineeSimple(int premier, ListeChaineeSimple reste) {
			this.tete = new Noeud(premier);
			this.tete.setSuivant(reste.tete);
		}

		private ListeChaineeSimple(Noeud n) {
			this.tete = n;
		}

		public boolean estVide() {	return this.tete == null; }

		public Noeud tete() { 
			if (tete == null) throw new IllegalStateException();
			return this.tete;
		}

		public ListeChaineeSimple queue() {
			if (tete == null) throw new IllegalStateException();

			return new ListeChaineeSimple(tete.getSuivant());
		}

		public void insererEnTete(int x) {
			this.tete = new Noeud(x, this.tete);
		}

		/***
		 * Insérer y après la première occurrence de x dans la liste, 
		 * uniquement si x est bien présent
		 * @param x est l'élément à rechercher
		 * @param y est l'élément à insérer si x est présent
		 */
		public void insererApres(int x, int y) {
			Noeud courant = tete;
			while (courant != null) {
				if (courant.getValeur() == x) {
					Noeud noeudY = new Noeud(y, courant.getSuivant());
					courant.setSuivant(noeudY);
					break;
				}
				courant = courant.getSuivant();
			}
		}

		/***
		 * Insère l'élément x en fin de la liste
		 * @param x l'élement à insérer
		 */
		public void insererEnQueue(int x) {
			// Cas où la liste est vide
			if (this.estVide()) this.tete = new Noeud(x);
			else {
				// Cas où la liste n'est pas vide, on parcourt jusqu'au dernier élément celui qui n'a pas de suivant
				Noeud courant = tete;
				while (courant.getSuivant() != null) {
					courant = courant.getSuivant();
				}
				courant.setSuivant(new Noeud(x));
			}
		}

		/***
		 * Supprime la première occurrence de x dans la liste, 
		 * si x est bien présent (ne fait rien sinon)
		 * @param x l'élément dont on supprime la première occurrence
		 */
		public void supprimer(int x ) {
			if (!this.estVide() && this.contient(x)) {
				// On teste si x est en tete 
				if (tete.getValeur() == x) {
					tete = tete.getSuivant();
				}
				else {
					// Recherche de l'élément qui précède x
					Noeud courant = tete;
					while (courant.getSuivant().getValeur() != x) {
						courant = courant.getSuivant();
					}	
					courant.setSuivant(courant.getSuivant().getSuivant());
				}
			}
			// il n'y a rien à faire si la liste est vide
		}



		/***
		 * Teste si x est présent dans la liste
		 * @param x : l'élément à rechercher
		 * @return true si x est présent, false sinon
		 */
		public boolean contient(int x) {
			boolean present = false;
			Noeud p = this.tete;

			while (p != null && !present) {
				if (x == p.getValeur()) present = true;
				p = p.getSuivant();
			}

			return present;
		}

		@Override
		public String toString() {
			String s = "[ ";

			if (this.estVide()) s = s + "Chaîne vide";
			else {
				// Parcours de la liste
				Noeud p = tete;
				while (p != null) {
					s = s + p.getValeur() + " ";
					// Avancer d'un noeud dans la liste
					p = p.getSuivant();
				} 
			}
			return s + "]";
		}
		
		public void concatener(ListeChaineeSimple l) {
			if (this.estVide()) {
			this.tete= l.tete;
			} 
			else {
				Noeud dernier= tete;
				while (dernier.getSuivant() != null) {
				dernier= dernier.getSuivant();
				}
				// Nous y sommes. dernier correspond au dernier élément
				// de la liste, qui existe car celle-ci n’est pas vide.
				// On fixe donc le suivant de ‘‘dernier’’ au premier
				// élément de la liste l.
				dernier.setSuivant(l.tete());
					
				}
			}



}
