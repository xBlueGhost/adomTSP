package hillclimbing.obj.services.RandomTSP;

import java.util.ArrayList;

public class Initialization {
	
	public ArrayList<Integer> genereCheminAleatoire(int taille) {
		ArrayList<Integer> cycleTmp = new ArrayList<>();
		ArrayList<Integer> cycleAleatoire = new ArrayList<>();
		
		for (int i = 1; i <= taille; i++) {
			cycleTmp.add(i);
		}

		while (cycleTmp.size() != 0) {
			int x=0;
	        x=(int)( Math.random()*cycleTmp.size());
	        cycleAleatoire.add(cycleTmp.get(x));
	        cycleTmp.remove(x);
		}
		return cycleAleatoire;
	}
	
	public ArrayList<Integer> heuristiqueConstructive(Integer villeDepart, int[][] matrice) {
		ArrayList<Integer> chemin = new ArrayList<Integer>();
		
		return chemin;
	}

}
