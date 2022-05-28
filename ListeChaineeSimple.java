package Structure;

public class ListeChaineeSimple {
		// Variable d'instance
		Noeud tete;

		// Constructeurs
		public ListeChaineeSimple() {
			this.tete = null; // Cr�e une liste vide
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
		 * Ins�rer y apr�s la premi�re occurrence de x dans la liste, 
		 * uniquement si x est bien pr�sent
		 * @param x est l'�l�ment � rechercher
		 * @param y est l'�l�ment � ins�rer si x est pr�sent
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
		 * Ins�re l'�l�ment x en fin de la liste
		 * @param x l'�lement � ins�rer
		 */
		public void insererEnQueue(int x) {
			// Cas o� la liste est vide
			if (this.estVide()) this.tete = new Noeud(x);
			else {
				// Cas o� la liste n'est pas vide, on parcourt jusqu'au dernier �l�ment celui qui n'a pas de suivant
				Noeud courant = tete;
				while (courant.getSuivant() != null) {
					courant = courant.getSuivant();
				}
				courant.setSuivant(new Noeud(x));
			}
		}

		/***
		 * Supprime la premi�re occurrence de x dans la liste, 
		 * si x est bien pr�sent (ne fait rien sinon)
		 * @param x l'�l�ment dont on supprime la premi�re occurrence
		 */
		public void supprimer(int x ) {
			if (!this.estVide() && this.contient(x)) {
				// On teste si x est en tete 
				if (tete.getValeur() == x) {
					tete = tete.getSuivant();
				}
				else {
					// Recherche de l'�l�ment qui pr�c�de x
					Noeud courant = tete;
					while (courant.getSuivant().getValeur() != x) {
						courant = courant.getSuivant();
					}	
					courant.setSuivant(courant.getSuivant().getSuivant());
				}
			}
			// il n'y a rien � faire si la liste est vide
		}



		/***
		 * Teste si x est pr�sent dans la liste
		 * @param x : l'�l�ment � rechercher
		 * @return true si x est pr�sent, false sinon
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

			if (this.estVide()) s = s + "Cha�ne vide";
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
				// Nous y sommes. dernier correspond au dernier �l�ment
				// de la liste, qui existe car celle-ci n�est pas vide.
				// On fixe donc le suivant de ��dernier�� au premier
				// �l�ment de la liste l.
				dernier.setSuivant(l.tete());
					
				}
			}



}
