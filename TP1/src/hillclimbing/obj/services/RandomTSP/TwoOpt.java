package neighbor.obj.services.RandomTSP;

import java.util.ArrayList;
import java.util.Collections;

public class TwoOpt {
	
	public ArrayList<ArrayList<Integer>> voisinageTwoOpt(ArrayList<Integer> chemin) {
		ArrayList<ArrayList<Integer>> voisinages = new ArrayList<ArrayList<Integer>>();
		int i = 1;
		int j;
		
		while (i < chemin.size()) {
			j = i+1;
			while (j < chemin.size()) {
				ArrayList<Integer> cycleModifier = new ArrayList<Integer>(chemin);
				Collections.reverse(cycleModifier.subList(i, j+1));		
				voisinages.add(cycleModifier);
				j++;		
			}
			i++;
		}
		return voisinages;
	}

}
