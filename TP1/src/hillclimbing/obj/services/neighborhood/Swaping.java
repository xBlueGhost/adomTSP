package hillclimbing.obj.services.neighborhood;

import java.util.ArrayList;
import java.util.Collections;

import utils.Method;

public class Swaping {

	public static ArrayList<ArrayList<Integer>> swap(ArrayList<Integer> cities) {
		ArrayList<ArrayList<Integer>> voisinage = new ArrayList<ArrayList<Integer>>();
		int i = 1;
		int j;

		while (i < cities.size()) {
			j = i + 1;
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
	
	public static int[] swap(int[] path){
		int size = path.length;
		int firstToSwap = 0,secondToSwap = 0;
		while(firstToSwap==secondToSwap) {
			firstToSwap = Method.getRandomNumberInRange(0, size-1);
			secondToSwap = Method.getRandomNumberInRange(0, size-1);
		}
		int[] newPath = Method.copy(path);
		newPath[firstToSwap] = secondToSwap;
		newPath[secondToSwap] = firstToSwap;
		return newPath;
	}

}
