package Structure;

import java.util.ArrayList;

public class UnionFind {
	// Variable d'instance
	ArrayList<Ensemble> parent = new ArrayList(); 
	Ensemble ensemble ;
		public void makeSet(int x) {
			boolean exist=false;
			for (Ensemble e : parent) {
				if (e.representant==x)
					exist = true;
			}
			if (!exist) {
				ensemble = new Ensemble(x);
				parent.add(ensemble);
			//System.out.println(ensemble.representant);
			}
		}

		
    public Ensemble Find(int x) {
		for (Ensemble ensemble : parent ) {
			if (ensemble.representant != null && ensemble.representant==x)
				return ensemble ;
    	}
		return null;
    }



    public void Union(int x, int y)  {
    	Ensemble  es1 = this.Find(x);
    	Ensemble  es2 = this.Find(y);
    	if (es1 != null && es2 != null) {
			if (es1.representant != es2.representant)
				es1.getListeChaineeS().concatener(es2.getListeChaineeS());
		 		//parent.remove(es2);
		 		
			}
   
    }
    


	public void afficheElement() {
		for (Ensemble ensemble : parent) 
			System.out.println(ensemble.toString());	
	}
    
    
    
                            
}
