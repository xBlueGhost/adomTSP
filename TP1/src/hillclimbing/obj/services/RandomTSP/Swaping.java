package neighbor.obj.services.RandomTSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import glouton.obj.RandomTSP;

public class Swaping {

	public static ArrayList<ArrayList<Integer>> swap(ArrayList<Integer> cities) {
		ArrayList<ArrayList<Integer>> voisinage = new ArrayList<ArrayList<Integer>>();
		int i = 1;
		int j;
		
		while (i < cities.size()) {
			j = i+1;
			while (j < cities.size()) {
				ArrayList<Integer> cycleModifier = new ArrayList<Integer>(cities);
				Collections.swap(cycleModifier, i, j);
				voisinage.add(cycleModifier);
				j++;
			}
			i++;
		}
		return voisinage;
	
}
}
